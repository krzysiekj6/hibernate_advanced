package pl.com.bottega.cymes.admin.adapters;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.cymes.admin.Cinema;
import pl.com.bottega.cymes.admin.CinemaHall;
import pl.com.bottega.cymes.admin.CinemaHallRepository;
import pl.com.bottega.cymes.admin.CinemaRepository;
import pl.com.bottega.cymes.admin.CreateCinema;
import pl.com.bottega.cymes.admin.CreateCinemaHall;
import pl.com.bottega.cymes.admin.CreateMovie;
import pl.com.bottega.cymes.admin.Movie;
import pl.com.bottega.cymes.admin.MovieRepository;
import pl.com.bottega.cymes.admin.Place;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminEndpoints {

    private CinemaRepository cinemaRepository;
    private MovieRepository movieRepository;
    private CinemaHallRepository cinemaHallRepository;

    @PostMapping("/cinemas")
    @Transactional
    public void createCinema(@RequestBody CreateCinema createCinema) {
        Cinema cinema = Cinema.builder()
            .city(createCinema.city)
            .id(createCinema.cinemaId)
            .name(createCinema.name)
            .build();
        cinemaRepository.save(cinema);
    }

    @PostMapping("/movies")
    @Transactional
    public void createMovie(@RequestBody CreateMovie createMovie) {
        Movie movie = Movie.builder()
            .movieId(createMovie.movieId)
            .title(createMovie.title)
            .description(createMovie.description)
            .actors(createMovie.actors)
            .genres(createMovie.genres)
            .build();
    }

    @PostMapping("/halls")
    @Transactional
    public void createCinemaHall(@RequestBody CreateCinemaHall createCinemaHall){
        Cinema cinema = cinemaRepository.findById(createCinemaHall.cinemaId);
        List<Place> places = buildPlaces(createCinemaHall.seats);
        CinemaHall cinemaHall = buildCinemaHall(createCinemaHall, cinema, places);
        cinemaHallRepository.save(cinemaHall);
    }

    private List<Place> buildPlaces(String[][] seats) {
        List<Place> places = new LinkedList<>();
        for (int indexRow = 0; indexRow < seats.length; indexRow++) {
            for (int indexColumn = 0; indexColumn < seats[0].length; indexColumn++){
                Place place = buildPlace(indexRow, indexColumn, seats[indexRow][indexColumn]);
                places.add(place);
            }
        }
        return places;
    }

    private Place buildPlace(int indexRow, int indexColumn, String seatNumber) {
        Place place = Place.builder()
                .rowIndex(indexRow+1)
                .columnIndex(indexColumn+1)
                .build();

        if(!StringUtils.isEmpty(seatNumber)){
            place.setSeatNo(seatNumber);
        }
        return place;
    }

    private CinemaHall buildCinemaHall(@RequestBody CreateCinemaHall createCinemaHall, Cinema cinema, List<Place> places) {
        return CinemaHall.builder()
                    .cinema(cinema)
                    .hallName(createCinemaHall.hallName)
                    .id(createCinemaHall.hallId)
                    .places(places)
                    .build();
    }
}

package pl.com.bottega.cymes.admin;

import java.util.UUID;

import org.springframework.data.repository.Repository;

/**
 * Write a summarising sentence of this class first. Explain its responsibility afterwards. Don't explain how it works,
 * but rather what its purpose is. You may want to give usage examples, if helpful.
 * <p/>
 * TODO(KJANOWSK) Write sensible documentation for this class.
 * <p/>
 */
public interface CinemaHallRepository extends Repository<CinemaHall, UUID> {
    void save(CinemaHall cinemaHall);
}

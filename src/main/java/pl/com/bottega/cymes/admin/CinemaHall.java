package pl.com.bottega.cymes.admin;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CinemaHall {

    @Id
    public UUID id;

    @ManyToOne
    @JoinColumn(name = "CINEMA_ID")
    public Cinema cinema;

    public String hallName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "CINEMA_HALL_ID", nullable = false)
    public List<Place> places;
}



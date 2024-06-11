package org.alram.horroralarmbackend.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Table(name = "movie_theaters")
@Entity
public class MovieTheaters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Movie movieId;
    @ManyToOne
    private Theaters theatersId;

    public MovieTheaters() {
    }

    public MovieTheaters(Movie movieId, Theaters theatersId) {
        this.movieId = movieId;
        this.theatersId = theatersId;
    }

    public String theaterNames() {
        return theatersId.getName();
    }
}

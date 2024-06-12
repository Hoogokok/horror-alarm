package org.alram.horroralarmbackend.movie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "movie_id")
    private Movie movieId;
    @ManyToOne
    @JoinColumn(name = "theaters_id")
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

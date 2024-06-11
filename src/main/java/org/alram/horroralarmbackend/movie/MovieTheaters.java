package org.alram.horroralarmbackend.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import org.alram.horroralarmbackend.movie.upcoming.UpcomingMovie;

@Getter
@Table(name = "movie_theaters")
@Entity
public class MovieTheaters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UpcomingMovie movieId;
    @ManyToOne
    private Theaters theatersId;
}

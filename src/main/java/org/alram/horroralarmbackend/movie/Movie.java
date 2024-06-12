package org.alram.horroralarmbackend.movie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NonNull;

@Table(name = "upcoming_movie")
@Entity
@Getter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String title;
    @NonNull
    private String releaseDate;
    @NonNull
    private String poster_path;
    private String overview;
    @OneToMany(mappedBy = "movieId")
    private final List<MovieTheaters> movieTheaters = new ArrayList<>();

    public Movie() {
    }

    public Movie(String title, String releaseDate, String poster_path, String overview) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.poster_path = poster_path;
        this.overview = overview;
    }

    public List<String> theatersNames() {
        return movieTheaters.stream()
            .map(MovieTheaters::theaterNames)
            .toList();
    }

    public void addTheater(MovieTheaters movieTheaters) {
        this.movieTheaters.add(movieTheaters);
    }
}

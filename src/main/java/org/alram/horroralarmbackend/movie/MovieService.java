package org.alram.horroralarmbackend.movie;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieResponse> findUpcomingMovieByDate() {
        String today = LocalDate.now().toString();
        List<Movie> movies = movieRepository.findByReleaseDateAfter(today);
        return movies.stream()
            .sorted(Comparator.comparing(Movie::getReleaseDate))
            .map(this::convertToReleasingMovieResponse)
            .toList();
    }

    public List<MovieResponse> findReleasingMovies() {
        String today = LocalDate.now().toString();
        List<Movie> byReleaseDateBefore = movieRepository.findByReleaseDateBefore(
            today);

        return byReleaseDateBefore.stream()
            .map(this::convertToReleasingMovieResponse)
            .toList();
    }

    public MovieResponse convertToReleasingMovieResponse(Movie movie) {
        return new MovieResponse(
            movie.getId(),
            movie.getTitle(),
            movie.getReleaseDate(),
            movie.getPoster_path(),
            movie.getOverview(),
            movie.theatersNames()
        );
    }
}

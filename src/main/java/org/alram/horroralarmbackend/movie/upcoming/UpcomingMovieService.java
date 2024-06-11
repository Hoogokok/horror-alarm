package org.alram.horroralarmbackend.movie.upcoming;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import org.alram.horroralarmbackend.movie.releasing.MovieResponse;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UpcomingMovieService {

    private final UpcomingMovieRepository upcomingMovieRepository;

    public UpcomingMovieService(UpcomingMovieRepository upcomingMovieRepository) {
        this.upcomingMovieRepository = upcomingMovieRepository;
    }

    public List<MovieResponse> findUpcomingMovieByDate() {
        String today = LocalDate.now().toString();
        List<UpcomingMovie> upcomingMovies = upcomingMovieRepository.findByReleaseDateAfter(today);
        return upcomingMovies.stream()
            .sorted(Comparator.comparing(UpcomingMovie::getReleaseDate))
            .map(this::convertToReleasingMovieResponse)
            .toList();
    }

    public List<MovieResponse> findReleasingMovies() {
        String today = LocalDate.now().toString();
        List<UpcomingMovie> byReleaseDateBefore = upcomingMovieRepository.findByReleaseDateBefore(
            today);

        return byReleaseDateBefore.stream()
            .map(this::convertToReleasingMovieResponse)
            .toList();
    }

    public MovieResponse convertToReleasingMovieResponse(UpcomingMovie upcomingMovie) {
        return new MovieResponse(
            upcomingMovie.getId(),
            upcomingMovie.getTitle(),
            upcomingMovie.getReleaseDate(),
            upcomingMovie.getPoster_path(),
            upcomingMovie.getOverview(),
            upcomingMovie.theatersNames()
        );
    }
}

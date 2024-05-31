package org.alram.horroralarmbackend.movie.releasing;

import java.time.LocalDate;
import java.util.List;
import org.alram.horroralarmbackend.movie.UpcomingMovie;
import org.alram.horroralarmbackend.movie.UpcomingMovieRepository;
import org.springframework.stereotype.Service;

@Service
public class ReleasingMovieService {

    private final UpcomingMovieRepository upcomingMovieRepository;

    public ReleasingMovieService(UpcomingMovieRepository upcomingMovieRepository) {
        this.upcomingMovieRepository = upcomingMovieRepository;
    }

    public List<ReleasingMovieResponse> findReleasingMovies() {
        String today = LocalDate.now().toString();
        List<UpcomingMovie> byReleaseDateBefore = upcomingMovieRepository.findByReleaseDateBefore(
            today);

        return byReleaseDateBefore.stream()
            .map(upcomingMovie ->
                new ReleasingMovieResponse(
                    upcomingMovie.getId(),
                    upcomingMovie.getTitle(),
                    upcomingMovie.getReleaseDate(),
                    upcomingMovie.getPoster_path(),
                    upcomingMovie.getOverview()))
            .toList();
    }
}

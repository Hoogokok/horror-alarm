package org.alram.horroralarmbackend.movie;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import org.alram.horroralarmbackend.common.MessageRequest;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UpcomingMovieService {

    private final UpcomingMovieRepository upComingMovieRepository;

    public UpcomingMovieService(UpcomingMovieRepository upComingMovieRepository) {
        this.upComingMovieRepository = upComingMovieRepository;
    }

    public List<UpcomingMovieResponse> findUpcomingMovieByDate() {
        String today = LocalDate.now().toString();
        List<UpcomingMovie> upcomingMovies = upComingMovieRepository.findByReleaseDateAfter(today);
        return upcomingMovies.stream()
            .sorted(Comparator.comparing(UpcomingMovie::getReleaseDate))
            .map(upcomingMovie ->
                new UpcomingMovieResponse(
                    upcomingMovie.getId(),
                    upcomingMovie.getTitle(),
                    upcomingMovie.getReleaseDate(),
                    upcomingMovie.getPoster_path(),
                    upcomingMovie.getOverview()))
            .toList();
    }

    public List<MessageRequest> getUpcomingMoviesForTheWeek() {
        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusWeeks(1);
        List<UpcomingMovie> upcomingMovies = upComingMovieRepository.findByReleaseDateBetween(
            today.toString(), nextWeek.toString());
        return upcomingMovies.stream()
            .map(upcomingMovie ->
                new MessageRequest(
                    upcomingMovie.getTitle(),
                    upcomingMovie.getReleaseDate()))
            .toList();
    }
}

package org.alram.horroralarmbackend.movie;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.List;
import org.alram.horroralarmbackend.AlarmTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class MovieServiceTest extends AlarmTest {

    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    TheatersRepository theatersRepository;
    @Autowired
    MovieTheatersRepository movieTheatersRepository;

    @Test
    void findUpcomingMovieByDate() {
        // given
        LocalDate today = LocalDate.now();
        String nextWeek = today.plusWeeks(1).toString();
        Movie upcomingMovie1 = new Movie("title1", nextWeek, "poster1", "overview1");
        Movie upcomingMovie2 = new Movie("title2", nextWeek, "poster2", "overview2");

        movieRepository.save(upcomingMovie1);
        movieRepository.save(upcomingMovie2);

        // when
        List<MovieResponse> beforeReleaseDate = movieService.findUpcomingMovieByDate();

        // then
        assertThat(beforeReleaseDate).hasSize(2);
    }

    @DisplayName("다음주 개봉하는 영화 목록을 가져온다.")
    @Test
    void getUpcomingMoviesForTheWeek() {
        // given
        LocalDate today = LocalDate.now();
        String nextWeek = today.plusWeeks(1).toString();
        Movie upcomingMovie1 = new Movie("title1", nextWeek, "poster1", "overview1");
        Movie upcomingMovie2 = new Movie("title2", nextWeek, "poster2", "overview2");

        movieRepository.save(upcomingMovie1);
        movieRepository.save(upcomingMovie2);

        // when
        List<MovieResponse> upcomingMoviesForTheWeek = movieService.findUpcomingMovieByDate();

        // then
        assertThat(upcomingMoviesForTheWeek).hasSize(2);
        assertThat(upcomingMoviesForTheWeek.get(0).title()).isEqualTo("title1");
        assertThat(upcomingMoviesForTheWeek.get(1).title()).isEqualTo("title2");
    }

    @DisplayName("오늘 개봉하는 영화 목록을 가져온다.")
    @Test
    void findReleasingMovies() {
        // given
        LocalDate today = LocalDate.now();
        String todayString = today.toString();
        Movie releasingMovie1 = new Movie("title1", todayString, "poster1", "overview1");
        Movie releasingMovie2 = new Movie("title2", todayString, "poster2", "overview2");
        Theaters cgv = theatersRepository.save(new Theaters("CGV"));
        MovieTheaters movieTheaters = movieTheatersRepository.save(new MovieTheaters(releasingMovie1, cgv));
        MovieTheaters movieTheaters2 = movieTheatersRepository.save(new MovieTheaters(releasingMovie2, cgv));
        releasingMovie1.addTheater(movieTheaters);
        releasingMovie2.addTheater(movieTheaters2);
        movieRepository.save(releasingMovie1);
        movieRepository.save(releasingMovie2);

        // when
        List<MovieResponse> releasingMovies = movieService.findReleasingMovies();

        // then
        assertThat(releasingMovies).hasSize(2);
    }
}
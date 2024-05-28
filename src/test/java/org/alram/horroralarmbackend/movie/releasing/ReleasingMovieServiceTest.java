package org.alram.horroralarmbackend.movie.releasing;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import org.alram.horroralarmbackend.movie.UpcomingMovie;
import org.alram.horroralarmbackend.movie.UpcomingMovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties = {"cors.allowed.origins=http://localhost:3000",
    "cors.allowed.headers=*", "cors.allowed.methods=*"})
@ActiveProfiles("test")
@Transactional
class ReleasingMovieServiceTest {

    @Autowired
    private ReleasingMovieService releasingMovieService;
    @Autowired
    private UpcomingMovieRepository upcomingMovieRepository;

    @Test
    void findReleasingMovies() {
        // given
        String releaseDate = LocalDate.now().toString();
        String releaseDate2 = LocalDate.now().minusDays(1).toString();
        UpcomingMovie upcomingMovie = new UpcomingMovie("title1", releaseDate, "poster1",
            "overview1");
        UpcomingMovie upcomingMovie2 = new UpcomingMovie("title2", releaseDate2, "poster2",
            "overview2");
        upcomingMovieRepository.save(upcomingMovie);
        upcomingMovieRepository.save(upcomingMovie2);
        // when
        List<ReleasingMovieResponse> releasingMovies = releasingMovieService.findReleasingMovies();
        // then
        assertThat(releasingMovies).hasSize(2);
    }
}
package org.alram.horroralarmbackend.movie.upcoming;

import java.util.List;
import org.alram.horroralarmbackend.movie.releasing.MovieResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/api/upcoming")
    public ResponseEntity<List<MovieResponse>> upcoming() {
        return ResponseEntity.ok(movieService.findUpcomingMovieByDate());
    }

    @GetMapping("/api/releasing")
    public ResponseEntity<List<MovieResponse>> releasing() {
        return ResponseEntity.ok(movieService.findReleasingMovies());
    }
}

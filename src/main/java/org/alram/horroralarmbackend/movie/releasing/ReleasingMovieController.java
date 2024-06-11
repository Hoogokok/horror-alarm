package org.alram.horroralarmbackend.movie.releasing;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReleasingMovieController {

    private final ReleasingMovieService releasingMovieService;

    public ReleasingMovieController(ReleasingMovieService releasingMovieService) {
        this.releasingMovieService = releasingMovieService;
    }

    @GetMapping("/api/releasing")
    public ResponseEntity<List<MovieResponse>> releasing() {
        return ResponseEntity.ok(releasingMovieService.findReleasingMovies());
    }
}

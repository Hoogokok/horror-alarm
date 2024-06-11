package org.alram.horroralarmbackend.movie.upcoming;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UpcomingMovieController {

    private final UpcomingMovieService upComingMovieService;

    public UpcomingMovieController(UpcomingMovieService upComingMovieService) {
        this.upComingMovieService = upComingMovieService;
    }

    @GetMapping("/api/upcoming")
    public ResponseEntity<List<UpcomingMovieResponse>> upcoming() {
        return ResponseEntity.ok(upComingMovieService.findUpcomingMovieByDate());
    }
}

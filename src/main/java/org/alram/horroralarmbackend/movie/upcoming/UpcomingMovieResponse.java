package org.alram.horroralarmbackend.movie.upcoming;

public record UpcomingMovieResponse(Long id, String title, String releaseDate, String posterPath, String overview) {
}

package org.alram.horroralarmbackend.movie;

public record UpcomingMovieResponse(Long id, String title, String releaseDate, String posterPath, String overview) {
}

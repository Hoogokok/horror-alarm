package org.alram.horroralarmbackend.movie.releasing;

public record ReleasingMovieResponse(Long id, String title, String releaseDate, String posterPath, String overview) {

}

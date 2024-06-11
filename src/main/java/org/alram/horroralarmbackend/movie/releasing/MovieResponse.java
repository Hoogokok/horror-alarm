package org.alram.horroralarmbackend.movie.releasing;

import java.util.List;

public record MovieResponse(Long id, String title, String releaseDate, String posterPath,
                            String overview, List<String> theaters) {

}

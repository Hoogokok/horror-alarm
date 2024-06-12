package org.alram.horroralarmbackend.movie;

import java.util.List;

public record MovieResponse(Long id, String title, String releaseDate, String posterPath,
                            String overview, List<String> theaters) {

}

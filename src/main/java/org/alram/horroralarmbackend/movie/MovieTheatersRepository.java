package org.alram.horroralarmbackend.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieTheatersRepository extends JpaRepository<MovieTheaters, Long> {

}

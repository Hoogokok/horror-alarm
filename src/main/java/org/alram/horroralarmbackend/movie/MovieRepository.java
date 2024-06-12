package org.alram.horroralarmbackend.movie;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT u FROM Movie u WHERE u.releaseDate > :today")
    List<Movie> findByReleaseDateAfter(@Param("today") String today);

    @Query("SELECT u FROM Movie u WHERE u.releaseDate <= :today")
    List<Movie> findByReleaseDateBefore(@Param("today") String today);
}

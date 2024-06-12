package org.alram.horroralarmbackend;

import jakarta.transaction.Transactional;
import org.alram.horroralarmbackend.movie.MovieTheatersRepository;
import org.alram.horroralarmbackend.movie.Theaters;
import org.alram.horroralarmbackend.movie.TheatersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties = {"cors.allowed.origins=http://localhost:3000",
    "cors.allowed.headers=*", "cors.allowed.methods=*"})
@ActiveProfiles("test")
@Transactional
public class AlarmTest {
}

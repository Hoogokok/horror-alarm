package org.alram.horroralarmbackend.streaming;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.alram.horroralarmbackend.AlarmTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class NetflixExpiredServiceTest extends AlarmTest {

    @Autowired
    private NetflixExpiredService netflixExpiredService;
    @Autowired
    private NetflixHorrorExpiredEnRepository netflixHorrorExpiredEnRepository;
    @Autowired
    private NetflixHorrorKrRepository netflixHorrorKrRepository;

    @DisplayName("스트리밍 종료 예정인 넷플릭스 영화 목록을 가져온다.")
    @Test
    void getNetflixExpiredResponse() {
        // given

        netflixHorrorExpiredEnRepository.save(
            new NetflixHorrorExpiredEn(LocalDate.of(2024, 10, 1), 1L));
        netflixHorrorExpiredEnRepository.save(
            new NetflixHorrorExpiredEn(LocalDate.of(2024, 10, 2), 2L));
        netflixHorrorKrRepository.save(
            new NetflixHorrorKr("title1", 1L, "overview1", "posterPath1"));
        netflixHorrorKrRepository.save(
            new NetflixHorrorKr("title2", 2L, "overview2", "posterPath2"));

        // when
        var netflixExpiredResponse = netflixExpiredService.nextExpiringNetflixMovie();

        // then
        assertThat(netflixExpiredResponse.expiredMovies()).hasSize(2);
    }
}
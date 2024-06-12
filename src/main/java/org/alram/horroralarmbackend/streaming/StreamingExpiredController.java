package org.alram.horroralarmbackend.streaming;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StreamingExpiredController {

    private final NetflixExpiredService netflixExpiredService;

    public StreamingExpiredController(NetflixExpiredService netflixExpiredService) {
        this.netflixExpiredService = netflixExpiredService;
    }

    @GetMapping("/api/streaming/expired")
    public ExpiredResponse getNetflixExpiredResponse() {
        return netflixExpiredService.nextExpiringNetflixMovie();
    }

    @GetMapping("/api/streaming/expired/detail/{id}")
    public ExpiredDetailResponse getNetflixExpiredDetailResponse(@PathVariable("id") Long id) {
        return netflixExpiredService.getNetflixExpiredDetailResponse(id);
    }
}

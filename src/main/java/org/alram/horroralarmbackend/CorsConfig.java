package org.alram.horroralarmbackend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Value("${cors.allowed.origins}")
    private String allowedOrigins;
    @Value("${cors.allowed.headers}")
    private String allowedHeaders;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // CORS를 적용할 URL 패턴
            .allowedHeaders(allowedHeaders) // 허용할 Header
            .allowedOrigins(allowedOrigins) // 허용할 Origin
            .allowedMethods(HttpMethod.GET.name(), HttpMethod.OPTIONS.name()) // 허용할 HTTP Method
            .allowCredentials(true) // 클라이언트에서 쿠키 전송 허용
            .maxAge(3600); // 프리플라이트 요청 캐싱 시간 (초 단위)
    }
}
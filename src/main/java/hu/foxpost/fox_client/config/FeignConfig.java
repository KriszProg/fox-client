package hu.foxpost.fox_client.config;

import feign.codec.ErrorDecoder;
import hu.foxpost.fox_client.exception.FeignClientErrorDecoder;
import org.springframework.context.annotation.Bean;

public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new FeignClientErrorDecoder();
    }

}

package hu.foxpost.fox_client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        JsonMapperConfig.class,
        FeignConfig.class,
        OpenApiConfig.class,
})
public class ApplicationConfig {
}

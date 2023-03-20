package io.github.pitagoras3.springcloudcontextbug;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(IncorrectProperties.class)
public class CustomBootstrapConfiguration {

    @Bean
    public CustomPropertySourceLocator customPropertySourceLocator(IncorrectProperties incorrectProperties) {
        return new CustomPropertySourceLocator(incorrectProperties);
    }

}

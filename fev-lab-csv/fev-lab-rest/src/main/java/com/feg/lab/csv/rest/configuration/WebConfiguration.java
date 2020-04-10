package com.feg.lab.csv.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/10/2020
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    CorsFilter corsFilter() {
        return new CorsFilter();
    }
}

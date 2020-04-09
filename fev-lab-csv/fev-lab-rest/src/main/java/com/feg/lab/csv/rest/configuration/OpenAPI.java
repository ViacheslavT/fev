package com.feg.lab.csv.rest.configuration;

import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by: Viachaslau Tsitsiankou.
 * Date: 4/9/2020
 */
@Configuration
public class OpenAPI {

    @Bean
    public io.swagger.v3.oas.models.OpenAPI customOpenAPI(@Value("${springdoc.version}") String appVersion) {
        return new io.swagger.v3.oas.models.OpenAPI()
                .info(new Info().title("FEV csv REST API").version(appVersion).description(
                        "This is a gateway server API for manipulating with CSV files and database saved reports."));
    }
}

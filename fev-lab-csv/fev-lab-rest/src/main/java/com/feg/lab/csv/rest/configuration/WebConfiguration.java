package com.feg.lab.csv.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS;
import static org.springframework.http.HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN;
import static org.springframework.http.HttpHeaders.CACHE_CONTROL;

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

class CorsFilter implements Filter {

    public static final String ALLOW_HEADERS_VALUE = "Authorization,Keep-Alive,User-Agent,X-Requested-With,If-Modified-Since,Cache-Control,Content-Type,Accept,X-IFM-SID,X-IFM-SS,X-IFM-SUBSCRIPTION-ID";
    public static final String ALLOW_METHODS_VALUE = "GET,POST,DELETE,PUT,PATCH,OPTIONS,HEAD";
    public static final String CACHE_CONTROL_VALUE = "no-cache,no-store,must-revalidate";
    public static final String ALL = "*";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, ALL);
        response.setHeader(ACCESS_CONTROL_ALLOW_HEADERS, ALLOW_HEADERS_VALUE);
        response.setHeader(ACCESS_CONTROL_ALLOW_METHODS, ALLOW_METHODS_VALUE);
        response.setHeader(CACHE_CONTROL, CACHE_CONTROL_VALUE);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
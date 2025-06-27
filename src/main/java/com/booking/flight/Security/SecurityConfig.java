package com.booking.flight.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(e -> e.disable());
        HttpSecurity httpSecurity = http.authorizeHttpRequests(request -> request
                .requestMatchers("api/air-line/user").authenticated()
                .requestMatchers("api/air-line/passenger/name/{name}")
                .authenticated().anyRequest().permitAll());
        return http.build();
    }

}

package com.pravanjan.springwebsecurity.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final CustomJwtAuthenticationProvider customJwtAuthenticationProvider;
    private final SecurityWhiteListingConfig securityWhiteListingConfig;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin(formLogin->formLogin.disable())
                .httpBasic(httpBasic->httpBasic.disable())
                .authorizeHttpRequests(
                authorizeRequests -> authorizeRequests

                        .requestMatchers("/api/**").permitAll()
                        .anyRequest().authenticated())
                .oauth2ResourceServer(oauth2->
                        oauth2 .jwt(jwt->jwt.authenticationManager(customJwtAuthenticationProvider::authenticate))
                )
                .exceptionHandling(configure ->configure.authenticationEntryPoint(customAuthenticationEntryPoint));


        return httpSecurity.build();

    }
}

package com.proyecto.spring_boot_monolito.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${service.security.secure-key-username}")
    private String secureKeyUsername;

    @Value("${service.security.secure-key-password}")
    private String secureKeyPassword;

    @Value("${service.security.secure-key-username2}")
    private String secureKeyUsername2;

    @Value("${service.security.secure-key-password2}")
    private String secureKeyPassword2;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exception -> exception
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.sendRedirect("https://danifaleydev.com");
                        })
                )
                .httpBasic(httpBasic -> {})
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var encoder = new BCryptPasswordEncoder();

        var user1 = User.builder()
                .username(secureKeyUsername)
                .password(encoder.encode(secureKeyPassword))
                .roles("ADMIN")
                .build();

        var user2 = User.builder()
                .username(secureKeyUsername2)
                .password(encoder.encode(secureKeyPassword2))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

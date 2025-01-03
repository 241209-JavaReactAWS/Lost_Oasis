package com.Lost_Oasis.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }
}

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//<<<<<<< HEAD
//                .cors(cors -> {}) // Enable global CORS
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/login", "/register", "/hotel/create")) // Disable CSRF for specific endpoints
//                .authorizeHttpRequests(auth -> auth
//                        // Allow public access to hotel endpoints
//                        .requestMatchers(HttpMethod.GET, "/hotel/all", "/hotel/searching", "/hotel/filtering").permitAll()
//                        // Allow public access to login and registration
//                        .requestMatchers(HttpMethod.POST, "/register", "/login").permitAll()
//                        // Allow public access to resources under /public
//                        .requestMatchers(HttpMethod.GET, "/public/**").permitAll()
//                        // All other requests require authentication
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(basic -> {}) // Enable HTTP Basic Authentication
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)); // Always create a new session
//=======
//                .csrf(AbstractHttpConfigurer::disable);
//>>>>>>> main
//
//        return http.build();
//    }
//}



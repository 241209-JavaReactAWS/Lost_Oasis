package com.Lost_Oasis.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
                    .csrf(csrf -> csrf.ignoringRequestMatchers("/login", "/register"))
                    .authorizeHttpRequests(auth -> auth
                            // Allow public access to hotel endpoints
                            .requestMatchers(HttpMethod.GET, "/hotel/all", "/hotel/searching", "/hotel/filtering").permitAll()
                            // Allow public access to login and registration
                            .requestMatchers(HttpMethod.POST, "/register", "/login").permitAll()
                            // Allow public access to resources under /public
                            .requestMatchers(HttpMethod.GET, "/public/**").permitAll()
                            // All other requests require authentication
                            .anyRequest().authenticated()
                    )
                    .httpBasic(basic -> {}); // Enable HTTP Basic Authentication

            return http.build();
        }
    }

//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/login", "/register"))
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(HttpMethod.POST, "/register", "/login").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/public/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(basic -> {});
//
//        return http.build();
//    }


    /*
    CSRF protection enabled by default. Ensure it’s either disabled or properly configured to handle cross-origin requests.

Disable CSRF for Testing:
http.csrf(csrf -> csrf.disable());
Enable CSRF with Allowed Endpoints:
http.csrf(csrf -> csrf.ignoringRequestMatchers("/login", "/register"));

//Must allow cookies and credentials for the session to work:

http
    .csrf(csrf -> csrf.ignoringRequestMatchers("/login", "/register"))
    .authorizeHttpRequests(auth -> auth
        .requestMatchers("/register", "/login").permitAll()
        .anyRequest().authenticated()
    )
    .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
    .httpBasic(basic -> {})
    .cors(cors -> {}); // Enable CORS globally

     */

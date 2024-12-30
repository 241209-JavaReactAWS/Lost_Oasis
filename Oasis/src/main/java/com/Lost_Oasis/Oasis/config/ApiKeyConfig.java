package com.Lost_Oasis.Oasis.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class ApiKeyConfig {

    @Value("${google.maps.api.key}")
    private String googleMapsApiKey;

}


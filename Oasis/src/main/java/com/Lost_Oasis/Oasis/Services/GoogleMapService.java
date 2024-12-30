package com.Lost_Oasis.Oasis.Services;


import com.Lost_Oasis.Oasis.config.ApiKeyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleMapService {

    private ApiKeyConfig apiKeyConfig;

    @Autowired
    public void GoogleMapsService(ApiKeyConfig apiKeyConfig) {
        this.apiKeyConfig = apiKeyConfig;
    }

    private final RestTemplate restTemplate = new RestTemplate();

    public GoogleMapService(ApiKeyConfig apiKeyConfig) {
        this.apiKeyConfig = apiKeyConfig;
    }

    public String geocodeLocation(String address) {
        String apiKey = apiKeyConfig.getGoogleMapsApiKey();
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + address + "&key=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }
}

package com.Lost_Oasis.Oasis.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.*;

@Service
public class HotelSearchService {

    @Value("${google.maps.api.key}")
    private String googleApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String searchHotelsByLocation(String address) {
        // Step 1: Get Geocode (lat, lng)
        String geocodeUrl = "https://maps.googleapis.com/maps/api/geocode/json?address="
                + address + "&key=" + googleApiKey;
        String geocodeResponse = restTemplate.getForObject(geocodeUrl, String.class);

        // Parse the JSON response to extract coordinates (lat, lng)
        double lat = extractLatitude(geocodeResponse);  // Implement parsing logic
        double lng = extractLongitude(geocodeResponse); // Implement parsing logic

        // Step 2: Search Nearby Hotels
        String placesUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"
                + "?location=" + lat + "," + lng
                + "&radius=10000&type=lodging"
                + "&key=" + googleApiKey;
        return restTemplate.getForObject(placesUrl, String.class);
    }

    private double extractLatitude(String geocodeResponse) {
        // JSON parsing logic (e.g., using Jackson or Gson)
        return 40.712776; // Replace with actual parsed value
    }

    private double extractLongitude(String geocodeResponse) {
        // JSON parsing logic (e.g., using Jackson or Gson)
        return -74.005974; // Replace with actual parsed value
    }
}

/*
How the geocoding API works with other service logics in the location-based searching & pass the data to the Google Places API to search for nearby hotels?
   1. Getting the latitude and longtitude from the Geocoding API, pass the data to PlacesAPI to search for nearby hotels
   Example workflow:
   String placesUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"
                 + "?location=40.712776,-74.005974"
                 + "&radius=10000&type=lodging"
                 + "&key=" + googleApiKey;

   2. Filter Hotels by Distance
      Use Lat and Lon to calculate distances between the user's location and available hotels
      Example distance calculation:
      public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
    // Haversine formula for distance between two points on Earth
    double earthRadius = 6371; // km
    double dLat = Math.toRadians(lat2 - lat1);
    double dLon = Math.toRadians(lon2 - lon1);
    double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
             + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
             * Math.sin(dLon / 2) * Math.sin(dLon / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return earthRadius * c;
}




 */

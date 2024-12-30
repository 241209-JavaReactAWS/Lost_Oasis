package com.Lost_Oasis.Oasis.Controllers;

import com.Lost_Oasis.Oasis.Services.GoogleMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class LocationController {

    GoogleMapService googleMapService;

    @Autowired
    public LocationController(GoogleMapService googleMapService) {
        this.googleMapService = googleMapService;

    }

    @GetMapping("/searching/location/geocode")

}

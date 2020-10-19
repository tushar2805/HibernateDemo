package com.github.hibernatedemo.hibernatedemo.controller;

import com.github.hibernatedemo.hibernatedemo.model.Location;
import com.github.hibernatedemo.hibernatedemo.model.User;
import com.github.hibernatedemo.hibernatedemo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/locations")
    public List<Location> getAllLocations() {
        return locationService.findAll();
    }

    @GetMapping("/locations/{id}")
    public Optional<Location> getLocationById(@PathVariable Integer id) {
        return locationService.findById(id);
    }

    @GetMapping("/location/{id}/users")
    public List<User> getUserByLocation(@PathVariable Integer id){
        Optional<Location> location = locationService.findById(id);
        if (location.isPresent()){
            Location newLocation = location.get();
            return newLocation.getUsers();
        }
        return null;
    }

    @PostMapping("/locations/addNew")
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }

    @PutMapping("/locations/{id}/update")
    public void updateLocation(@RequestBody Location location){
        locationService.updateLocation(location);
    }
}

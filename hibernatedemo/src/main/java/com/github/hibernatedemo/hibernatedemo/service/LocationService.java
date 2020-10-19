package com.github.hibernatedemo.hibernatedemo.service;

import com.github.hibernatedemo.hibernatedemo.model.Location;
import com.github.hibernatedemo.hibernatedemo.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> findAll() {
        return (List<Location>) locationRepository.findAll();
    }

    public Optional<Location> findById(Integer id) {
        return locationRepository.findById(id);
    }

    public void addLocation(Location location){
        locationRepository.save(location);
    }

    public void updateLocation(Location location){
        locationRepository.save(location);
    }
}
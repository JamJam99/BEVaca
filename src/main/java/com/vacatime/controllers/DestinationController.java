package com.vacatime.controllers;


import java.util.List;

import com.vacatime.models.Destination;
import com.vacatime.services.DestinationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("destinations")
public class  DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public List<Destination> findAllDestinations() {
        return destinationService.findAll();
    }


    @GetMapping("{id}")
    public Destination findDestinationById(@PathVariable("id") Long id) {
        return destinationService.findDestinationById(id);
    }
    
}

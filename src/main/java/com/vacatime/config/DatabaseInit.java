package com.vacatime.config;

import com.vacatime.models.Destination;
import com.vacatime.models.Package;
import com.vacatime.repositories.DestinationRepository;
import com.vacatime.repositories.PackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseInit {

    @Autowired
    private PackageRepository packageRepository;
    @Autowired
    private DestinationRepository destinationRepository;

    @PostConstruct
    public void init() {
        Destination destination = new Destination();
        destination.setCity("");
        destination.setDescription("");
        Destination destinationDb = destinationRepository.save(destination);

        Package aPackage = new Package();
        aPackage.setPrice(100.0);
        aPackage.setFacilities("Some facilities");
        aPackage.setItineraries("Some Itineraries");
        aPackage.setDestination(destinationDb);
        packageRepository.save(aPackage);
    }
}

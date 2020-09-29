package com.vacatime.controllers;

import com.vacatime.models.Package;
import com.vacatime.services.PackageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("package")
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping
    public List<Package> findAllPackages() {
        return packageService.findAll();
    }

    @GetMapping("{id}")
    public Package findPackageById(@PathVariable("id") Long id) {
        return packageService.findById(id);
    }

}

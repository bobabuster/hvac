package com.lwu.hvac.controller;

import com.lwu.hvac.unit.*;
import com.lwu.hvac.service.HvacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hvac")
public class Controller {

    private final HvacService hvacService;

    @Autowired
    public Controller(HvacService hvacService) {
        this.hvacService = hvacService;
    }

    // Get all brands
    @GetMapping("/brands")
    public List<Brand> getAllBrands() {
        return hvacService.getAllBrands();
    }

    // Get categories by brand name
    @GetMapping("/brands/{brandName}/categories")
    public List<Category> getCategoriesByBrand(@PathVariable String brandName) {
        return hvacService.getCategoriesByBrand(brandName);
    }

    // Get models by brand and category name
    @GetMapping("/brands/{brandName}/categories/{categoryName}/models")
    public List<Model> getModelsByCategory(
            @PathVariable String brandName,
            @PathVariable String categoryName) {
        return hvacService.getModelsByCategory(brandName, categoryName);
    }

    // Search by keyword (brands and models)
    @GetMapping("/search")
    public List<String> searchByKeyword(@RequestParam String keyword) {
        return hvacService.searchByKeyword(keyword);
    }
}

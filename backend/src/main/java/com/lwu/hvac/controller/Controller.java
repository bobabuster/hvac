package com.lwu.hvac.controller;

import com.lwu.hvac.dto.SearchResult;
import com.lwu.hvac.service.HvacService;
import com.lwu.hvac.unit.Brand;
import com.lwu.hvac.unit.ModelLine;
import com.lwu.hvac.unit.ModelVariant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hvac")
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @Autowired
    private HvacService hvacService;

    // GET /api/hvac/brands
    @GetMapping("/brands")
    public List<Brand> getAllBrands() {
        return hvacService.getAllBrands();
    }

    // GET /api/hvac/brands/{brandName}/model-lines
    @GetMapping("/brands/{brandName}/model-lines")
    public List<ModelLine> getModelLinesByBrand(@PathVariable String brandName) {
        return hvacService.getModelLinesByBrand(brandName);
    }

    // GET /api/hvac/brands/{brandName}/model-lines/{modelLineName}/variants
    @GetMapping("/brands/{brandName}/model-lines/{modelLineName}/variants")
    public List<ModelVariant> getVariantsByBrandAndLine(
            @PathVariable String brandName,
            @PathVariable String modelLineName
    ) {
        return hvacService.getVariantsByBrandAndLine(brandName, modelLineName);
    }

    // GET /api/hvac/search?keyword=...
    @GetMapping("/search")
    public List<SearchResult> searchByKeyword(@RequestParam String keyword) {
        return hvacService.searchByKeyword(keyword);
    }
}

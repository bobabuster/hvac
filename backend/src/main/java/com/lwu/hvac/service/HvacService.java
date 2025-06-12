package com.lwu.hvac.service;

import com.lwu.hvac.dto.SearchResult;
import com.lwu.hvac.unit.Brand;
import com.lwu.hvac.unit.ModelTypes;
import com.lwu.hvac.unit.ModelVariant;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HvacService {

    private List<Brand> brands = new ArrayList<>();

    @PostConstruct
    public void initData() {

    }


    public List<Brand> getAllBrands() {
        return brands;
    }

    public List<ModelTypes> getModelTypesByBrand(String brandName) {
        return brands.stream()
                .filter(b -> b.getName().equalsIgnoreCase(brandName))
                .map(Brand::getModelTypes)
                .findFirst()
                .orElse(List.of());
    }

    public List<ModelVariant> getVariantsByBrandAndType(String brandName, String modelTypeName) {
        return brands.stream()
                .filter(b -> b.getName().equalsIgnoreCase(brandName))
                .flatMap(b -> b.getModelTypes().stream())
                .filter(ml -> ml.getName().equalsIgnoreCase(modelTypeName))
                .map(ModelTypes::getVariants)
                .findFirst()
                .orElse(List.of());
    }

    public List<SearchResult> searchByKeyword(String keyword) {
        List<SearchResult> results = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase();

        for (Brand brand : brands) {
            if (brand.getName().toLowerCase().startsWith(lowerKeyword)) {
                results.add(new SearchResult("brand", brand.getName()));
            }

            for (ModelTypes line : brand.getModelTypes()) {
                for (ModelVariant variant : line.getVariants()) {
                    if (variant.getName().toLowerCase().startsWith(lowerKeyword)) {
                        results.add(new SearchResult(
                                "modelVariant",
                                variant.getName(),
                                brand.getName(),
                                line.getName()
                        ));
                    }
                }
            }
        }

        return results;
    }
}

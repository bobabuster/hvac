package com.lwu.hvac.service;

import com.lwu.hvac.unit.Brand;
import com.lwu.hvac.unit.Category;
import com.lwu.hvac.unit.Model;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@Service
public class HvacService {

    private List<Brand> brands = new ArrayList<>();

    @PostConstruct
    public void initData() {
        // Carrier
        Model carrierAC1 = new Model(
                "Infinity 26 Air Conditioner",
                "208/230V",
                "Single Phase",
                "https://www.carrier.com/residential/en/us/products/air-conditioners/24vna6/"
        );
        Model carrierAC2 = new Model(
                "Comfort 15 Central Air Conditioner",
                "208/230V",
                "Single Phase",
                "https://www.carrier.com/residential/en/us/products/air-conditioners/24aaa5/"
        );
        Category carrierAC = new Category("Air Conditioners", List.of(carrierAC1, carrierAC2));

        Model carrierFurnace = new Model(
                "Performance 96 Gas Furnace",
                "115V",
                "Single Phase",
                "https://www.carrier.com/residential/en/us/products/furnaces/59tp6/"
        );
        Category carrierFurnaces = new Category("Furnaces", List.of(carrierFurnace));

        Brand carrier = new Brand("Carrier", List.of(carrierAC, carrierFurnaces));

        // Trane
        Model traneHP1 = new Model(
                "XR14",
                "208/230V",
                "Single Phase",
                "https://www.trane.com/residential/en/products/heat-pumps/xr14-heat-pump.html"
        );
        Model traneHP2 = new Model(
                "XV18",
                "208/230V",
                "Three Phase",
                "https://www.trane.com/residential/en/products/heat-pumps/xv18-variable-speed-heat-pump.html"
        );
        Category traneHeatPumps = new Category("Heat Pumps", List.of(traneHP1, traneHP2));

        Model traneHandler = new Model(
                "TEM6",
                "240V",
                "Single Phase",
                "https://www.trane.com/residential/en/products/air-handlers/tem6.html"
        );
        Category traneHandlers = new Category("Air Handlers", List.of(traneHandler));

        Brand trane = new Brand("Trane", List.of(traneHeatPumps, traneHandlers));

        // Lennox
        Model lennoxAC = new Model(
                "XC21",
                "208/230V",
                "Single Phase",
                "https://www.lennox.com/products/heating-cooling/air-conditioners/xc21"
        );
        Category lennoxACs = new Category("Air Conditioners", List.of(lennoxAC));

        Model lennoxFurnace = new Model(
                "EL296V",
                "120V",
                "Single Phase",
                "https://www.lennox.com/products/heating-cooling/furnaces/el296v"
        );
        Category lennoxFurnaces = new Category("Furnaces", List.of(lennoxFurnace));

        Brand lennox = new Brand("Lennox", List.of(lennoxACs, lennoxFurnaces));

        // Add to brands list
        brands = List.of(carrier, trane, lennox);
    }

    public List<Brand> getAllBrands() {
        return brands;
    }

    public List<Category> getCategoriesByBrand(String brandName) {
        return brands.stream()
                .filter(b -> b.getName().equalsIgnoreCase(brandName))
                .map(Brand::getCategories)
                .findFirst()
                .orElse(new ArrayList<>());
    }

    public List<Model> getModelsByCategory(String brandName, String categoryName) {
        return brands.stream()
                .filter(b -> b.getName().equalsIgnoreCase(brandName))
                .flatMap(b -> b.getCategories().stream())
                .filter(c -> c.getName().equalsIgnoreCase(categoryName))
                .flatMap(c -> c.getModels().stream())
                .collect(Collectors.toList());
    }

    public List<String> searchByKeyword(String keyword) {
        String lower = keyword.toLowerCase();
        List<String> results = new ArrayList<>();

        brands.stream()
                .filter(b -> b.getName().toLowerCase().contains(lower))
                .forEach(b -> results.add("Brand: " + b.getName()));

        brands.stream()
                .flatMap(b -> b.getCategories().stream())
                .flatMap(c -> c.getModels().stream())
                .filter(m -> m.getName().toLowerCase().contains(lower))
                .forEach(m -> results.add("Model: " + m.getName()));

        return results;
    }
}


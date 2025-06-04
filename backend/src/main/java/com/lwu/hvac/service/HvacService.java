package com.lwu.hvac.service;

import com.lwu.hvac.dto.SearchResult;
import com.lwu.hvac.unit.Brand;
import com.lwu.hvac.unit.ModelLine;
import com.lwu.hvac.unit.ModelVariant;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HvacService {

    private List<Brand> brands = new ArrayList<>();

    @PostConstruct
    public void initData() {
        // Carrier Brand
        ModelVariant carrierInfinity26_1 = new ModelVariant(
                "Infinity 26 Air Conditioner - 2 Ton",
                "208/230V",
                "Single Phase",
                "https://www.carrier.com/residential/en/us/products/air-conditioners/24vna6/2-ton"
        );
        ModelVariant carrierInfinity26_2 = new ModelVariant(
                "Infinity 26 Air Conditioner - 3 Ton",
                "208/230V",
                "Single Phase",
                "https://www.carrier.com/residential/en/us/products/air-conditioners/24vna6/3-ton"
        );
        ModelLine carrierInfinity26 = new ModelLine(
                "Infinity 26 Air Conditioner",
                List.of(carrierInfinity26_1, carrierInfinity26_2)
        );

        ModelVariant carrierComfort15_1 = new ModelVariant(
                "Comfort 15 Central Air Conditioner - 1.5 Ton",
                "208/230V",
                "Single Phase",
                "https://www.carrier.com/residential/en/us/products/air-conditioners/24aaa5/1.5-ton"
        );
        ModelLine carrierComfort15 = new ModelLine(
                "Comfort 15 Central Air Conditioner",
                List.of(carrierComfort15_1)
        );

        ModelVariant carrierPerformance96Furnace = new ModelVariant(
                "Performance 96 Gas Furnace - 80K BTU",
                "115V",
                "Single Phase",
                "https://www.carrier.com/residential/en/us/products/furnaces/59tp6/80k-btu"
        );
        ModelLine carrierPerformance96 = new ModelLine(
                "Performance 96 Gas Furnace",
                List.of(carrierPerformance96Furnace)
        );

        Brand carrier = new Brand(
                "Carrier",
                List.of(carrierInfinity26, carrierComfort15, carrierPerformance96)
        );

        // Trane Brand
        ModelVariant traneXR14_1 = new ModelVariant(
                "XR14 - 2 Ton",
                "208/230V",
                "Single Phase",
                "https://www.trane.com/residential/en/products/heat-pumps/xr14-2-ton.html"
        );
        ModelVariant traneXR14_2 = new ModelVariant(
                "XR14 - 3 Ton",
                "208/230V",
                "Single Phase",
                "https://www.trane.com/residential/en/products/heat-pumps/xr14-3-ton.html"
        );
        ModelLine traneXR14 = new ModelLine(
                "XR14",
                List.of(traneXR14_1, traneXR14_2)
        );

        ModelVariant traneXV18 = new ModelVariant(
                "XV18",
                "208/230V",
                "Three Phase",
                "https://www.trane.com/residential/en/products/heat-pumps/xv18-variable-speed-heat-pump.html"
        );
        ModelLine traneXV18Line = new ModelLine(
                "XV18",
                List.of(traneXV18)
        );

        ModelVariant traneTEM6 = new ModelVariant(
                "TEM6 Air Handler",
                "240V",
                "Single Phase",
                "https://www.trane.com/residential/en/products/air-handlers/tem6.html"
        );
        ModelLine traneTEM6Line = new ModelLine(
                "TEM6 Air Handler",
                List.of(traneTEM6)
        );

        Brand trane = new Brand(
                "Trane",
                List.of(traneXR14, traneXV18Line, traneTEM6Line)
        );

        // Lennox Brand
        ModelVariant lennoxXC21 = new ModelVariant(
                "XC21 Air Conditioner",
                "208/230V",
                "Single Phase",
                "https://www.lennox.com/products/heating-cooling/air-conditioners/xc21"
        );
        ModelLine lennoxXC21Line = new ModelLine(
                "XC21",
                List.of(lennoxXC21)
        );

        ModelVariant lennoxEL296V = new ModelVariant(
                "EL296V Gas Furnace",
                "120V",
                "Single Phase",
                "https://www.lennox.com/products/heating-cooling/furnaces/el296v"
        );
        ModelLine lennoxEL296VLine = new ModelLine(
                "EL296V",
                List.of(lennoxEL296V)
        );

        Brand lennox = new Brand(
                "Lennox",
                List.of(lennoxXC21Line, lennoxEL296VLine)
        );

        // Rheem Brand
        ModelVariant rheemClassicPlusAC = new ModelVariant(
                "Classic Plus Air Conditioner 2 Ton",
                "208/230V",
                "Single Phase",
                "https://www.rheem.com/products/classic-plus-air-conditioners-2-ton"
        );
        ModelVariant rheemClassicPlusAC3 = new ModelVariant(
                "Classic Plus Air Conditioner 3 Ton",
                "208/230V",
                "Single Phase",
                "https://www.rheem.com/products/classic-plus-air-conditioners-3-ton"
        );
        ModelLine rheemClassicPlusLine = new ModelLine(
                "Classic Plus Air Conditioner",
                List.of(rheemClassicPlusAC, rheemClassicPlusAC3)
        );

        ModelVariant rheemPrestigeFurnace = new ModelVariant(
                "Prestige Gas Furnace 80K BTU",
                "120V",
                "Single Phase",
                "https://www.rheem.com/products/prestige-gas-furnace-80k"
        );
        ModelLine rheemPrestigeLine = new ModelLine(
                "Prestige Gas Furnace",
                List.of(rheemPrestigeFurnace)
        );

        Brand rheem = new Brand(
                "Rheem",
                List.of(rheemClassicPlusLine, rheemPrestigeLine)
        );

        // Goodman Brand
        ModelVariant goodmanGSX13 = new ModelVariant(
                "GSX13 Air Conditioner",
                "208/230V",
                "Single Phase",
                "https://www.goodmanmfg.com/products/gsx13"
        );
        ModelLine goodmanGSX13Line = new ModelLine(
                "GSX13",
                List.of(goodmanGSX13)
        );

        ModelVariant goodmanGMVC96 = new ModelVariant(
                "GMVC96 Gas Furnace",
                "120V",
                "Single Phase",
                "https://www.goodmanmfg.com/products/gmvc96"
        );
        ModelLine goodmanGMVC96Line = new ModelLine(
                "GMVC96",
                List.of(goodmanGMVC96)
        );

        Brand goodman = new Brand(
                "Goodman",
                List.of(goodmanGSX13Line, goodmanGMVC96Line)
        );

        // Add all brands to the list
        brands = List.of(carrier, trane, lennox, rheem, goodman);
    }


    public List<Brand> getAllBrands() {
        return brands;
    }

    public List<ModelLine> getModelLinesByBrand(String brandName) {
        return brands.stream()
                .filter(b -> b.getName().equalsIgnoreCase(brandName))
                .map(Brand::getModelLines)
                .findFirst()
                .orElse(List.of());
    }

    public List<ModelVariant> getVariantsByBrandAndLine(String brandName, String modelLineName) {
        return brands.stream()
                .filter(b -> b.getName().equalsIgnoreCase(brandName))
                .flatMap(b -> b.getModelLines().stream())
                .filter(ml -> ml.getName().equalsIgnoreCase(modelLineName))
                .map(ModelLine::getVariants)
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

            for (ModelLine line : brand.getModelLines()) {
                for (ModelVariant variant : line.getVariants()) {
                    if (variant.getName().toLowerCase().startsWith(lowerKeyword)) {
                        results.add(new SearchResult(
                                "model",
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

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
                "https://cematraining.com/wp-content/uploads/2022/07/sw_infinity_notes_grnspd_1000-1.pdf"
        );
        ModelVariant carrierInfinity26_2 = new ModelVariant(
                "Infinity 26 Air Conditioner - 3 Ton",
                "208/230V",
                "Single Phase",
                "https://cematraining.com/wp-content/uploads/2022/07/sw_infinity_notes_grnspd_1000-1.pdf"
        );
        ModelLine carrierInfinity26 = new ModelLine(
                "Infinity 26 Air Conditioner",
                List.of(carrierInfinity26_1, carrierInfinity26_2)
        );

        ModelVariant carrierComfort15_1 = new ModelVariant(
                "Comfort 15 Central Air Conditioner - 1.5 Ton",
                "208/230V",
                "Single Phase",
                "https://www.shareddocs.com/hvac/docs/1009/Public/03/OG-ACR410GEN-03.pdf"
        );
        ModelLine carrierComfort15 = new ModelLine(
                "Comfort 15 Central Air Conditioner",
                List.of(carrierComfort15_1)
        );

        ModelVariant carrierPerformance96Furnace = new ModelVariant(
                "Performance 96 Gas Furnace - 80K BTU",
                "115V",
                "Single Phase",
                "https://www.shareddocs.com/hvac/docs/1009/Public/0B/OM9GFRC-02.pdf"
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
                "https://manuals.plus/trane/xr14-heat-pump-air-conditioner-manual"
        );
        ModelVariant traneXR14_2 = new ModelVariant(
                "XR14 - 3 Ton",
                "208/230V",
                "Single Phase",
                "https://manuals.plus/trane/xr14-heat-pump-air-conditioner-manual"
        );
        ModelLine traneXR14 = new ModelLine(
                "XR14",
                List.of(traneXR14_1, traneXR14_2)
        );

        ModelVariant traneXV18 = new ModelVariant(
                "XV18",
                "208/230V",
                "Three Phase",
                "https://www.trane.com/residential/en/assets/product-brochures/TT_72-1209-R-37_TR_HeatPump_Brochure_proof_053024.pdf"
        );
        ModelLine traneXV18Line = new ModelLine(
                "XV18",
                List.of(traneXV18)
        );

        ModelVariant traneTEM6 = new ModelVariant(
                "TEM6 Air Handler",
                "240V",
                "Single Phase",
                "https://www.trane.com/content/dam/Trane/Commercial/global/products-systems/equipment/unitary/split-systems/Small%20Splits/Air%20Handlers/18-GF74D1-1F-EN.pdf"
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
                "http://pts.myrheem.com/docstore/webdocs/Public/ServicePublic/Trouble2a/pdfs/AC/RA17/RA17_A11-223_Rev3.pdf"
        );
        ModelVariant rheemClassicPlusAC3 = new ModelVariant(
                "Classic Plus Air Conditioner 3 Ton",
                "208/230V",
                "Single Phase",
                "http://pts.myrheem.com/docstore/webdocs/Public/ServicePublic/Trouble2a/pdfs/AC/RA17/RA17_A11-223_Rev3.pdf"
        );
        ModelLine rheemClassicPlusLine = new ModelLine(
                "Classic Plus Air Conditioner",
                List.of(rheemClassicPlusAC, rheemClassicPlusAC3)
        );

        ModelVariant rheemPrestigeFurnace = new ModelVariant(
                "Prestige Gas Furnace 80K BTU",
                "120V",
                "Single Phase",
                "http://pts.myrheem.com/docstore/webdocs/Public/ServicePublic/Trouble2a/pdfs/Gas_Furnace/IO/92-24161-77-00_RGLE_RGPE.pdf"
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
                "https://www.powerequipmentdirect.com/manuals/GSX13Tech.pdf?srsltid=AfmBOoo6Ew2N__4EqgnXCqsixcFKBZYsSzWb5-a12BRplmtj9o7Cov_j"
        );
        ModelLine goodmanGSX13Line = new ModelLine(
                "GSX13",
                List.of(goodmanGSX13)
        );

        ModelVariant goodmanGMVC96 = new ModelVariant(
                "GMVC96 Gas Furnace",
                "120V",
                "Single Phase",
                "https://www.powerequipmentdirect.com/manuals/GCMVC96Service.pdf?srsltid=AfmBOorYYl3I7u5yDDjN2zdgPibmh7eQ9JS7DTn13HW8SmGWWT-QzqLO"
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

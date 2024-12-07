package edu.neu.csye7374;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum VehicleCategory {
    Sports,
    SUV,
    Sedan,
    MiniVan,
    Limo;

    public static List<String> getVehicleCategoryList() {

        return Stream.of(VehicleCategory.values()).map(VehicleCategory::name).collect(Collectors.toList());
    }

    public static String[] getVehicleCategoryArray() {
        return Arrays.stream(VehicleCategory.values()).map(VehicleCategory::name).toArray(String[]::new);
    }

    public static VehicleCategory getVehicleCategory(String s) {
        VehicleCategory result = null;
        switch (s.toLowerCase()) {
            case "suv":
                result = VehicleCategory.SUV;
                break;
            case "sports":
                result = VehicleCategory.Sports;
                break;
            case "minivan":
                result = VehicleCategory.MiniVan;
                break;
            case "limo":
                result = VehicleCategory.Limo;
                break;
            default:
                result = VehicleCategory.Sedan;
                break;
        }
        return result;
    }
}

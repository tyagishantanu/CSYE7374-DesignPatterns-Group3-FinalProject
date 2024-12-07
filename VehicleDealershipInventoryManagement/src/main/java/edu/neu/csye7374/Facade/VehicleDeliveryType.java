package edu.neu.csye7374.Facade;

public enum VehicleDeliveryType {
    Delivery,
    Pickup;

    public static VehicleDeliveryType getVehicleDeliveryType(String s) {
        switch (s.toLowerCase()) {
            case "delivery":
                return VehicleDeliveryType.Delivery;
            case "pickup":
                return VehicleDeliveryType.Pickup;
            default:
                return VehicleDeliveryType.Pickup;
        }
    }
}

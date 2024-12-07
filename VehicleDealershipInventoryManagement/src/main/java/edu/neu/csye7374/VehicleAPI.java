package edu.neu.csye7374;

public interface VehicleAPI {
    String vehicleDescription();

    Object getVehicleManufacturer();

    void setVehicleManufacturer(String carManufacturer);

    int noOfVehiclesRented();

    double getVehiclePrice();

    public int getVehicleId();

    public double getVehicleRentPrice();

    public String getVehicleName();

    public VehicleCategory getVehicleCategory();
}

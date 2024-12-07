package edu.neu.csye7374;

import edu.neu.csye7374.Builder.VehicleBuilder;

public class Vehicle implements VehicleAPI {
    public int vehicleId;
    public String vehicleName;
    public double vehiclePrice;
    public VehicleCategory vehicleCategory;
    public Object vehicleManufacturer;

    public Vehicle(VehicleBuilder builder) {
        super();
        this.vehicleId = builder.getVehicleId();
        this.vehicleName = builder.getVehicleName();
        this.vehiclePrice = builder.getVehiclePrice();
        this.vehicleCategory = builder.getVehicleCategory();
        this.vehicleManufacturer = builder.getVehicleManufacturer();
    }

    public Object getVehicleManufacturer() {
        return String.class.cast(vehicleManufacturer);
    }

    @Override
    public void setVehicleManufacturer(String VehicleManufacturer) {
        this.vehicleManufacturer = VehicleManufacturer;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double VehiclekPrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    @Override
    public String vehicleDescription() {
        // TODO Auto-generated method stub
        return this.vehicleName + ", category : " + this.vehicleCategory;
    }

    @Override
    public int noOfVehiclesRented() {
        // TODO Auto-generated method stub
        return (int) Math.random() * 5;
    }

    public double getVehicleRentPrice(){
        double rentPrice = this.vehiclePrice * 0.05;
        rentPrice = Math.round(rentPrice * 100.0) / 100.0;
        return rentPrice;
    }

    @Override
    public String toString() {
        return vehicleId + "," + vehicleName + "," + vehicleCategory + "," + vehicleManufacturer + "," + vehiclePrice;
    }



    public String buyVehicle() {
        return this.toString() + " is bought!!!!";
    }

    public String rentVehicle() {
        double rentPrice = this.vehiclePrice * 0.05;
        rentPrice = Math.round(rentPrice * 100.0) / 100.0;
        this.vehiclePrice = rentPrice;
        return this.toString() + " is rented!!";
    }
}

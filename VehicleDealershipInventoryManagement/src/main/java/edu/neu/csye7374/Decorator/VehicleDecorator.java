package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.VehicleAPI;
import edu.neu.csye7374.VehicleCategory;

public class VehicleDecorator implements VehicleAPI {
    protected VehicleAPI decoratedVehicle;

    public VehicleDecorator(VehicleAPI decoratedVehicle) {
        this.decoratedVehicle = decoratedVehicle;
    }

    @Override
    public String vehicleDescription() {
        // TODO Auto-generated method stub
        return decoratedVehicle.vehicleDescription();
    }

    @Override
    public int noOfVehiclesRented() {
        // TODO Auto-generated method stub
        return decoratedVehicle.noOfVehiclesRented();
    }

    public VehicleAPI getDecoratedVehicle() {
        return this.decoratedVehicle;
    }

    @Override
    public String toString() {
        return "VehicleDecorator [VehicleDecorator :" + vehicleDescription() + ", "
                + " $ " + getDecoratedVehicle() + " $";
    }

    @Override
    public Object getVehicleManufacturer() {
        return this.decoratedVehicle.getVehicleManufacturer();
    }

    @Override
    public double getVehiclePrice() {
        // TODO Auto-generated method stub
        return this.decoratedVehicle.getVehiclePrice();
    }

    @Override
    public void setVehicleManufacturer(String vehicleManufacturer) {

    }

    @Override
    public int getVehicleId() {
        return this.decoratedVehicle.getVehicleId();
    }

    @Override
    public double getVehicleRentPrice() {
        return this.getVehicleRentPrice();
    }

    @Override
    public String getVehicleName() {
        return this.decoratedVehicle.getVehicleName();
    }

    @Override
    public VehicleCategory getVehicleCategory() {
        return this.decoratedVehicle.getVehicleCategory();
    }
}

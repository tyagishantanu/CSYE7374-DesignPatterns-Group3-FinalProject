package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.Vehicle;
import edu.neu.csye7374.VehicleAPI;

public class Insurance extends VehicleDecorator {
    public Insurance(VehicleAPI decoratedVehicle) {
        super(decoratedVehicle);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String vehicleDescription() {
        // TODO Auto-generated method stub
        return decoratedVehicle.vehicleDescription() + ", Added Insurance to the Order";
    }

    @Override
    public Object getVehicleManufacturer() {
        // TODO Auto-generated method stub
        return decoratedVehicle.getVehicleManufacturer();
    }

    public double getCarPrice() {
        Vehicle b = Vehicle.class.cast(decoratedVehicle);
        return b.getVehiclePrice() + 250;
    }
}

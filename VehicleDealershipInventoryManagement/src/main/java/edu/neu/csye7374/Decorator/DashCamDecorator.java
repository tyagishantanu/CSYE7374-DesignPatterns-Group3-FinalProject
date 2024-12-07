package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.Vehicle;
import edu.neu.csye7374.VehicleAPI;

public class DashCamDecorator extends VehicleDecorator {
    public DashCamDecorator(VehicleAPI decoratedVehicle) {
        super(decoratedVehicle);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String vehicleDescription() {
        // TODO Auto-generated method stub
        return decoratedVehicle.vehicleDescription() + ", Added Dashcam to the vehicle order";
    }

    @Override
    public Object getVehicleManufacturer() {
        // TODO Auto-generated method stub
        return decoratedVehicle.getVehicleManufacturer();
    }

    public double getVehiclePrice() {
        Vehicle b = Vehicle.class.cast(decoratedVehicle);
        return b.getVehiclePrice() + 560;
    }
}

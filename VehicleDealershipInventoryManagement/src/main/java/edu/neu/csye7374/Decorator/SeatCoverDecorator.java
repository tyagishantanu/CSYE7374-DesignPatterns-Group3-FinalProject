package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.Vehicle;
import edu.neu.csye7374.VehicleAPI;

public class SeatCoverDecorator extends VehicleDecorator{
    public SeatCoverDecorator(VehicleAPI decoratedVehicle) {
        super(decoratedVehicle);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String vehicleDescription() {
        // TODO Auto-generated method stub
        return decoratedVehicle.vehicleDescription() + ", Added seat covers to the car order";
    }

    @Override
    public Object getVehicleManufacturer() {
        // TODO Auto-generated method stub
        return decoratedVehicle.getVehicleManufacturer();
    }

    public double getCarPrice() {
        Vehicle b = Vehicle.class.cast(decoratedVehicle);
        return b.getVehiclePrice() + 200;
    }

}

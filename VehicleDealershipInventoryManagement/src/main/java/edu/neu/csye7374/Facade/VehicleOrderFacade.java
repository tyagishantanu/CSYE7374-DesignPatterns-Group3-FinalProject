package edu.neu.csye7374.Facade;

import edu.neu.csye7374.Decorator.Insurance;
import edu.neu.csye7374.Decorator.VehicleDecorator;
import edu.neu.csye7374.VehicleAPI;

public class VehicleOrderFacade {
    private VehicleAPI vehicle;

    public VehicleOrderFacade() {
        super();
    }

    public VehicleOrderFacade(VehicleAPI vehicle) {
        super();
        this.setVehicle(vehicle);
    }

    public VehicleOrderFacade setVehicle(VehicleAPI vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public VehicleAPI getVehicle() {
        return vehicle;
    }

    public VehicleOrder vehicleOrder() {
        VehicleOrder order = new VehicleOrder();
        VehicleDecorator insurance = new Insurance(vehicle);
        System.out.println(insurance);
        order.addVehicle(insurance);
        return order;
    }
}

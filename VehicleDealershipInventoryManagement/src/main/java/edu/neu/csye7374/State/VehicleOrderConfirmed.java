package edu.neu.csye7374.State;

import edu.neu.csye7374.Observer.VehicleOrder;

public class VehicleOrderConfirmed implements VehicleDeliveryStateAPI {

    private VehicleOrder vehicleOrder;

    public VehicleOrderConfirmed(VehicleOrder vehicleOrder) {
        super();
        this.vehicleOrder = vehicleOrder;
    }

    @Override
    public void vehicleConfirmed_state() {
        System.out.println("Sorry, VehicleOrder already in CONFIRMED State");
    }

    @Override
    public void vehicleDeliveryStatus_state() {
        vehicleOrder.setState(vehicleOrder.getVehicleOrderDispatched());
        System.out.println("Thank you for the confirmation, VehicleOrder DISPATCHED");
    }

    @Override
    public void vehicleDelivered_state() {
        System.out.println("Sorry, VehicleOrder not yet DISPATCHED");
    }
}

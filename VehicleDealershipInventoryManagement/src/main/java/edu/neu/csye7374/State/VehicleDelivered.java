package edu.neu.csye7374.State;

import edu.neu.csye7374.Observer.VehicleOrder;

public class VehicleDelivered implements VehicleDeliveryStateAPI {
    private VehicleOrder order;

    public VehicleDelivered(VehicleOrder order) {
        super();
        this.order = order;
    }

    @Override
    public void vehicleConfirmed_state() {
        System.out.println("Sorry, VehicleOrder already DELIVERED");
    }

    @Override
    public void vehicleDeliveryStatus_state() {
        System.out.println("Sorry, VehicleOrder already DELIVERED");
    }

    @Override
    public void vehicleDelivered_state() {
        System.out.println("Sorry, VehicleOrder already DELIVERED");
    }
}


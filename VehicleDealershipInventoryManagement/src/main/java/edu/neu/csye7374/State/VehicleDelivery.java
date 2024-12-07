package edu.neu.csye7374.State;

import edu.neu.csye7374.Observer.VehicleOrder;

public class VehicleDelivery implements VehicleDeliveryStateAPI {

    private VehicleOrder order;

    public VehicleDelivery(VehicleOrder order) {
        super();
        this.order = order;
    }

    @Override
    public void vehicleConfirmed_state() {
        System.out.println("Sorry, VehicleOrder already CONFIRMED");
    }

    @Override
    public void vehicleDeliveryStatus_state() {
        System.out.println("Sorry, VehicleOrder already in DISPATCH state");
    }

    @Override
    public void vehicleDelivered_state() {
        order.setState(order.getVehicleOrderDelivered());
        System.out.println("Thank you for choosing us, VehicleOrder successfully DELIVERED");
    }
}


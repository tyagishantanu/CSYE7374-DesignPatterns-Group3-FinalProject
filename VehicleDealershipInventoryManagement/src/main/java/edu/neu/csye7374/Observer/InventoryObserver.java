package edu.neu.csye7374.Observer;

import edu.neu.csye7374.Facade.VehicleDeliveryType;

public class InventoryObserver implements CheckoutObserverAPI {

    @Override
    public void update(VehicleOrder vehicleOrder) {
        // TODO Auto-generated method stub
        if (vehicleOrder.getVehicleDeliveryType() == VehicleDeliveryType.Delivery) {
            if (vehicleOrder.getTotal() <= 10000) {
                vehicleOrder.setDeliveryCost(50);
            } else {
                vehicleOrder.setDeliveryCost(200);
            }
        }
    }
}

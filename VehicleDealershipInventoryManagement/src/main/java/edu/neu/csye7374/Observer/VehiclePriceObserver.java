package edu.neu.csye7374.Observer;

public class VehiclePriceObserver implements CheckoutObserverAPI {

    @Override
    public void update(VehicleOrder vehicleOrder) {
        // TODO Auto-generated method stub
        double orderTotal = vehicleOrder.getVehicleOrderCost();
        if (orderTotal >= 700) {
            vehicleOrder.setOfferDiscount(30);
        } else if (orderTotal >= 400) {
            vehicleOrder.setOfferDiscount(15);
        }
    }
}

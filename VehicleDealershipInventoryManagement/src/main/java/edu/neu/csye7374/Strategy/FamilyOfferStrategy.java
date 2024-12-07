package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Vehicle;
import edu.neu.csye7374.Observer.VehicleOrder;

public class FamilyOfferStrategy implements OfferStrategyAPI {
    @Override
    public double discountAmt(VehicleOrder vehicleOrder) {
        // TODO Auto-generated method stub
        double rate = 0.20;
        double offer = (vehicleOrder.getVehicleOrderCost() * rate);
        offer = (double) Math.round(offer * 100) / 100;
        vehicleOrder.setOfferDiscount(offer);
        return offer;
    }

    @Override
    public String discountDesc(VehicleOrder vehicleOrder) {
        // TODO Auto-generated method stub
        return "20% discount for family vehicle offer added!";
    }
}

package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Vehicle;
import edu.neu.csye7374.Observer.VehicleOrder;

public class ExchangeOfferStrategy implements OfferStrategyAPI {

    @Override
    public double discountAmt(VehicleOrder vehicleOrder) {
        // TODO Auto-generated method stub
        double rate = 0.40;
        double offer = (vehicleOrder.getVehicleOrderCost() * rate);
        offer = (double) Math.round(offer * 100) / 100;
        vehicleOrder.setOfferDiscount(offer);
        return offer;
    }

    
	@Override
	public String discountDesc(VehicleOrder vehicleOrder) {
		// TODO Auto-generated method stub
		return null;
	}
}

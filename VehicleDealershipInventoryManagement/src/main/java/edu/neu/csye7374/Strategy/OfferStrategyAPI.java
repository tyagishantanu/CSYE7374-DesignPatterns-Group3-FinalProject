package edu.neu.csye7374.Strategy;

import edu.neu.csye7374.Vehicle;
import edu.neu.csye7374.Observer.VehicleOrder;

public interface OfferStrategyAPI {
    public double discountAmt(VehicleOrder vehicleOrder);

    public String discountDesc(VehicleOrder vehicleOrder);
}

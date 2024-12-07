package edu.neu.csye7374.Observer;

import java.util.*;


import edu.neu.csye7374.VehicleAPI;
import edu.neu.csye7374.Facade.VehicleDeliveryType;
import edu.neu.csye7374.Strategy.*;
import edu.neu.csye7374.State.VehicleDelivered;
import edu.neu.csye7374.State.VehicleDelivery;
import edu.neu.csye7374.State.VehicleDeliveryStateAPI;
import edu.neu.csye7374.State.VehicleOrderConfirmed;
import edu.neu.csye7374.Strategy.OfferStrategy;

public class VehicleOrder implements VehicleDeliveryStateAPI {
    private int vehicleId;
    private double vehicleOrderCost = 0;
    private int vehicleCount = 0;
    private double offerDiscount = 0;
    private double shippingCost;
    private VehicleDeliveryType deliveryType;
    private static int counter = 0;
    private List<CheckoutObserverAPI> observers = new ArrayList<>();
    private List<VehicleAPI> vehicleList = new ArrayList<>();
    private OfferStrategy usingStrategy = OfferStrategy.NONE;

    {
        observers.add(new VehiclePriceObserver());
        observers.add(new InventoryObserver());
    }

    private VehicleDeliveryStateAPI orderConfirmed = new VehicleOrderConfirmed(this);
    private VehicleDeliveryStateAPI orderDispatched = new VehicleDelivery(this);
    private VehicleDeliveryStateAPI orderDelivered = new VehicleDelivered(this);
    private VehicleDeliveryStateAPI state;

    private static Map<OfferStrategy, OfferStrategyAPI> strategyMap = new HashMap<>();
    {
        strategyMap.put(OfferStrategy.StudentOfferStrategy, new StudentOfferStrategy());
        strategyMap.put(OfferStrategy.ExchangeOfferStrategy, new ExchangeOfferStrategy());
        strategyMap.put(OfferStrategy.FamilyOfferStrategy, new FamilyOfferStrategy());
        strategyMap.put(OfferStrategy.NewMemberOfferStrategy, new NewMemberOfferStrategy());
    }

    public VehicleOrder() {
        super();
        this.vehicleId = ++counter;
        this.deliveryType = VehicleDeliveryType.Delivery;
    }

    public VehicleOrder(double orderCost, int vehicleCount, double shippingCost, VehicleDeliveryType deliveryType) {
        super();
        this.vehicleId = ++counter;
        this.vehicleOrderCost = orderCost;
        this.vehicleCount = vehicleCount;
        this.deliveryType = deliveryType;

        if (deliveryType == VehicleDeliveryType.Pickup) {
            this.shippingCost = 0;
        } else {
            this.shippingCost = shippingCost;
        }
    }

    public void addVehicle(VehicleAPI vehicle) {
        vehicleList.add(vehicle);
        vehicleOrderCost += vehicle.getVehiclePrice();
        vehicleCount++;
        observers.forEach(o -> o.update(this));
    }

    public boolean removeVehicle(VehicleAPI vehicle) {
        if (vehicleList.remove(vehicle)) {
            return true;
        }
        return false;
    }

    public void setUsingStrategy(OfferStrategy usingStrategy) {
        this.usingStrategy = usingStrategy;
    }

    public OfferStrategy getUsingStrategy() {
        return usingStrategy;
    }

    public VehicleDeliveryStateAPI getVehicleOrderConfirmed() {
        return orderConfirmed;
    }

    public void confirmOrder() {
        this.state = this.orderConfirmed;
    }

    public void setVehicleOrderConfirmed(VehicleDeliveryStateAPI orderConfirmed) {
        this.orderConfirmed = orderConfirmed;
    }

    public VehicleDeliveryStateAPI getVehicleOrderDelivered() {
        return orderDelivered;
    }

    public void setVehicleOrderDelivered(VehicleDeliveryStateAPI orderDelivered) {
        this.orderDelivered = orderDelivered;
    }

    public VehicleDeliveryStateAPI getVehicleOrderDispatched() {
        return orderDispatched;
    }

    public void setVehicleOrderDispatched(VehicleDeliveryStateAPI orderDispatched) {
        this.orderDispatched = orderDispatched;
    }

    public VehicleDeliveryStateAPI getState() {
        return state;
    }

    public void setState(VehicleDeliveryStateAPI state) {
        this.state = state;
    }

    public List<VehicleAPI> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<VehicleAPI> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public String getVehicleListString() {
        StringBuilder sb = new StringBuilder();
        for (VehicleAPI b : vehicleList) {
            sb.append(b);
            sb.append("; ");
        }
        return sb.toString();
    }

    public VehicleDeliveryType getVehicleDeliveryType() {
        return deliveryType;
    }

    public void setVehicleDeliveryType(VehicleDeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        VehicleOrder.counter = counter;
    }

    public List<CheckoutObserverAPI> getObservers() {
        return observers;
    }

    public void setObservers(List<CheckoutObserverAPI> observers) {
        this.observers = observers;
    }

    public void setVehicleCount(int vehicleCount) {
        this.vehicleCount = vehicleCount;
    }

    public double getVehicleOrderCost() {
        return vehicleOrderCost;
    }

    public void attach(CheckoutObserverAPI observer) {
        observers.add(observer);
    }

    public void detach(CheckoutObserverAPI observer) {
        observers.remove(observer);
    }

    public VehicleOrder(int id) {
        this.vehicleId = id;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int id) {
        this.vehicleId = id;
    }

    public double getTotal() {
        return vehicleOrderCost - offerDiscount + shippingCost;
    }

    public void setVehicleOrderCost(double orderCost) {
        this.vehicleOrderCost = orderCost;
    }

    public int getVehicleCount() {
        return vehicleList.size();
    }

    public double getOfferDiscount() {
        return offerDiscount;
    }

    public void setOfferDiscount(double offerDiscount) {
        this.offerDiscount = offerDiscount;
    }

    public double getDeliveryCost() {
        return shippingCost;
    }

    public void setDeliveryCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public static Map<OfferStrategy, OfferStrategyAPI> getStrategyMap() {
        return strategyMap;
    }

    public double runStrategy() {
        double value = 0;
        System.out.println("Using strategy: " + this.usingStrategy);
        switch (this.usingStrategy) {
            case StudentOfferStrategy:
                value = VehicleOrder.getStrategyMap().get(OfferStrategy.StudentOfferStrategy).discountAmt(this);
                break;
            case ExchangeOfferStrategy:
                value = VehicleOrder.getStrategyMap().get(OfferStrategy.ExchangeOfferStrategy).discountAmt(this);
                break;
            case FamilyOfferStrategy:
                value = VehicleOrder.getStrategyMap().get(OfferStrategy.FamilyOfferStrategy).discountAmt(this);
                break;
            case NewMemberOfferStrategy:
                value = VehicleOrder.getStrategyMap().get(OfferStrategy.NewMemberOfferStrategy).discountAmt(this);
                break;
            default:
                value = this.getVehicleOrderCost();
                break;
        }
        return value;
    }

    @Override
    public String toString() {
        return "VehicleOrder [id=" + vehicleId + ", OrderCost=" + vehicleOrderCost + ", count=" + vehicleCount + ", discount="
                + offerDiscount + ", shippingCost=" + shippingCost + "]";
    }

    @Override
    public void vehicleConfirmed_state() {
        this.state.vehicleConfirmed_state();
    }

    @Override
    public void vehicleDeliveryStatus_state() {
        this.state.vehicleDeliveryStatus_state();
    }

    @Override
    public void vehicleDelivered_state() {
        this.state.vehicleDelivered_state();
    }
}

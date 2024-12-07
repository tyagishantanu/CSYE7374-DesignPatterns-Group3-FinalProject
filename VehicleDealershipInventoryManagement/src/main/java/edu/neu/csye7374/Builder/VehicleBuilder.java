package edu.neu.csye7374.Builder;

import edu.neu.csye7374.Vehicle;
import edu.neu.csye7374.VehicleCategory;
import edu.neu.csye7374.Factory.*;

public class VehicleBuilder implements BuilderAPI {

    private int vehicleId;
    private String vehicleName;
    private double vehiclePrice;
    private VehicleCategory vehicleCategory;
    private String vehicleManufacturer;

    public String getVehicleManufacturer() {
        return vehicleManufacturer;
    }

    public void setVehicleManufacturer(String vehicleManufacturer) {
        this.vehicleManufacturer = vehicleManufacturer;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public VehicleBuilder(int vehicleId, String vehicleName, double vehiclePrice, VehicleCategory vehicleCategory,
                          String vehicleManufacturer) {
        super();
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.vehiclePrice = vehiclePrice;
        this.vehicleCategory = vehicleCategory;
        this.vehicleManufacturer = vehicleManufacturer;
    }

    public VehicleBuilder(String s) {
        String[] tokens = s.split(",");
        this.vehicleId = Integer.parseInt(tokens[0]);
        this.vehicleName = tokens[1];
        this.vehiclePrice = Double.parseDouble(tokens[4]);
        this.vehicleCategory = VehicleCategory.getVehicleCategory(tokens[2]);
        this.vehicleManufacturer = tokens[3];
    }

    @Override
    public Vehicle build() {
        // TODO Auto-generated method stub
        return VehicleFactory.getInstance().getObject(this);
    }
}

package edu.neu.csye7374;

public class ManufacturerObjectAdapter implements VehicleAPI{

    private Manufacturer manufacturer;
    private VehicleAPI vehicle;

    public ManufacturerObjectAdapter(VehicleAPI vehicle, Manufacturer adaptee) {
        this.vehicle = vehicle;
        this.manufacturer = adaptee;
        setVehicleManufacturer(adaptee.getManufacturerName());
    }

    @Override
    public String vehicleDescription() {
        // TODO Auto-generated method stub
        return vehicle.vehicleDescription();
    }

    @Override
    public Object getVehicleManufacturer() {
        // TODO Auto-generated method stub
        return Manufacturer.class.cast(manufacturer);
    }

    @Override
    public String toString() {
        return "###### " + manufacturer + "#####, ##### Vehicle :" + vehicle + "#####";
    }

    @Override
    public double getVehiclePrice() {
        // TODO Auto-generated method stub
        return vehicle.getVehiclePrice();
    }

    @Override
    public int noOfVehiclesRented() {
        // TODO Auto-generated method stub
        return vehicle.noOfVehiclesRented();
    }

    @Override
    public void setVehicleManufacturer(String vehicleManufacturer) {
        // TODO Auto-generated method stub
        this.vehicle.setVehicleManufacturer(vehicleManufacturer);
    }

    @Override
    public int getVehicleId() {
        return this.vehicle.getVehicleId();
    }

    @Override
    public double getVehicleRentPrice() {
        return this.getVehicleRentPrice();
    }

    @Override
    public String getVehicleName() {
        return this.vehicle.getVehicleName();
    }

    @Override
    public VehicleCategory getVehicleCategory() {
        return this.vehicle.getVehicleCategory();
    }

}

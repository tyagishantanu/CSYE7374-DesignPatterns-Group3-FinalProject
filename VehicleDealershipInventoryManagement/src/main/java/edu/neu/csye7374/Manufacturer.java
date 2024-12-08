package edu.neu.csye7374;

public class Manufacturer implements Cloneable{
    private String manufacturerName;
    private int manufacturingYear;
    private int noOfVehiclesSold;
    private static Manufacturer instance;

    public Manufacturer() {
        super();
    }

    public static synchronized Manufacturer getInstance() {
        if (instance == null) {
            instance = new Manufacturer();
        }
        return instance;
    }

    private Manufacturer(String manufacturerName, int manufacturingYear, int noOfVehiclesSold) {
        super();
        this.manufacturerName = manufacturerName;
        this.manufacturingYear = manufacturingYear;
        this.noOfVehiclesSold = noOfVehiclesSold;
    }

    public void setValues(String line) {
        String[] values = line.split(",");
        this.setManufacturerName(values[0]);
        this.setNoOfVehiclesReleased(Integer.parseInt(values[1]));
        this.setManufacturingYear(Integer.parseInt(values[2]));
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public Manufacturer setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
        return this;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public Manufacturer setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
        return this;
    }

    public int getNoOfVehiclesSold() {
        return noOfVehiclesSold;
    }

    public Manufacturer setNoOfVehiclesReleased(int noOfVehiclessReleased) {
        this.noOfVehiclesSold = noOfVehiclessReleased;
        return this;
    }

    @Override
    public String toString() {
        return manufacturerName + "," + manufacturingYear + "," + noOfVehiclesSold;
    }

    @Override
    public Manufacturer clone() {
        Manufacturer clone = null;

        try {
            clone = (Manufacturer) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

}

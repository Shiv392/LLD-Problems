package ParkingLot.Classess;

import ParkingLot.Entities.VehicleType;

public class Vehicle{

    private String vehicleName;
    private int vehicleId;
    private VehicleType vehicleType;

    public Vehicle(String _vehicleName, int _vehicleId, VehicleType _vehicleType){
        vehicleName = _vehicleName;
        vehicleId = _vehicleId;
        vehicleType = _vehicleType;
    }

    public String getName(){
        return  vehicleName;
    }
    public int getId(){
        return vehicleId;
    }
    public VehicleType getType(){
        return vehicleType;
    }
}
package ParkingLot.Classess;

import java.util.ArrayList;
import java.util.List;

import ParkingLot.Entities.VehicleType;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingFloor {
    private int floorId;
    private List<ParkingSpot>parkingSpots;
    private VehicleType supportedVehicleType;

    private final ReentrantLock lock = new ReentrantLock();

    public ParkingFloor(int _floorId, int totalSpots, VehicleType _supportedVehicleType){
        floorId = _floorId;
        supportedVehicleType = _supportedVehicleType;

        parkingSpots = new ArrayList<>();
        for(int i=0;i<totalSpots;i++){
            parkingSpots.add(new ParkingSpot(i));
        }
    }

    public int getFloorId(){
        return floorId;
    }

    public VehicleType getsupportedVehicleType(){
        return supportedVehicleType;
    }

    public List<ParkingSpot> getParkingSpots(){
        return parkingSpots;
    }

    public ReentrantLock getLock(){
        return lock;
    }
}

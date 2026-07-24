package ParkingLot.Classess;

import java.util.ArrayList;
import java.util.List;


public class ParkingLot {
    private final List<ParkingSpot>parkingSpots;

    public ParkingLot(int totalSpots){
        parkingSpots = new ArrayList<>();

        for(int i=0;i<totalSpots;i++){
            parkingSpots.add(new ParkingSpot(i));
        }
    }

    //add parking method 
    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingSpot spot : parkingSpots){
            //if spot is avaiable
            if(spot.isAvailable()){
                spot.park(vehicle);
                System.out.println("Vechile "+vehicle.getName()+"Has been parked at spot id "+vehicle.getId());
                return true;
            }
        }
        System.out.println("Parking is full right now........");
        return false;
    }

    //remove parking method 
    public boolean removeVehicle(int vehicleId){
        for(ParkingSpot spot : parkingSpots){
            Vehicle vehicle = spot.getVehicle();
            if(vehicle!=null && vehicle.getId() == vehicleId){
                spot.removeVehicle();

                System.out.println("Vehicle has been removed from spot id "+spot.getSpotId());
            }
        }

        System.out.println("Vehicle not found with id : "+vehicleId);
        return false;
    }

    //get total avaiable spots
    public int getAvailableSpots(){
        int cnt=0;
        for(ParkingSpot spot : parkingSpots){
            if(spot.isAvailable()) cnt++;
        }
        return cnt;
    }

    //get occupied spots
    public int getOccupiedSpots(){
        return parkingSpots.size() - getAvailableSpots();
    }

    //show displya
    public void displayStatus(){
        System.out.println("Total Spots: "+parkingSpots.size());
        System.out.println("Occupied Spots: "+ getOccupiedSpots());
        System.out.println("Available Spots: "+getAvailableSpots());
    }
}

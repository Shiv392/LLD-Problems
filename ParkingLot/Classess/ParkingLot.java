package ParkingLot.Classess;

import java.util.ArrayList;
import java.util.List;

import ParkingLot.Entities.VehicleType;


public class ParkingLot {
    private final List<ParkingFloor>parkingFloors;
    private int totalFloors;
    private int totalSpots;

    public ParkingLot(int totalSpots, int totalFloors){
        this.totalFloors = totalFloors;
        this.totalSpots = totalSpots;
        parkingFloors = new ArrayList<>();

        parkingFloors.add(new ParkingFloor(totalFloors, totalSpots, VehicleType.BIKE));
        parkingFloors.add(new ParkingFloor(totalFloors, totalSpots, VehicleType.CAR));
    }

    //add parking method 
    public boolean parkVehicle(Vehicle vehicle){
        for(ParkingFloor parkingFloor : parkingFloors){
            for(ParkingSpot spot : parkingFloor.getParkingSpots()){
                if(vehicle.getType()!=parkingFloor.getsupportedVehicleType()){
                    continue;
                }

                if(spot.isAvailable()){
                    spot.park(vehicle);
                    System.out.println("Vechile "+vehicle.getName()+"Has been parked at spot id "+vehicle.getId());
                    return true;
                }
            }
        }
        System.out.println(vehicle.getType()+" Parking is full right now........");
        return false;
    }

    //remove parking method 
    public boolean removeVehicle(int vehicleId, int floorId){
        for(ParkingFloor parkingFloor : parkingFloors){
            for(ParkingSpot spot : parkingFloor.getParkingSpots()){
                if(spot.getVehicle().getId() == vehicleId && parkingFloor.getFloorId() == floorId){
                    spot.removeVehicle();
                    System.out.println("Vehicle "+spot.getVehicle().getName()+" has been removed from parking");
                    return true;
                }
            }
        }

        System.out.println("Vehicle not found with id : "+vehicleId);
        return false;
    }

    //get total avaiable spots
    public int getAvailableSpots(){
        int cnt=0;
        for(ParkingFloor parkingFloor : parkingFloors){
            for(ParkingSpot spot : parkingFloor.getParkingSpots()){
                if(spot.isAvailable()){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    //get occupied spots
    public int getOccupiedSpots(){
        return (totalFloors*totalSpots) - getAvailableSpots();
    }

    //show displya
    public void displayStatus(){
        System.out.println("Total Spots: "+ (totalFloors*totalSpots));
        System.out.println("Occupied Spots: "+ getOccupiedSpots());
        System.out.println("Available Spots: "+getAvailableSpots());
    }

    //method to print floor id with parked bike's name and id 
    public void showParkings(){
        System.out.println("Floor Details=======================>");
        int i=0;
        for(ParkingFloor parkingFloor : parkingFloors){
            StringBuilder sb = new StringBuilder();
            sb.append("Floor"+ (i+1)+" Floor_Id: "+parkingFloor.getFloorId()+" ");
            System.out.println(sb.toString());

            sb = new StringBuilder();
            for(ParkingSpot spot : parkingFloor.getParkingSpots()){
                if(spot.isAvailable()){
                    sb.append("[Empty] ");
                }
                else{
                    sb.append(spot.getVehicle().getType()+" "+spot.getVehicle().getName()+" "+"Spot_Id: "+spot.getSpotId()+" ");
                }
                System.out.println(sb.toString());
                sb = new StringBuilder();
            }
            i++;
        }
    }
}

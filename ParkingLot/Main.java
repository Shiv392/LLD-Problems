package ParkingLot;

import ParkingLot.Classess.ParkingLot;
import ParkingLot.Classess.Vehicle;
import ParkingLot.Entities.VehicleType;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10, 2);

        System.out.println("Parking lot status: ");
        parkingLot.displayStatus();
        
        //defining Vehicle 
        Vehicle car1 = new Vehicle("BMW", 1, VehicleType.CAR);
        Vehicle car2 = new Vehicle("Audi", 2, VehicleType.CAR);

        Vehicle bike1 = new Vehicle("Yamaha", 3, VehicleType.BIKE);
        Vehicle bike2 = new Vehicle("RZ", 4, VehicleType.BIKE);

        parkingLot.parkVehicle(car1);
        parkingLot.parkVehicle(car2);

        parkingLot.parkVehicle(bike1);
        parkingLot.parkVehicle(bike2);

        System.out.println("Parking lot status: ");
        parkingLot.displayStatus();

        parkingLot.showParkings();

    }
}

package ParkingLot.Classess;

public class ParkingSpot {
    private int spotId;
    private Vehicle vehicle;

    public ParkingSpot(int _spodId){
        spotId = _spodId;
    }

    public void park(Vehicle _vehicle){
        vehicle = _vehicle;
    }

    public void removeVehicle(){
        vehicle = null;
    }

    public boolean isAvailable(){
        return vehicle == null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getSpotId(){
        return spotId;
    }
}

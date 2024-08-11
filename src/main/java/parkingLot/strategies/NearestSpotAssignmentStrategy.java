package parkingLot.strategies;

import parkingLot.models.Gate;
import parkingLot.models.ParkingSpot;
import parkingLot.models.VehicleType;

public class NearestSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public ParkingSpot assignSpot(VehicleType vehicleType, Gate gate) {
        //actually have to write the code for assign the spot for nearest...
        return null;
    }
     /*
        we have to go for every floor and spot, check if both are available...
        If yes, then return the first available spot
     */
}

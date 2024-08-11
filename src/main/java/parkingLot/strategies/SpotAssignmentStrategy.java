package parkingLot.strategies;

import parkingLot.models.Gate;
import parkingLot.models.ParkingSpot;
import parkingLot.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(VehicleType vehicleType, Gate gate);
}

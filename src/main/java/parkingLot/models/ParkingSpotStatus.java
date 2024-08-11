package parkingLot.models;

public enum ParkingSpotStatus {
    AVAILABLE,
    OCCUPIED,
    //1 vehicle is already there but have still space, then we say partially_available
    PARTIALLY_AVAILABLE;
}

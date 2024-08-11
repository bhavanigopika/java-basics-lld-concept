package parkingLot.models;

import java.util.List;

public class ParkingSpot extends BaseModel {
    //to support multiple vehicle like park 4 wheeler car in  wheeler truck place since the sport is free at that time to make profitable business
    //so, in this case...you make parkingSpotStatus as occupied, available, partially_available....but ofcourse everything based on what we design + requirement gathering
    private List<VehicleType> vehicleTypeList;
    private ParkingSpotStatus parkingSpotStatus;
    private int parkingSpotNo;
    //spot is available in which parking floor?...We already have map between parkingFloor and parkingSpot...see below comment section
    private ParkingFloor parkingFloor;

    //Getters and Setters
    public List<VehicleType> getVehicleTypeList() {
        return vehicleTypeList;
    }

    public void setVehicleTypeList(List<VehicleType> vehicleTypeList) {
        this.vehicleTypeList = vehicleTypeList;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public int getParkingSpotNo() {
        return parkingSpotNo;
    }

    public void setParkingSpotNo(int parkingSpotNo) {
        this.parkingSpotNo = parkingSpotNo;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}
/*
parking floor - list of parking spots
Check mapping between parking floor and parking spot -> if it is already there don't create new one

Suppose, spot : floor -> here, spot has given, then can we get floor as of now? No, because we didn't mention parkingFloor object here...
Then, it leads to -> for every floor, we have to get all spots
For all(each) spots, if we find our spot - then that floor is the answer
That is you have to go all(each) spots in every floor and find your spot - But, this is not going to be a fast information - It gives higher time complexity
So, you ask with interviewer, do we need redundant data? If yes, then we can add parking floor object in parking spot. It reduces the time complexity
    parking floor : parking spot
                1 : m
                1 : 1
                -----
                1 : m -> so ideally, add ID of parking floor in parkingSpot...

But in parking floor, we already add list of parking spot...So you can use redundant data depend upon use cases but use this bare minimum


 */
package parkingLot.models;

import java.util.List;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloorList;
    private ParkingLotStatus parkingLotStatus;
    private List<Gate> gateList;
    private List<VehicleType> supportedVehicleTypeList;
    private SpotAssignmentStrategyType spotAssignmentStrategyType;

    //Getters and Setters
    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<Gate> getGateList() {
        return gateList;
    }

    public void setGateList(List<Gate> gateList) {
        this.gateList = gateList;
    }

    public List<VehicleType> getSupportedVehicleTypeList() {
        return supportedVehicleTypeList;
    }

    public void setSupportedVehicleTypeList(List<VehicleType> supportedVehicleTypeList) {
        this.supportedVehicleTypeList = supportedVehicleTypeList;
    }

    public SpotAssignmentStrategyType getSpotAssignmentStrategyType() {
        return spotAssignmentStrategyType;
    }

    public void setSpotAssignmentStrategyType(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }
}



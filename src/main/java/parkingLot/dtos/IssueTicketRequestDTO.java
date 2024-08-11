package parkingLot.dtos;

import parkingLot.models.VehicleType;

public class IssueTicketRequestDTO {
    //What are all information do you want from the user to be able to create a ticket...
    //from client side, the client only need to tell the basic information to park a vehicle in parking lot not internal information of each object
    //from next time onwards, we are getting this information form client and search in database
    private Long gateId;
    private String vehicleNo;
    private String vehicleOwner;
    private VehicleType vehicleType;

    //Getters and Setters
    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        this.gateId = gateId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}

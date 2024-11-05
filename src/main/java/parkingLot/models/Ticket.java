package parkingLot.models;

public class Ticket extends BaseModel {
    private String ticketNo;
    private Gate generatedAt;//in which gate, the ticket has generated
    private Operator generatedBy;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    //entry time already recorded in BaseModel
    private TicketStatus ticketStatus;

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
/*
    private Gate generatedAt;
       we have Operator in Gate class also, but it is easy to know whose operator is this,
       if any issues in ticket in the future...even though it is redundant data...it is needed one here
    private Operator generatedBy;
        Gate : Operator
           1 : m
        Actually we want to List of Operator List<Operator> ...during the day, 1 operator and during the night, other operator will be there
        Rather than referring Operator in the Gate class, we need operator for every ticket because from the same gate,
        multiple operators generating different ticket at different time...we depend on the Operator in ticket class itself
 */
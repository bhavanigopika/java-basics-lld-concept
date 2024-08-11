package parkingLot.services;

import parkingLot.exceptions.GateNotFoundException;
import parkingLot.factory.SpotAssignmentStrategyFactory;
import parkingLot.models.Gate;
import parkingLot.models.ParkingLot;
import parkingLot.models.ParkingSpot;
import parkingLot.models.SpotAssignmentStrategyType;
import parkingLot.models.Ticket;
import parkingLot.models.Vehicle;
import parkingLot.models.VehicleType;
import parkingLot.repositories.GateRepository;
import parkingLot.repositories.ParkingLotRepository;
import parkingLot.repositories.TicketRepository;
import parkingLot.repositories.VehicleRepository;
import parkingLot.strategies.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, ParkingLotRepository parkingLotRepository,
                         TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }
    public Ticket issueTicket(Long gateId, String vehicleNo, String ownerName, VehicleType vehicleType) throws GateNotFoundException {
        //this will return the Ticket
        Ticket ticket = new Ticket();

        //get the current date when the ticket is going to be created
        ticket.setCreatedAt(new Date());

        /*******************************************************************************************************/

        /*Get the gate object from the database using the gateId and store it in Optional<Gate>*/
        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);
        //if Gate is empty
        if(optionalGate.isEmpty()){
            throw new GateNotFoundException();// add exception to method signature also
        }
        //if Gate is present(not empty), get the gate object
        Gate gate = optionalGate.get();

        //now set the information about gate in ticket, At which gate is ticket generated?
        ticket.setGeneratedAt(gate);
        //Which operator generated the ticket?
        ticket.setGeneratedBy(gate.getOperator());

        /*******************************************************************************************************/

        /*Get the vehicle with the vehicleNo from database, if present, use it otherwise create a new vehicle object*/
        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByNumber(vehicleNo);
        Vehicle savedVehicle;
        //if no vehicle(vehicle is empty),
        // instead of throw the exception, if vehicle is coming for first time then create/set the vehicle and put it into the database
        if(optionalVehicle.isEmpty()){
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleNo(vehicleNo);
            vehicle.setVehicleType(vehicleType);
            vehicle.setOwnerName(ownerName);
            //save it in vehicleRepository
            vehicleRepository.save();//store it in database add save() method in VehicleRepository class
            savedVehicle = vehicle;
        }else{
            //if vehicle is already present
            savedVehicle = optionalVehicle.get();
        }

        //now set the vehicle information in ticket...
        ticket.setVehicle(savedVehicle);

        /*******************************************************************************************************/

        /*Now, set the parking Spot*/
        //we have to get ParkingLot by parkingLotRepository
        ParkingLot parkingLot = parkingLotRepository.getParkingLot();
        //first, get the Spot Assignment Strategy Type
        SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLot.getSpotAssignmentStrategyType();
        //second, based on the type we get the Spot Assignment Strategy Algorithm
        //strategy = factory + calling method, factory means it return the corresponding type what type if we would choose
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(spotAssignmentStrategyType);
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(vehicleType, gate);

        //now set the parkingSpot in ticket
        ticket.setParkingSpot(parkingSpot);

        /*******************************************************************************************************/

        //now set the ticketNo...below is the format of our ticketNo
        ticket.setTicketNo("Ticket_" + gateId + "_" + ticket.getGeneratedAt());
        //save the ticket in database
        ticketRepository.save(ticket);

        return ticket;
    }
}

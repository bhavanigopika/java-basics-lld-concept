package parkingLot;

import parkingLot.controllers.TicketController;
import parkingLot.dtos.IssueTicketRequestDTO;
import parkingLot.dtos.IssueTicketResponseDTO;
import parkingLot.dtos.ResponseStatus;
import parkingLot.models.Ticket;
import parkingLot.repositories.GateRepository;
import parkingLot.repositories.ParkingLotRepository;
import parkingLot.repositories.TicketRepository;
import parkingLot.repositories.VehicleRepository;
import parkingLot.services.TicketService;

public class Client {
    public static void main(String[] args) {
        //for create the ticketService, we need repository
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        //we need ticketService to create ticketController
        TicketService ticketService = new TicketService(gateRepository, vehicleRepository, parkingLotRepository, ticketRepository);

        //Client will call first ticketController,
        //but we need ticketService to create ticketController, so first create ticketService
        //for create the ticketService, we need repository...so...before ticketService creation, create the repository
        TicketController ticketController = new TicketController(ticketService);

        //issueTicket() from ticketController get the requestDTo, so create the new IssueTicetRequestDto()
        IssueTicketRequestDTO issueTicketRequestDTO = new IssueTicketRequestDTO();
        //store it in ResponseDto
        IssueTicketResponseDTO issueTicketResponseDTO = ticketController.issueTicket(issueTicketRequestDTO);

        if(issueTicketResponseDTO.getResponseStatus().equals(ResponseStatus.SUCCESS)){
            //once success... now get the valid ticket and store in ticket object
            Ticket ticket = issueTicketResponseDTO.getTicket();
        }else{
            //throw an exception
        }
    }
}
/*
Dependency graph:
    For ticket controller, we need ticket service
    for ticket service, we need repository objects
 */

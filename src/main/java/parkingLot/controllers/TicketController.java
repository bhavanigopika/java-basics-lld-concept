package parkingLot.controllers;


import parkingLot.dtos.IssueTicketRequestDTO;
import parkingLot.dtos.IssueTicketResponseDTO;
import parkingLot.dtos.ResponseStatus;
import parkingLot.models.Ticket;
import parkingLot.services.TicketService;

public class TicketController {

    private TicketService ticketService;

    //We have to use the dependency injection...here, dependency coming from outside for loose coupled services
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    //accept the parameter from RequestDto(IssueTicketRequestDto) and return responseDto(IssueTicketResponseDto)
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO ){

        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();
        //it will return the ticket but to avoid error during validation check...so, put it in try block
        try{
            Ticket ticket = ticketService.issueTicket(requestDTO.getGateId(), requestDTO.getVehicleNo(), requestDTO.getVehicleOwner(), requestDTO.getVehicleType());
            //responseDTO going to provide the ticket and responseDTO
            responseDTO.setTicket(ticket);
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(Exception ex){
            ex.getMessage();
            responseDTO.setResponseStatus(ResponseStatus.FAILED);
        }
        return responseDTO;
    }


}

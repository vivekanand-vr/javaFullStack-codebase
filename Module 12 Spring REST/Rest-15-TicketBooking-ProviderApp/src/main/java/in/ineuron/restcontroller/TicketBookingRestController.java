package in.ineuron.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.request.PassengerInfo;
import in.ineuron.response.Ticket;

@RestController
@RequestMapping("/api/ticket")
public class TicketBookingRestController {
	
	/*
	 * 	Send the passenger details as JSON in body of post request in PostMan
	 * 	WebClient is used to send POST request from WebClient-PostRequest app
	 */
	@PostMapping("/register")
	public ResponseEntity<Ticket> bookTicket(@RequestBody PassengerInfo passenger) {

		Ticket ticket = new Ticket();
		ticket.setTicketId("LBS18274");
		ticket.setFrom(passenger.getFrom());
		ticket.setTo(passenger.getTo());
		ticket.setJourneyDate(passenger.getJourneyDate());
		ticket.setPassengerName(passenger.getFirstName() + " " + passenger.getLastName());
		ticket.setTicketPrice(3456.5);
		ticket.setTicketStatus("booked");
		ticket.setTrainNumber(passenger.getTrainNumber());

		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);

	}

}

package in.ineuron.response;

import lombok.Data;

@Data
public class Ticket {

	private String ticketId;
	private String ticketStatus;
	private Double ticketPrice;
	private String passengerName;
	private String from;
	private String to;
	private String journeyDate;
	private String trainNumber;
	
	
}

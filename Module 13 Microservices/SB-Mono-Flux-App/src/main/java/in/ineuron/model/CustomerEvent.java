package in.ineuron.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerEvent {
	private String customerName;
	private Date date;
}

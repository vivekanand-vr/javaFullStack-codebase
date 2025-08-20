package in.ineuron.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

	private Integer cno;
	private String cname;
	private Float billAmt;
	private String caddr;
	private Long mobileNo;
	
	
}

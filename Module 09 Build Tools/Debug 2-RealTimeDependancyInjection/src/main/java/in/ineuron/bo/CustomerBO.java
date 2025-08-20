package in.ineuron.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class CustomerBO {
	@NonNull
	private String customerName;

	@NonNull
	private String customerAddress;

	@NonNull
	private Float pamt;

	@NonNull
	private Float rate;

	@NonNull
	private Float time;

	@NonNull
	private Float interestAmt;

}

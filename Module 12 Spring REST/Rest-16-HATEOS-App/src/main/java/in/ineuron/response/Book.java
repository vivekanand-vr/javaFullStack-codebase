package in.ineuron.response;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("rawtypes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book  extends RepresentationModel{
	private String isbn;
	private String name;
	private Double price;
	private String author;
}

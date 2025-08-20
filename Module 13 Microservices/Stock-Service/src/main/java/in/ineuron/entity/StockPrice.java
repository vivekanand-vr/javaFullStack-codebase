package in.ineuron.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="STOCK_PRICE")
public class StockPrice {

	@Id
	@Column(name = "STOCK_ID")
	private Integer stockId;

	@Column(name = "COMPANY_NAME")
	private String companyName;

	@Column(name = "COMPANY_PRICE")
	private Double companyPrice;

}

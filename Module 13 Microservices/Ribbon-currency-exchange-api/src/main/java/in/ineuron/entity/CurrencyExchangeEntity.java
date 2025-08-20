package in.ineuron.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
 *  Note: Configure the H2 database correctly as in application.properties file to keep mode as "update"
 * ------
 */
@Entity
@Table(name = "CURRENCY_EXCHANGE")
@Data
public class CurrencyExchangeEntity {

	@Id
	@Column(name = "CURRENCY_ID")
	private Integer currencyId;

	@Column(name = "CURRENCY_FROM")
	private String currencyFrom;

	@Column(name = "CURRENCY_TO")
	private String currencyTo;

	@Column(name = "CURRENCY_VALUE")
	private Double currencyValue;

}

package in.ineuron.beans;

import lombok.Data;

@Data
public class CurrencyExchangeBean {
	private Integer currencyId;
	private String currencyFrom;
	private String currencyTo;
	private Double currencyValue;
	private Integer port;
}

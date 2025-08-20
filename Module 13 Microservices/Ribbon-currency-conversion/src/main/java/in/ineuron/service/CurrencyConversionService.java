package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.beans.CurrencyCostBean;
import in.ineuron.beans.CurrencyExchangeBean;
import in.ineuron.feign.CurrencyExchangeClient;

@Service
public class CurrencyConversionService {

	@Autowired
	private CurrencyExchangeClient ceClient;

	public CurrencyCostBean convertCurrency(String from, String to, Double quantity) {
		CurrencyCostBean bean = new CurrencyCostBean();

		CurrencyExchangeBean currencyExchangeBean = ceClient.invokeCeApi(from, to);

		Double currencyCost = currencyExchangeBean.getCurrencyValue();

		Double currencyTotalAmt = quantity * currencyCost;

		bean.setCurrencyFrom(from);
		bean.setCurrencyTo(to);
		bean.setTotalCurrencyAmt(currencyTotalAmt);
		bean.setPort(currencyExchangeBean.getPort());

		return bean;
	}
}

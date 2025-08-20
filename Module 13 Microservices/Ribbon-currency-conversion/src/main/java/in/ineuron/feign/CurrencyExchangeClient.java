package in.ineuron.feign;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import in.ineuron.beans.CurrencyExchangeBean;

@FeignClient(name = "CURRENCY-EXCHANGE-SERVICE")
@RibbonClient(name = "CURRENCY-EXCHANGE-SERVICE")
public interface CurrencyExchangeClient {
	
	@GetMapping(value = "/getCost/from/{from}/to/{to}/")
	public CurrencyExchangeBean invokeCeApi(@PathVariable("from") String from, @PathVariable("to") String to);

}

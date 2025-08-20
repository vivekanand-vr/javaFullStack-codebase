package in.ineuron.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.beans.CurrencyExchangeBean;
import in.ineuron.entity.CurrencyExchangeEntity;
import in.ineuron.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeService {

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepo;

	public CurrencyExchangeBean findCurrencyValue(String from, String to) {

		CurrencyExchangeBean bean = new CurrencyExchangeBean();

		CurrencyExchangeEntity entity = currencyExchangeRepo.findCurrencyValByFromAndTo(from, to);

		BeanUtils.copyProperties(entity, bean);

		return bean;
	}

}

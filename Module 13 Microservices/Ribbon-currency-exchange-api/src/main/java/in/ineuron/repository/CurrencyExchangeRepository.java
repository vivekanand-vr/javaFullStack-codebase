package in.ineuron.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ineuron.entity.CurrencyExchangeEntity;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Integer> {

	@Query("from CurrencyExchangeEntity where currencyFrom=:from and currencyTo=:to")
	public CurrencyExchangeEntity findCurrencyValByFromAndTo(String from, String to);
}

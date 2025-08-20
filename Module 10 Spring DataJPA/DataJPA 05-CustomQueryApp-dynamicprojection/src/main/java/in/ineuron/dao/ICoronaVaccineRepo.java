package in.ineuron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.type.View;

public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine, Long> {
	public <T extends View> List<T> findByCompanyOrderByCompanyDesc(String company, Class<T> clazz);
}

package in.ineuron.dao;

import org.springframework.data.repository.CrudRepository;

import in.ineuron.bo.CoronaVaccine;

public interface ICoronaVaccineRepo extends CrudRepository<CoronaVaccine, Long> {

}

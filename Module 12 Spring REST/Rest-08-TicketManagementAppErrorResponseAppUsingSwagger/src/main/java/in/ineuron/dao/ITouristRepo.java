package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}

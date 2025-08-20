package in.ineuron.repository;

import java.util.Map;

import in.ineuron.model.User;

public interface UserRepository {

	void save(User user);

	Map<String, User> findAll();

	User findById(String id);

	void update(User user);

	void delete(String id);
}

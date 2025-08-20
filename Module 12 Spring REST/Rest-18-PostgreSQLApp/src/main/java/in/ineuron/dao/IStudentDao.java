package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Student;

public interface IStudentDao extends JpaRepository<Student, Integer> {

}

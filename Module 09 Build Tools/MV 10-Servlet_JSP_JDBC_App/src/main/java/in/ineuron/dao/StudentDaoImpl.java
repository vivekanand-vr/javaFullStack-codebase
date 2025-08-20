package in.ineuron.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.StudentBO;
import in.ineuron.util.HibernateUtil;

//Persistence logic using hibernate
public class StudentDaoImpl implements IStudentDao {

	Session session = HibernateUtil.getSession();

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentBO> getAllStudents() {
		Query<StudentBO> query = session.createQuery("FROM StudentBO");
		List<StudentBO> studentBO = query.getResultList();
		return studentBO;
	}
}

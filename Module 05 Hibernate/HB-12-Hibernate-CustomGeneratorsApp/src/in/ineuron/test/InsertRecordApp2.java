package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateMySQLUtil;

public class InsertRecordApp2 {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		String id = null;

		try {
			session = HibernateMySQLUtil.getSession();
			
			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {
				Student student = new Student();

				student.setSaddress("RCB");
				student.setSage(35);
				student.setSname("Kohli");

				id = (String) session.save(student);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to  the database with the id :: " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to the database...");
			}

			HibernateMySQLUtil.closeSession(session);
			HibernateMySQLUtil.closeSessionFactory();
		}

	}

}

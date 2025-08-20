package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Address;
import in.ineuron.model.StudentInfo;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				Address address = new Address();
				address.setCityName("Bengaluru");
				address.setCountryName("IND");
				address.setStateName("karnataka");

				StudentInfo info = new StudentInfo();
				info.setSage(31);
				info.setSname("rahul");
				info.setAddress(address);

				Address address1 = new Address();
				address1.setCityName("Bandra");
				address1.setCountryName("IND");
				address1.setStateName("Maharashtra");

				StudentInfo info1 = new StudentInfo();
				info1.setSage(49);
				info1.setSname("sachin");
				info1.setAddress(address1);

				session.save(info1);
				session.save(info);
				flag =true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Objects saved to database");
			} else {
				transaction.rollback();
				System.out.println("Objects not inserted to the database...");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}

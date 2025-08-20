package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.MobileCustomer;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		MobileCustomer customer = null;

		try {
			session = HibernateUtil.getSession();
			if (session != null) {
				customer = session.get(MobileCustomer.class, 1);
				System.out.println("Loading the object :: " + customer);

				transaction = session.beginTransaction();
				customer.setCallerTune("ABDABDABD.........");
				session.update(customer);
				flag = true;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("object updated to database...");
				System.out.println("After modification :: " + customer);
			} else {
				transaction.rollback();
				System.out.println("object not updated to database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}

package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		BankAccount account = null;
		long id = 1L;
		Transaction transaction = null;
		Boolean flag = false;

		try {
			session = HibernateUtil.getSession();
			account = session.get(BankAccount.class, id);
			System.out.println("Before modification :: " + account);

			if (account != null) {
				transaction = session.beginTransaction();
				account.setBalance(account.getBalance() + 10000);
				flag = true;
			} else {
				System.out.println("Record not available for the given id :: " + id);
				System.exit(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object updated...");
				System.out.println("Account opening date    :: " + account.getOpeningDate());
				System.out.println("Account lastly modified :: " + account.getLastUpdated());
				System.out.println("Account version count   :: " + account.getCount());
			} else {
				transaction.rollback();
				System.out.println("object not updated....");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}

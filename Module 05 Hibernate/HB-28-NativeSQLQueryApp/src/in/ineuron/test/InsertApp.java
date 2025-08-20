package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.ineuron.util.HibernateUtil;

public class InsertApp {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		Boolean flag = false;
		int rowAffected = 0;

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			NativeQuery nativeQuery = session
					.createSQLQuery("insert into insurancepolicy(policyName,policyType,tenure,company)values(?,?,?,?)");

			nativeQuery.setParameter(1, "Prudential");
			nativeQuery.setParameter(2, "quarterly");
			nativeQuery.setParameter(3, 24);
			nativeQuery.setParameter(4, "ICICI");

			rowAffected = nativeQuery.executeUpdate();

			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Record inserted is :: " + rowAffected);
			} else {
				transaction.rollback();
				System.out.println("Record not inserted...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}

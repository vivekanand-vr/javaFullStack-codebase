package in.ineuron.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import in.ineuron.model.BankAccount;
import in.ineuron.util.HibernateUtil;

public class SelectAppUsingCriterianApi {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Filter filter = session.enableFilter("FILTER_BANK_ACCOUNT_STATUS");
			filter.setParameter("accType1", "blocked");
			filter.setParameter("accType2", "closed");

			Criteria criteria = session.createCriteria(BankAccount.class);
			Criterion cond = Restrictions.ge("balance", 25000.0f);
			criteria.add(cond);
			List<BankAccount> bankAccount = criteria.list();
			bankAccount.forEach(System.out::println);

			System.out.println();

			session.disableFilter("FILTER_BANK_ACCOUNT_STATUS");
			Criteria criteria1 = session.createCriteria(BankAccount.class);
			Criterion cond1 = Restrictions.ge("balance", 25000.0f);
			criteria1.add(cond1);
			List<BankAccount> bankAccount1 = criteria1.list();
			bankAccount1.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}
}

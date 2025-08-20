package in.ineuron.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {

	

	@Override
	public String transferPolicies(int minTenure) {

		Session session = null;
		Transaction transaction = null;
		
		@SuppressWarnings("rawtypes")
		Query query = null;
		int rowTransfered = 0;
		boolean flag = false;
		String msg = "";

		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			query = session.getNamedQuery("HQL_TRANFER_POLICIES");
			query.setParameter("min", minTenure);

			rowTransfered = query.executeUpdate();
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				transaction.commit();
				msg = "No of rows transferred is :: " + rowTransfered;
			} else {
				transaction.rollback();
				msg = "records not copied to table";
			}
		}

		return msg;
	}

}

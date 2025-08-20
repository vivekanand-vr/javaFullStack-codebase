package in.ineuron.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class InsurancePolicyDaoImpl implements InsurancePolicyDao {

	Session session = HibernateUtil.getSession();

	@SuppressWarnings("unchecked")
	@Override
	public List<InsurancePolicy> getPageData(int pageSize, int startPos) {
		List<InsurancePolicy> list = null;
		try {
			Query<InsurancePolicy> query = session.getNamedQuery("GET_ALL_POLICIES");

			// Performing pagination
			query.setFirstResult(startPos);//0,3,6,....
			query.setMaxResults(pageSize);//3

			// Exeucting the query
			list = query.getResultList();

		} catch (HibernateException he) {
			he.printStackTrace();
			throw he;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Long getTotalRecordsCount() {
		Long count = 0L;
		try {
			Query query = session.getNamedQuery("GET_POLICIES_COUNT");
			List list = query.list();
			count = (Long) list.get(0);
		} catch (HibernateException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return count;
	}

}

package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import in.ineuron.util.HibernateUtil;

public class SelectApp3 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;

		try {
			session = HibernateUtil.getSession();

			NativeQuery<Object[]> nativeQuery = session.createSQLQuery(
					"SELECT POLICYID,POLICYNAME,COMPANY FROM INSURANCEPOLICY WHERE TENURE>=:max AND TENURE<=:min");

			// Setting the named parameter
			nativeQuery.setParameter("max", 15);
			nativeQuery.setParameter("min", 30);

			// Binding the datatype of output parameters
			nativeQuery.addScalar("POLICYID", StandardBasicTypes.INTEGER);
			nativeQuery.addScalar("POLICYNAME", StandardBasicTypes.STRING);
			nativeQuery.addScalar("COMPANY", StandardBasicTypes.STRING);

			// Executing to get the result
			List<Object[]> policies = nativeQuery.getResultList();

			// Processing the result
			policies.forEach(row -> {
				for (Object obj : row) {
					System.out.print(obj + "\t");
				}
				System.out.println();
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}

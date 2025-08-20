package in.ineuron.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp2 {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Criteria criteria = session.createCriteria(Product.class);// HQL=>from in.ineuron.model.Product

			Criterion cond1 = Restrictions.ge("price", 10000);
			Criterion cond2 = Restrictions.le("price", 60000);

			criteria.add(cond1);
			criteria.add(cond2);// HQL=> from in.ineuron.model.Product where price>=1000 and price<=2500

			
			List<Product> products = criteria.list();
			products.forEach(System.out::println);

		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}

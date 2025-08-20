package in.ineuron.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import in.ineuron.model.Product;
import in.ineuron.util.HibernateUtil;

public class TestApp4 {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {

		Session session = null;
		try {
			session = HibernateUtil.getSession();

			Criteria criteria = session.createCriteria(Product.class);// HQL=>from in.ineuron.model.Product

			ProjectionList list = Projections.projectionList();
			list.add(Projections.property("pname"));
			list.add(Projections.property("qty"));

			criteria.setProjection(list);//HQL=> SELECT pname,qty FROM in.ineuron.model.Product

			Criterion cond1 = Restrictions.ge("price", 10000);
			Criterion cond2 = Restrictions.le("price", 60000);

			// HQL=> SELECT pname,qty FROM in.ineuron.model.Product where price>=1000 and price<=2500
			criteria.add(cond1);
			criteria.add(cond2);

			Order order = Order.asc("pname");
		
		//HQL=> SELECT pname,qty FROM in.ineuron.model.Product where price>=1000 and price<=2500 order by asc(pname)
			criteria.addOrder(order);

			List<Object[]> products = criteria.list();
			System.out.println("PNAME\tQTY");
			products.forEach(row -> {
				for (Object object : row) {
					System.out.print(object + "\t");
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

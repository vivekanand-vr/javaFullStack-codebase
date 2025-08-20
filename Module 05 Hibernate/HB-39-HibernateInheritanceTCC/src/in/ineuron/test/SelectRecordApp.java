package in.ineuron.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.ineuron.model.CardPayment;
import in.ineuron.model.ChequePayment;
import in.ineuron.model.Payment;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;

		try {
			session = HibernateUtil.getSession();
			
			Query<Payment> query = session.createQuery("from in.ineuron.model.Payment");
			List<Payment> list = query.getResultList();
			list.forEach(System.out::println);
			
			System.out.println();
			
			Query<CardPayment> query1 = session.createQuery("from in.ineuron.model.CardPayment");
			List<CardPayment> list1 = query1.getResultList();
			list1.forEach(System.out::println);
			
			System.out.println();
			
			Query<ChequePayment> query2 = session.createQuery("from in.ineuron.model.ChequePayment");
			List<ChequePayment> list2 = query2.getResultList();
			list2.forEach(System.out::println);
			
			
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}
}

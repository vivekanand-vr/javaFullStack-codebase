package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.Student;
import in.ineuron.util.HibernateUtil;

public class LoadandMergeApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Student std1 = null;
		Student std2 = null;
		Student std3 = null;

		try 
		{
			session = HibernateUtil.getSession();
			std1 = session.get(Student.class, 5);// L1-cache
			System.out.println("After loading the data into L1-cache :: "+std1);

			if (session != null) transaction = session.beginTransaction();

			if (transaction != null)
			{
				std2 = new Student();
				std2.setSid(5);
				std2.setSaddress("MI");
				std2.setSname("Vicky");
				std2.setSage(32);
				
				std3 = (Student) session.merge(std2);
				System.out.println("After merging in L1Cache :: "+std3);
				System.out.println(std1.hashCode() + ":: " + std2.hashCode() + ":: " + std3.hashCode());
				flag = true;
			}

		}
		
		catch (HibernateException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			if (flag) 
			{
				transaction.commit();
				System.out.println("Object updated to database....");
			} 
			else 
			{
				transaction.rollback();
				System.out.println("Object not updated to database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}

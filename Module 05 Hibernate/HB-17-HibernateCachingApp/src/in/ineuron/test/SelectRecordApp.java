package in.ineuron.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.InsurancePolicy;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;

		try {
			session = HibernateUtil.getSession();

			InsurancePolicy policy1 = session.get(InsurancePolicy.class, 1L);
			System.out.println("1:: "+policy1);
			System.out.println("------------------------");//gets from DB put in L1-cache
			
			InsurancePolicy policy2 = session.get(InsurancePolicy.class, 1L);
			System.out.println("2:: "+policy2);
			System.out.println("------------------------");//gets from L1-cache
			
			session.evict(policy1);//Remove policy object from L1-cache
			
			InsurancePolicy policy3 = session.get(InsurancePolicy.class, 1L);
			System.out.println("3:: "+policy3);
			System.out.println("------------------------");//gets from DB put in L1-cache
			
			InsurancePolicy policy4 = session.get(InsurancePolicy.class, 1L);
			System.out.println("4:: "+policy4);
			System.out.println("------------------------");//gets from L1-cache
			
			InsurancePolicy policy5 = session.get(InsurancePolicy.class, 2L);
			System.out.println("5:: "+policy5);
			System.out.println("------------------------");//gets from DB put in L1-cache
			
			session.clear();//remove all objects from the cache
			
			InsurancePolicy policy6 = session.get(InsurancePolicy.class, 1L);
			System.out.println("6:: "+policy6);
			System.out.println("------------------------");//gets from DB and put it in L1-cache
			
			InsurancePolicy policy7 = session.get(InsurancePolicy.class, 2L);
			System.out.println("7:: "+policy7);
			System.out.println("------------------------");//gets from DB put it in L1-cache
			
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

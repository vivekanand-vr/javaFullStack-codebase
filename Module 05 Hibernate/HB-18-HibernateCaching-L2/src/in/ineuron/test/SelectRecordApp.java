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
			System.out.println("------------------------");//gets from DB put in L2-cache and in L1-cache
			
			InsurancePolicy policy2 = session.get(InsurancePolicy.class, 1L);
			System.out.println("2:: "+policy2);
			System.out.println("------------------------");//gets from L1-cache
			
			session.evict(policy1);//Remove policy object from L1-cache
			
			InsurancePolicy policy3 = session.get(InsurancePolicy.class, 1L);
			System.out.println("3:: "+policy3);
			System.out.println("------------------------");//gets from L2-cache and keep it in L1-cache
			
			session.clear();//remove all objects from L1-cache
			
			Thread.sleep(20000);//20secs(idleTimeout is expired so object removed from L2-cache)
			
			System.out.println();
			
			InsurancePolicy policy4 = session.get(InsurancePolicy.class, 1L);
			System.out.println("4:: "+policy4);
			System.out.println("------------------------");//gets from DB put in L2-cache and in L1-cache
					
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

package in.pwskills;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.pwskills.model.Student;
import in.pwskills.util.HibernateUtil;

public class GetRecordApp {

	private static Logger logger = Logger.getLogger(GetRecordApp.class);

	public static void main(String[] args) {
		logger.debug("start of main method");

		Session session = null;
		int id = 2;
		try {
			session = HibernateUtil.getSession();
			logger.info("session object created...");
			if (session != null) {
				Student student = session.get(Student.class, id);
				if (student != null) {
					System.out.println(student);
					logger.info(student);
				} else
					logger.info("Record not found for the given id :: " + id);

			}
		} catch (HibernateException e) {
			logger.error(e);
		} catch (Exception e) {
			logger.fatal(e);
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			logger.debug("closing the resources");
		}
		logger.debug("end of main method");
	}
}

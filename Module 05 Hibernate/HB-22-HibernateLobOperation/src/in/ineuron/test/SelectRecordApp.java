package in.ineuron.test;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.ineuron.model.JobSeeker;
import in.ineuron.util.HibernateUtil;

public class SelectRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		JobSeeker seeker = null;
		int id = 1;

		try {
			session = HibernateUtil.getSession();
			if (session != null)
				seeker = session.get(JobSeeker.class, id);
			
			if (seeker != null) {
				System.out.println("Id is       :: " + seeker.getJsId());
				System.out.println("Name is     :: " + seeker.getJsName());
				System.out.println("Address is  :: " + seeker.getJsAddr());

				try (FileOutputStream fos = new FileOutputStream("./store/nitin.jpg");
						FileWriter writer = new FileWriter("./store/resume.txt")) {
					fos.write(seeker.getPhoto());
					writer.write(seeker.getResume());
					System.out.println("Photo and resume got downloaded to :: ./store/****");
				}

			} else {
				System.out.println("Record not available for the given id :: " + id);
			}
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

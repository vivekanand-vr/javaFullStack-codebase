package in.ineuron.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.model.JobSeeker;
import in.ineuron.util.HibernateUtil;

public class InsertRecordApp {

	public static void main(String[] args) throws Exception {

		Session session = null;
		Transaction transaction = null;
		Integer id = null;
		boolean flag = false;
		byte[] photo = null;
		char[] resume = null;
		File f = null;

		//logic for copying the image data to byte[]
		try (FileInputStream fis = new FileInputStream("D:\\images\\nitin.JPG")) {
			photo = new byte[fis.available()];
			fis.read(photo);
		}
		
		//logic for copying the resume data to character array
		try {
			f = new File("D:\\images\\resume.txt");
			try (FileReader fr = new FileReader(f)) {
				resume = new char[(int) f.length()];
				fr.read(resume);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				JobSeeker jobSeeker = new JobSeeker();
				jobSeeker.setJsName("nitin");
				jobSeeker.setJsAddr("Bengaluru");
				jobSeeker.setPhoto(photo);
				jobSeeker.setResume(resume);
				
				id = (Integer) session.save(jobSeeker);
				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object inserted to  the database with the id :: " + id);
			} else {
				transaction.rollback();
				System.out.println("Object not inserted to the database...");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}

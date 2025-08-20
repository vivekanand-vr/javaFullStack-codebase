package in.ineuron.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.hibernate.StaleStateException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import in.ineuron.dto.StudentDTO;
import in.ineuron.service.IStudentService;

public class MainApp {

	public static void main(String[] args) {

		ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");

		IStudentService service = factory.getBean(IStudentService.class);
		String name = null, address = null, age = null, id = null;
		StudentDTO dto = null;

		try {
			while (true) {

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("1. CREATE");
				System.out.println("2. READ BY ID");
				System.out.println("3. READ ALL RECORDS");
				System.out.println("4. UPDATE");
				System.out.println("5. DELETE WITH RESPECT TO ID");
				System.out.println("6. DELETE WITH RESPECT TO BEAN");
				System.out.println("7. EXIT");
				System.out.print("Your Option :: [1,2,3,4,5,6,7]:: ");
				Integer option = Integer.parseInt(br.readLine());

				switch (option) {
				case 1:
					System.out.print("Enter the name:: ");
					name = br.readLine();

					System.out.print("Enter the age:: ");
					age = br.readLine();

					System.out.print("Enter the address:: ");
					address = br.readLine();

					dto = new StudentDTO();
					dto.setSname(name);
					dto.setSage(Integer.parseInt(age));
					dto.setSaddress(address);

					int rowAffected = service.insert(dto);
					System.out.println("Id of the record saved is :: " + rowAffected);

					break;

				case 2:
					System.out.print("Enter the id of the record:: ");
					id = br.readLine();

					dto = service.getStudent(Integer.parseInt(id));
					if (dto != null) {
						System.out.println("Record info:: " + dto);
					} else {
						System.out.println("Record not available for the given id :: " + id);
					}
					break;

				case 3:
					List<StudentDTO> students = service.getAllStudents();
					students.forEach(System.out::println);
					break;

				case 4:
					System.out.print("Enter the id of the record:: ");
					id = br.readLine();

					System.out.print("Enter the name:: ");
					name = br.readLine();

					System.out.print("Enter the age:: ");
					age = br.readLine();

					System.out.print("Enter the address:: ");
					address = br.readLine();

					dto = new StudentDTO();
					dto.setSid(Integer.parseInt(id));
					dto.setSname(name);
					dto.setSage(Integer.parseInt(age));
					dto.setSaddress(address);
					service.update(dto);
					break;

				case 5:
					System.out.print("Enter the id of the record:: ");
					id = br.readLine();
					System.out.print("Enter the name:: ");
					name = br.readLine();

					System.out.print("Enter the age:: ");
					age = br.readLine();

					System.out.print("Enter the address:: ");
					address = br.readLine();

					dto = new StudentDTO();
					dto.setSname(name);
					dto.setSage(Integer.parseInt(age));
					dto.setSaddress(address);
					service.delete(Integer.parseInt(id));
					break;

				case 6:
					System.out.print("Enter the id:: ");
					id = br.readLine();

					System.out.print("Enter the name:: ");
					name = br.readLine();

					System.out.print("Enter the age:: ");
					age = br.readLine();

					System.out.print("Enter the address:: ");
					address = br.readLine();

					dto = new StudentDTO();
					dto.setSid(Integer.parseInt(id));
					dto.setSname(name);
					dto.setSage(Integer.parseInt(age));
					dto.setSaddress(address);

					service.delete(dto);

					break;

				case 7:
					System.out.println("Thanks for using the application");
					System.exit(0);

				default:
					System.out.println("Plz enter the option like 1,2,3,4,5 for operation");
					break;
				}
			}
		} catch (StaleStateException se) {
			System.out.println("Record not available for the deletion with the id :: " + id);
		} catch (DataAccessException de) {
			de.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			((ConfigurableApplicationContext) factory).close();
		}
	}
}

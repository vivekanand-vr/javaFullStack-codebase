package in.ineuron;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.bo.MarriageSeeker;
import in.ineuron.service.IMatrimonyServiceMgnt;

@SpringBootApplication
public class BlobAndClobApp {

	public static void main(String[] args) throws Exception {
		ApplicationContext factory = SpringApplication.run(BlobAndClobApp.class, args);

		IMatrimonyServiceMgnt service = factory.getBean(IMatrimonyServiceMgnt.class);

		/*
		 * 	Taking data from the user and saving photo, txt file and user details along with date object
		 */
		
		 Scanner scanner = new Scanner(System.in);
		 System.out.print("Enter the name :: "); 		String name = scanner.next();
		 System.out.print("Enter the address :: "); 	String address = scanner.next();
		 System.out.print("Enter the photoPath :: "); 	String photoPath = scanner.next();
		 System.out.print("Enter the bioDataPath :: "); String bioData = scanner.next();
		 System.out.print("Is the person Indian :: "); 	Boolean indian = scanner.nextBoolean();
		 
		 FileInputStream inputStream = new FileInputStream(photoPath); 
		 byte[] photoData = new byte[inputStream.available()]; 
		 inputStream.read(photoData);
		  
		 File file = new File(bioData); 
		 FileReader reader = new FileReader(file); 
		 char[]bioDataContent = new char[(int) file.length()]; reader.read(bioDataContent);
		  
		 MarriageSeeker seeker = new MarriageSeeker(name, address, photoData,
		 LocalDateTime.of(1993, 1, 3, 20, 15), bioDataContent, indian);
		 System.out.println(service.registerMarriageSeeker(seeker));
		 
		 inputStream.close();
		 reader.close(); 
		 scanner.close();
		
		 
		
		/*
		 * 	Code for retrieval part, optional is used to handle null values
		 */

		Optional<MarriageSeeker> optional = service.searchSeekerById(1L);
		if (optional.isPresent())
		{
			MarriageSeeker seeker2 = optional.get();
			System.out.println(seeker2.getId() + " " + seeker2.getName() + " " + seeker2.getAddress() + " " + seeker2.getIndian());

			OutputStream os = new FileOutputStream("retrieve_image.jpg");
			os.write(seeker.getPhoto());
			os.flush();

			Writer writer = new FileWriter("retrive_biodata.txt");
			writer.write(seeker.getBioData());
			writer.flush();

			os.close();
			writer.close();

			System.out.println("LOBS are retrieved...");

		} else {
			System.out.println("Record not available");
		}
		 
		 
		 
		((ConfigurableApplicationContext) factory).close();
	}
}


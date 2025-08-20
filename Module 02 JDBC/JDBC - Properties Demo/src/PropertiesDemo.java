import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("V:\\Java Programs\\JDBC\\Properties Demo\\src\\demo.properties");
		Properties p = new Properties();
		p.load(fis);
		String name = p.getProperty("name");
		String roll = p.getProperty("rollno");
		
		System.out.println("The name is : " + name);
		System.out.println("The roll no is : "+roll);
		
		
	}

}


package in.ineuron.test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import in.ineuron.comp.WishMessageGenerator;

public class SetterInjection {

	public static void main(String[] args) throws Exception {
		
		//configuration details to get from the xml file, lazy loading is happening
		FileSystemResource resource = new FileSystemResource("src/in/ineuron/cfg/applicationContext.xml");

		System.out.println("***********BeanFactory container starting************");
		XmlBeanFactory factory = new XmlBeanFactory(resource); 
		/*
		get the resource
		the objects are created in the container, done by spring */ 
		
		System.out.println("***********BeanFactory container started*************");

		System.in.read();

		WishMessageGenerator wmg = factory.getBean("wmg", WishMessageGenerator.class);
		System.out.println("Hashcode value of wmg is :: " + wmg.hashCode());
		System.out.println(wmg);
		String result = wmg.generateMessage("sachin");
		System.out.println(result + "\n");
		
		//same object is used for the second one too, see the hashcode
		WishMessageGenerator wmg1 = factory.getBean("wmg", WishMessageGenerator.class);
		System.out.println("HashCode value of wmg1 is :: " + wmg1.hashCode());
		System.out.println(wmg1);
		String result1 = wmg1.generateMessage("kohli");
		System.out.println(result1);

		System.out.println();
		System.out.println("*******Container is closing**********");
		/*
		 * when the container is closed the objects that are created will be destroyed
		 */
	}
}

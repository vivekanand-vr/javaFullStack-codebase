package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.IPurchaseOrder;

@SpringBootApplication
public class SpringBootMailAppApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootMailAppApplication.class, args);

		IPurchaseOrder order = context.getBean(IPurchaseOrder.class);

		try {
			String msg = order.purchase(
					new String[] { "Fossil-Chronography", "USPOLO-Tshirt", "LouisPhilippe-Shoes" },
					new double[] { 12000.0, 5000.0, 6000.0 }, 
					new String[] { "example1@gmail.com",
								   "example2@gmail.com"});
			System.out.println(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) context).close();
	}
}



package in.ineuron.test;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import in.ineuron.cfg.AppConfig;
import in.ineuron.comp.WishMessagGenerator;

public class ClientApp {

	public static void main(String[] args) throws Exception {
		System.out.println("*****Container Started*****\n");

		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("Bean id information :: " + Arrays.toString(context.getBeanDefinitionNames()));

		WishMessagGenerator wmg = context.getBean(WishMessagGenerator.class);
		System.out.println(wmg);
		String result = wmg.generateWishMessage("SUMA");
		System.out.println(result);

		((AbstractApplicationContext) context).close();
		System.out.println("\n*****Container Stopped*****");
	}
}

package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Boot01BasicAppApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Boot01BasicAppApplication.class, args);
		System.out.println(context.getClass().getName());
	}
}


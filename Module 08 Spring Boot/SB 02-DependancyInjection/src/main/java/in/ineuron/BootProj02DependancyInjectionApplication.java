package in.ineuron;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import in.ineuron.comp.WishMessageGenerator;

@SpringBootApplication
public class BootProj02DependancyInjectionApplication {
	static {
		System.out.println("BootProj02DependancyInjectionApplication.class file is loading...");
	}

	public BootProj02DependancyInjectionApplication() {
		System.out.println("BootProj02DependancyInjectionApplication::Zero param constructor...");
	}

	@Bean
	LocalDateTime createObj() {
		System.out.println("BootProj02DependancyInjectionApplication.createObj()");
		return LocalDateTime.now();
	}

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(BootProj02DependancyInjectionApplication.class,
				args);

		WishMessageGenerator wmg = applicationContext.getBean(WishMessageGenerator.class);
		System.out.println(wmg);

		String msg = wmg.greetUser("vicky");
		System.out.println(msg);

		((ConfigurableApplicationContext) applicationContext).close();
	}
}

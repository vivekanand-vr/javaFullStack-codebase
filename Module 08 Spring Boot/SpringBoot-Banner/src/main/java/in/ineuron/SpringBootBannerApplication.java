package in.ineuron;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootBannerApplication {
	
	@SuppressWarnings(value = "static-access")
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication();
		app.setBannerMode(Mode.CONSOLE);
		ConfigurableApplicationContext ctx = app.run(SpringBootBannerApplication.class, args);
		ctx.close();
	}

}

/*
 * If you're using Spring Boot to develop your Spring MVC application, 
 * it automatically configures the embedded servlet container and you don't need a 
 * ServletInitializer class. 
 * In this case, you would typically have a class annotated with @SpringBootApplication 
 * which serves as the entry point of your application.
 

 package in.ineuron;
 
 import org.springframework.boot.builder.SpringApplicationBuilder; 
 import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
 
 public class ServletInitializer extends SpringBootServletInitializer {
  
	  @Override protected SpringApplicationBuilder
	  configure(SpringApplicationBuilder application) 
	  { return application.sources(RequestPathApp.class); }
  	}
 */
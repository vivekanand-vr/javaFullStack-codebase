package in.ineuron.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import in.ineuron.methodref.SampleTest;
	
@Configuration
	public class AppConfig {
	@Bean
	public CommandLineRunner runA() {
	//Syntax=> ClassName :: methodName
	return SampleTest::test;
	}
}
	/*
	 * CODE 1
	 * ------
	 
	@Configuration
	public class AppConfig {
		@Bean
		public CommandLineRunner runA() {
			// syntax:: new CommandLineRunner(){....}
			return new CommandLineRunner() {
				@Override
				public void run(String... args) throws Exception {
					System.out.println("HELLO :: " + Arrays.asList(args));
				}
			};
		}
	}
	*/
	


	/*
	 * CODE 2
	 * ------
	 
	@Configuration
	public class AppConfig {
		@Bean
		public CommandLineRunner runA() {
			// Syntax:: Interface obj =(params)->{MethodBody;}
	
			return (args) -> {
				System.out.println("FROM RUNNER :: " + Arrays.asList(args));
			};
		}
	}
	
	*/



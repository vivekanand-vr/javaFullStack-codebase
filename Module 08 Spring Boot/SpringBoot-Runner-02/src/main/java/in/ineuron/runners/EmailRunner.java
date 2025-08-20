package in.ineuron.runners;

import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EmailRunner implements ApplicationRunner {
	
	//from application.properties file
	@Value("${spring.application.name}")
	private String name;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*
		 *  Arguments : --port=9999 start --code=abc execute ---loc=xyz
		 * 
		System.out.println("From ApplicationRunner :: " + Arrays.asList(args.getSourceArgs()));
		System.out.println("NonOptionalArgs :: " + args.getNonOptionArgs());
		System.out.println("OptionalArgs :: "+ args.getOptionNames());
		
		Set<String> optionNames = args.getOptionNames();
		for(String optionName : optionNames) {
			System.out.println("optionName :: "+ args.getOptionValues(optionName));
		}
		
		if(args.getNonOptionArgs().contains("start")) {
			System.out.println("Taking email dump");
		}
		
		System.out.println("**********************************************************");
		*/
		
		/*
		 *   If you pass arguments : --spring.application.name=FORMOUT
		 *   Then the value will be overridden over the application.properties file
		 */
		System.out.println(name);
		
	}

	
	
}

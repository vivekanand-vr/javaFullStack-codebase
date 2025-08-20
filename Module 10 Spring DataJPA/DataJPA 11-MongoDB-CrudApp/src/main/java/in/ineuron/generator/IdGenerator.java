package in.ineuron.generator;

import java.util.UUID;

public class IdGenerator {
	public static String generateId() {
		System.out.println("IdGenerator.generateId()");
		return UUID.randomUUID().toString().replace("-", "").substring(0,10);
	}
}

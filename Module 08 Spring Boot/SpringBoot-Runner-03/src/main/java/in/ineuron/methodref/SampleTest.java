package in.ineuron.methodref;

import java.util.Arrays;

public class SampleTest {
	public static void test(String... args) {
		System.out.println("FROM METHOD REF:: " + Arrays.asList(args));
	}
}
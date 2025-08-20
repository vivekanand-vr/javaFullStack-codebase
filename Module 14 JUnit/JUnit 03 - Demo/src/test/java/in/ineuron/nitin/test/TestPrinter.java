package in.ineuron.nitin.test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import in.ineuron.nitin.service.Printer;

public class TestPrinter {

	@Test
	public void testSingleTon() {
		Printer p1 = Printer.getInstance();
		Printer p2 = Printer.getInstance();

		/*assertNotNull(p1);
		assertNotNull(p2);*/
		
		if (p1==null || p2 == null) {
			fail("p1,p2 should not be null");
		}
		
		assertSame(p1, p2);
	}
}

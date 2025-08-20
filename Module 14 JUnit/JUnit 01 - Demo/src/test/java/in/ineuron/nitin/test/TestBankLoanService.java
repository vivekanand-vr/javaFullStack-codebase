package in.ineuron.nitin.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import in.ineuron.nitin.service.BankLoanService;

public class TestBankLoanService {
	
	@Test
	public void testCalcSimpleInterestWithSmallNumbers() {
		System.out.println("TestBankLoanService.testCalcSimpleInterestWithSmallNumbers()");
		BankLoanService service = new BankLoanService();
		float actualOutput = service.calculateSimpleInterest(100000, 2, 12);
		float expectedOutupt =24000.0f;
		
		//Method checking for test-case and generating the output
		assertEquals(expectedOutupt, actualOutput);
	}
	
	@Test
	public void testCalcSimpleInterestWithBigNumbers() {
		System.out.println("TestBankLoanService.testCalcSimpleInterestWithBigNumbers()");
		BankLoanService service = new BankLoanService();
		float actualOutput = service.calculateSimpleInterest(10000000, 2, 12);
		System.out.println(actualOutput);
		float expectedOutupt =2400000.345f;
		
		//Method checking for test-case and generating the output
		assertEquals(expectedOutupt, actualOutput,0.5f,"Results are not Matching");		
	}
	
	@Test
	public void testCalcSimpleInterestWithInvalidInputs() {
		System.out.println("TestBankLoanService.testCalcSimpleInterestWithInvalidInputs()");
		BankLoanService service = new BankLoanService();
		
		//Method checking for test-case and generating the output
		assertThrows(ArithmeticException.class, ()->service.calculateSimpleInterest(0, 0, 0),"Exception types are not matching");
	}
}

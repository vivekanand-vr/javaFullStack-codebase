package in.ineuron.nitin.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import in.ineuron.nitin.service.BankLoanService;

@DisplayName("TestBankLoanServiceClass")
//@TestMethodOrder(MethodName.class)
//@TestMethodOrder(value=MethodOrderer.DisplayName.class)
//@TestMethodOrder(value=MethodOrderer.Random.class)
public class TestBankLoanService {

	private static BankLoanService service;

	@BeforeAll
	public static void setUp() {
		System.out.println("***************TestBankLoanService.setUp()***********\n\n");
		service = new BankLoanService();
	}

	@Test
	@DisplayName("Testing with Small Numbers")
	@Tag("dev")
	public void testCalcSimpleInterestWithSmallNumbers() {
		System.out.println("\nTestBankLoanService.testCalcSimpleInterestWithSmallNumbers()");
		float actualOutput = service.calculateSimpleInterest(100000, 2, 12);
		float expectedOutupt = 24000.0f;

		// Method checking for test-case and generating the output
		assertEquals(expectedOutupt, actualOutput);
	}

	@Test
	@Disabled
	@DisplayName("Testing with Big Numbers")
	@Tag("uat")
	public void testCalcSimpleInterestWithBigNumbers(TestInfo info) {
		System.out.println("TestBankLoanService.testCalcSimpleInterestWithBigNumbers()" + info.getClass() + " "
				+ info.getTags() + " " + info.getDisplayName() + " " + info.getTestMethod().getClass());
		float actualOutput = service.calculateSimpleInterest(10000000, 2, 12);
		float expectedOutupt = 2400000.345f;

		// Method checking for test-case and generating the output
		assertEquals(expectedOutupt, actualOutput, 0.5f, "Results are not Matching");
	}

	@Test
	@DisplayName("Testing with Invalid inputs")
	@Tag("dev")
	public void testCalcSimpleInterestWithInvalidInputs() {
		System.out.println("\nTestBankLoanService.testCalcSimpleInterestWithInvalidInputs()");

		// Method checking for test-case and generating the output
		assertThrows(IllegalArgumentException.class, () -> service.calculateSimpleInterest(0, 0, 0));
	}

	@Test
	@DisplayName("Testing with Timer")
	@Tag("dev")
	public void testCalcSimpleInteresetWithTimer() {
		System.out.println("\nTestBankLoanService.testCalcSimpleInteresetWithTimer()");
		// Method checking for test-case and generating the output
		assertTimeout(Duration.ofMillis(20000), () -> service.calculateSimpleInterest(120000, 2, 3));
	}

	@AfterAll
	public static void cleanUp() {
		System.out.println("\n************TestBankLoanService.cleanUp()****************");
		service = null;
	}

}

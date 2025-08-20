package in.ineuron.nitin.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import in.ineuron.nitin.service.CensusService;

public class TestCensusService {

	private static CensusService service;

	@BeforeAll
	public static void setUpOnce() {
		service = new CensusService();
	}

	@DisplayName("Testing Data Export")
	@RepeatedTest(value = 10, name = "execution of {displayName}-{currentRepetition}/{totalRepetitions}")
	@Disabled
	public void testExportData() {
		System.out.println("TestCensusService.testExportData()");
		assertEquals("Data Exported", service.exportData());
	}

	@ParameterizedTest
	@ValueSource(ints = { 10, 21, 24, 15, 7, 8, 12, 35 })
	@Disabled
	public void testIsOdd(int data) {
		System.out.println("TestCensusService.testIsOdd() :: " + data);
		boolean result = service.isOdd(data);
		assertTrue(result);
	}

	@ParameterizedTest
	@ValueSource(strings = { "sachin", "dhoni", "kohli" })
	@Disabled
	public void testSayHello(String name) {
		String actualOutput = service.sayHello(name);
		String exepctedOutput = "Hello: " + name;
		assertEquals(exepctedOutput, actualOutput);
	}

	@ParameterizedTest
	@NullAndEmptySource
	public void testIsEmpty(String data) {
		assertTrue(service.isEmpty(data));
	}

	@AfterAll
	public static void cleanUpOnce() {
		service = null;
	}
}

package in.ineuron.nitin.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import in.ineuron.nitin.dao.ILoginDao;
import in.ineuron.nitin.service.LoginServiceImpl;

public class TestLoginServiceImpl {

	private static ILoginDao loginDaoMock;
	
	
	private static LoginServiceImpl loginService;

	@BeforeAll
	public static void setUpOnce() {
		// create a mock object for DAO class having null method Implementation
		loginDaoMock = Mockito.mock(ILoginDao.class);
		System.out.println("Mock class object is :: " + loginDaoMock.getClass().getName());

		// Create Service class object by using Mock object
		loginService = new LoginServiceImpl(loginDaoMock);
	}

	@Test
	public void testLoginWithcValidCredentials() {
		// Provide stub(providing functionality) for DAO authenticate method
		Mockito.when(loginDaoMock.authenticate("sachin", "tendulkar")).thenReturn(1);

		// call login method to get the result
		boolean acutalOutput = loginService.login("sachin", "tendulkar");

		// compare the boolean result using assert
		assertTrue(acutalOutput);
	}

	@Test
	public void testLoginWithInValidCredentials() {
		// Provide stub(providing functionality) for DAO authenticate method
		Mockito.when(loginDaoMock.authenticate("sachin", "sachin@123")).thenReturn(0);

		// call login method to get the result
		boolean acutalOutput = loginService.login("sachin", "sachin@123");

		// compare the boolean result using assert
		assertFalse(acutalOutput);
	}

	@Test
	public void testLoginWithNoCredentials() {
		assertThrows(IllegalArgumentException.class, () -> loginService.login("", ""));
	}

	@Test
	public void testRegisterWithSpy() {
		ILoginDao loginDaoSpy = Mockito.spy(ILoginDao.class);
		System.out.println("Spy object is :: " + loginDaoSpy.getClass().getName());
		LoginServiceImpl loginService = new LoginServiceImpl(loginDaoSpy);

		loginService.registerUser("sachin", "admin");
		loginService.registerUser("dhoni", "visitor");
		loginService.registerUser("kohli", "");

		Mockito.verify(loginDaoSpy, Mockito.times(1)).addUser("sachin", "admin");
		Mockito.verify(loginDaoSpy, Mockito.times(0)).addUser("dhoni", "visitor");
		Mockito.verify(loginDaoSpy, Mockito.never()).addUser("kohli", "");
	}
	
	@AfterAll
	public static void clearOnce() {
		loginDaoMock = null;
		loginService = null;
	}

}

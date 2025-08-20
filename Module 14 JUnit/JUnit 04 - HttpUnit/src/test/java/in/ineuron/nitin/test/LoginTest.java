package in.ineuron.nitin.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebForm;
import com.meterware.httpunit.WebResponse;

@DisplayName("LoginTestApp")
public class LoginTest {

	private static WebConversation conversation;

	@BeforeAll
	public static void setUpOnce() {
		conversation = new WebConversation();
	}

	@Test
	@DisplayName("Testing with Valid Inputs")
	public void testWithValidCredentials() throws Exception {
		System.out.println("LoginTest.testWithValidCredentials()");
		
		// get response by sending the request to the URL
		String url = "http://localhost:9999/HttpUnit-LoginApp/index.html";
		WebResponse response = conversation.getResponse(url);

		// get access to the form from the response
		WebForm form = response.getForms()[0];

		// setting the request params values to the form object
		form.setParameter("uname", "sachin");
		form.setParameter("password", "tendulkar");

		// submit the form to get the response
		WebResponse actualResponse = form.submit();

		// Get the output from the response object
		String actualOutput = actualResponse.getText().trim();

		// perform assertion to validate the output
		assertEquals("valid credentials", actualOutput);
	}

	@Test
	@DisplayName("Testing with Invalid Inputs")
	public void testWithInvalidCredentials() throws Exception {
		System.out.println("LoginTest.testWithInvalidCredentials()");
		
		// get response by sending the request to the URL
		String url = "http://localhost:9999/HttpUnit-LoginApp/index.html";
		WebResponse response = conversation.getResponse(url);

		// get access to the form from the response
		WebForm form = response.getForms()[0];

		// setting the request params values to the form object
		form.setParameter("uname", "sachin");
		form.setParameter("password", "sachin@123");

		// submit the form to get the response
		WebResponse actualResponse = form.submit();

		// Get the output from the response object
		String actualOutput = actualResponse.getText().trim();

		// perform assertion to validate the output
		assertEquals("invalid credentials", actualOutput);

	}

	@Test
	@DisplayName("Testing with NoInputs")
	public void testWithNoInputs() throws Exception {
		System.out.println("LoginTest.testWithNoInputs()");
		
		// get response by sending the request to the URL
		String url = "http://localhost:9999/HttpUnit-LoginApp/index.html";
		WebResponse response = conversation.getResponse(url);

		// get access to the form from the response
		WebForm form = response.getForms()[0];

		// setting the request params values to the form object
		form.setParameter("uname", "");
		form.setParameter("password", "");

		// submit the form to get the response
		WebResponse actualResponse = form.submit();

		// Get the output from the response object
		String actualOutput = actualResponse.getText().trim();

		// perform assertion to validate the output
		assertEquals("provide credentials", actualOutput);
	}

	@AfterAll
	public static void cleanUpOnce() {
		conversation = null;
	}

}

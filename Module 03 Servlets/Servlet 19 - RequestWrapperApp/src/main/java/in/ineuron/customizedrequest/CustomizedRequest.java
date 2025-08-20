package in.ineuron.customizedrequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomizedRequest extends HttpServletRequestWrapper {

	public CustomizedRequest(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		System.out.println("CustomizedRequest.getParameter()");

		System.out.println("Name is :: " + name);

		String word = super.getParameter(name);
		System.out.println("Word typed is :: " + word);

		if (word.equalsIgnoreCase("java") || word.equalsIgnoreCase("jee") || word.equalsIgnoreCase("spring"))
			return "SLEEP";

		return word;
	}

}

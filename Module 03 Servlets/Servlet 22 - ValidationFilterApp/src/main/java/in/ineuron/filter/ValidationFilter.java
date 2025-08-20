package in.ineuron.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ValidationFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String eid_err_msg = "", ename_err_msg = "", eage_err_msg = "", email_err_msg = "", mobile_err_msg = "";
		boolean flag = true;

		PrintWriter out = response.getWriter();
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String eage = request.getParameter("eage");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");

		if (eid == null || eid.equals("")) {
			eid_err_msg = "Employee id is required";
			flag = false;
		} else {
			if (!eid.startsWith("iNeuron-")) {
				eid_err_msg = "Employee id should start with iNeuron-";
				flag = false;
			} else {
				flag = true;
			}
		}

		if (ename == null || ename.equals("")) {
			ename_err_msg = "Employee name is required";
			flag = false;
		} else {
			if (ename.length() <= 3) {
				ename_err_msg = "Employee name length should not be less than 3";
				flag = false;
			} else {
				flag = true;
			}
		}

		if (eage == null || eage.equals("")) {
			eage_err_msg = "Employee age is required";
			flag = false;
		} else {
			if (Integer.parseInt(eage) < 20 || Integer.parseInt(eage) > 30) {
				eage_err_msg = "Employee age should be within 20 to 30";
				flag = false;
			} else {
				flag = true;
			}
		}

		if (email == null || email.equals("")) {
			email_err_msg = "Employee mailid is required";
			flag = false;
		} else {
			if (!email.endsWith("@ineuron.ai")) {
				email_err_msg = "Employee email id should end with @ineuron.ai";
				flag = false;
			} else {
				flag = true;
			}
		}

		if (mobile == null || mobile.equals("")) {
			mobile_err_msg = "Employee mobileno is required";
			flag = false;
		} else {
			if (!mobile.startsWith("91-")) {
				mobile_err_msg = "Employee mobile no should start with 91-";
				flag = false;
			} else {
				flag = true;
			}
		}

		if (flag == true) {
			chain.doFilter(request, response);

		} else {

			out.println("<html><head><title>Output</title></head>");
			out.println("<body bgcolor='lightgreen'>");
			out.println("<center>");
			out.println("<h1 style='color:red; text-align:center;'>Employee Registration Details</h1>");
			out.println("<form method='post' action='./reg'>");
			out.println("<table>");
			out.println("<tr><th>EID</th><td><input type='text' name ='eid' value='" + eid + "'/></td><td> <font color='red' size ='5'>"
					+ eid_err_msg + "</font></td></tr>");
			out.println("<tr><th>ENAME</th><td><input type='text' name ='ename' value='" + ename + "'/></td><td><font color='red' size ='5'>"
					+ ename_err_msg + "</font></td></tr>");
			out.println("<tr><th>EAGE</th><td><input type='text' name ='eage' value='" + eage + "'/></td><td><font color='red' size ='5'>"
					+ eage_err_msg + "</font></td></tr>");
			out.println("<tr><th>EMAIL</th><td><input type='text' name ='email' value='" + email + "'/></td><td><font color='red' size ='5'>"
					+ email_err_msg + "</font></td></tr>");
			out.println("<tr><th>MOBILE</th><td><input type='text' name ='mobile' value='" + mobile + "'/></td><td><font color='red' size ='5'>"
					+ mobile_err_msg + "</font></td></tr>");
			out.println("<tr><td></td><td><input type='submit' value='reg'/></td></tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");

		}

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

}

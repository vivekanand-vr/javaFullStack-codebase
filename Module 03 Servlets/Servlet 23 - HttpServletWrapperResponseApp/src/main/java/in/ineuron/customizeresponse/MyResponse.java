package in.ineuron.customizeresponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import in.ineuron.writer.MyWriter;

public class MyResponse extends HttpServletResponseWrapper {

	public MyResponse(HttpServletResponse response) {
		super(response);
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		PrintWriter out = super.getWriter();
		MyWriter myWriter = new MyWriter(out);
		return myWriter;
	}

}

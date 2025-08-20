package in.ineuron.handler;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class HelloHandler implements Tag {

	PageContext pageContext;
	private String name;

	public String getName() {
		System.out.println("HelloHandler.getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println("HelloHandler.setName()");
		this.name = name;
	}

	static {
		System.out.println("HelloHandler.class file is loading...");
	}

	public HelloHandler() {
		System.out.println("HelloHanlder object is instantiated...");
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("HelloHandler.doEndTag()");
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("HelloHandler.doStartTag()");

		try {
			JspWriter out = pageContext.getOut();
			if (name == null)
				out.println("<h1>Hello Guest... Good Evening...</h1>");
			else
				out.println("<h1>Hello " + name + " Good Evening..." + "</h1>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	@Override
	public Tag getParent() {
		System.out.println("HelloHandler.getParent()");
		return null;
	}

	@Override
	public void release() {
		System.out.println("HelloHandler.release()");
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
		System.out.println("HelloHandler.setPageContext()");
	}

	@Override
	public void setParent(Tag arg0) {
		System.out.println("HelloHandler.setParent()");
	}

}

package in.ineuron.handler;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class MyCustomTag implements IterationTag {

	PageContext pageContext;
	int count;

	public int getCount() {
		System.out.println("MyCustomTag.getCount()");
		return count;
	}

	public void setCount(int count) {
		System.out.println("MyCustomTag.setCount()");
		this.count = count;
	}

	@Override
	public Tag getParent() {
		System.out.println("MyCustomTag.getParent()");
		return null;
	}

	@Override
	public void release() {
		System.out.println("MyCustomTag.release()");
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	@Override
	public void setParent(Tag arg0) {
		System.out.println("MyCustomTag.setParent()");
	}

	@Override
	public int doStartTag() throws JspException {
		System.out.println("MyCustomTag.doStartTag()");
		if(count>0)
			return EVAL_BODY_INCLUDE;
		return SKIP_BODY;
	}

	@Override
	public int doAfterBody() throws JspException {
		System.out.println("MyCustomTag.doAfterBody()");
		
		if(--count>0)
			return EVAL_BODY_AGAIN;
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		System.out.println("MyCustomTag.doEndTag()");
		return EVAL_PAGE;
	}
}

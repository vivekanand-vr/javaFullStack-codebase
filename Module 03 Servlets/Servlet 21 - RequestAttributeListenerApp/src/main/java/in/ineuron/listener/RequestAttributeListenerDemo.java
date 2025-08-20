package in.ineuron.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListenerDemo implements ServletRequestAttributeListener {

	static {
		System.out.println("RequestAttributeListener.class file is loading...");
	}

	public RequestAttributeListenerDemo() {
		System.out.println("RequestAttributeListener object is created...");
	}

	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println(srae.getName() + " ... attribute removed...");
	}

	public void attributeAdded(ServletRequestAttributeEvent srae) {
		System.out.println(srae.getName() + " ... attribute added...");
	}

	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println(srae.getName() + " ... attribute replaced...");
	}

}

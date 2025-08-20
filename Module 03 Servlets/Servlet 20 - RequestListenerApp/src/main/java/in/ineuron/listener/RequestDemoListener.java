package in.ineuron.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class RequestDemoListener implements ServletRequestListener {

	public static int count =0;
	
	static {
		System.out.println("RequestDemoListener.class file is loading...");
	}

	public RequestDemoListener() {
		System.out.println("RequestDemoListener object is instantiated..");
	}

	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestObject is destroyed at :: "+new java.util.Date());
		System.out.println("RequestDemoListener.requestDestroyed()");
	}

	public void requestInitialized(ServletRequestEvent sre) {
		count ++;
		System.out.println("Request object is created at :: "+new java.util.Date());
		System.out.println("Hit count of the application is :: "+count);
		System.out.println("RequestDemoListener.requestInitialized()\n");
	}

}

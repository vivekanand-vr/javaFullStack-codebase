package in.ineuron.writer;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class MyWriter extends PrintWriter {

	PrintWriter out;

	public MyWriter(PrintWriter out) throws FileNotFoundException {
		super(out);
		this.out = out;
	}

	@Override
	public void println(String data) {
		System.out.println("MyWriter.println()");
		
		if (!data.startsWith("<")) {
			StringBuffer str = new StringBuffer(data);
			out.println(str.reverse());
		} else {
			out.println(data);
		}
	}

}

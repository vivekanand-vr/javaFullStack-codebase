package in.ineuron.comp;

import java.util.Arrays;

public class MarksInfo {

	private int[] marksInfo;

	public void setMarksInfo(int[] marksInfo) {
		this.marksInfo = marksInfo;
	}

	@Override
	public String toString() {
		return "MarksInfo [marksInfo=" + Arrays.toString(marksInfo) + "]";
	}

}

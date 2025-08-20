package in.ineuron.comp;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

public class UniversityInfo {

	private Map<Integer, String> facultyDetails;
	private Map<String, Date> datesInfo;
	private Properties iplInfo;

	public void setIplInfo(Properties iplInfo) {
		this.iplInfo = iplInfo;
	}

	public void setFacultyDetails(Map<Integer, String> facultyDetails) {
		this.facultyDetails = facultyDetails;
		System.out.println("Implementation classname of Map is :: " + facultyDetails.getClass().getName());
	}

	public void setDatesInfo(Map<String, Date> datesInfo) {
		this.datesInfo = datesInfo;
	}

	@Override
	public String toString() {
		return "UniversityInfo [facultyDetails=" + facultyDetails + ", datesInfo=" + datesInfo + ", iplInfo=" + iplInfo
				+ "]";
	}

}

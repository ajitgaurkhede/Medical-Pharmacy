package medicalpharmacy;

public class Doctor {

	private String doctortName;
	private long mobile;

	public String getDoctortName() {
		return doctortName;
	}

	public void setDoctortName(String doctortName) {
		this.doctortName = doctortName;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Doctor Name : " + doctortName + "\nmobile : " + mobile + "\n";
	}

}

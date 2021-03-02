package medicalpharmacy;

public class Pharmacy {

	private String pharmName;
	private String licenseNumber;
	private String address;
	private long mobile;

	@Override
	public String toString() {
		return "Pharmacy Name : " + pharmName + "\nLicense Number :" + licenseNumber + "\nAddress :" + address
				+ "\nmobile : " + mobile + "\n";
	}

	public String getPharmName() {
		return pharmName;
	}

	public void setPharmName(String pharmName) {
		this.pharmName = pharmName;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

}

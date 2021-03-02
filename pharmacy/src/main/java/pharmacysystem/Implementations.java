package pharmacysystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import medicalpharmacy.Doctor;
import medicalpharmacy.Medicine;
import medicalpharmacy.Orders;
import medicalpharmacy.Pharmacy;

public class Implementations {

	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private Orders order;
	private int flag;
	private List<Medicine> medicines;
	private List<Doctor> doctorList;
	private Pharmacy pharmacyInfo;

	public Pharmacy getPharmacyInfo() {
		return pharmacyInfo;
	}

	public void setPharmacyInfo(Pharmacy pharmacyInfo) {
		this.pharmacyInfo = pharmacyInfo;
	}

	public List<Doctor> getDoctorList() {
		return doctorList;
	}

	public void setDoctorList(List<Doctor> doctorList) {
		this.doctorList = doctorList;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public List<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}

	public Medicine getMedicineByBrandName(String name) {
		return medicines.stream().filter(x -> x.getBrandName().equals(name)).findFirst().orElse(null);

	}

	public void makeOrder(String name) throws Exception {

		for (Medicine x : medicines) {
			if (x.getBrandName().equals(name)) {
				if (x.getQuantity() != 0 && order.getQuantity() <= x.getQuantity()) {
					System.out.println(x.getBrandName() + " Current Available " + x.getQuantity());
					x.setQuantity(x.getQuantity() - order.getQuantity());
					System.out.println("Updated : " + x.getQuantity());
				} else {
					System.out.println("Out Of Stock or Enter lower value than Quantity : ");
					System.out.println("Do u Want add Stock Press 1 for yes or else 2 : ");
					flag = Integer.valueOf(reader.readLine());
					if (flag == 1) {
						x.setQuantity(x.getQuantity() + order.getQuantity());
						System.out.println("Stock Added: ");
						System.out.println(x.getBrandName() + " Current Available : " + x.getQuantity());
					}
				}
				if (placeOrder(x, order)) {
					System.out.println("order placed sucessfull");
				} else {
					System.out.println("oops order is pending because quantity value is more than 5");
				}
			}
		}
	}

	/*
	 * our system is not capable to handle more than 5 quantities order otherwise it
	 * will go for pending
	 */
	public boolean placeOrder(Medicine medicine, Orders orders) {
		if (orders.getQuantity() > 5) {
			medicine.setStatus("pending");
			return false;
		} else {
			medicine.setStatus("completed");
			return true;
		}
	}

	public void displayPendingList() {
		for (Medicine m : medicines) {
			if (m.getStatus().equals("pending"))
				System.out.println(
						"Name : " + m.getBrandName() + "\tprice : " + m.getPrice() + "\tStatus : " + m.getStatus());
		}
	}

	public Doctor serachDoctorbyName(String name) {
		return doctorList.stream().filter(x -> x.getDoctortName().equals(name)).findFirst().orElse(null);
	}

	public void getPharmacyDetails() {
		System.out.println(pharmacyInfo.toString());
	}

	public void getInventory() {
		medicines.forEach(System.out::println);
	}

}

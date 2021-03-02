package pharmacysystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("config-Pharmacy.xml");
		Implementations bean = context.getBean("inventory", Implementations.class);
		char exit = 'a';
		do {
			int choice;
			System.out.println("Enter your choice");
			System.out.println("1.Search medicine by brand name : \n" + "2.Order a drug and Add Stock : \n"
					+ "3.Display list of all pending orders : \n" + "4.Search a doctor by name : \n"
					+ "5.Get pharmacy information : \n" + "6.Inventory\n" + "7.Exit \n");
			choice = Integer.valueOf(reader.readLine());
			switch (choice) {
			case 1:
				System.out.println("Enter medicine name for Searching  : already entered input by staticaly ");
				System.out.println(bean.getMedicineByBrandName("Abacavir"));
				break;
			case 2:
				System.out.println("Enter medicine name for buying  : already entered input by staticaly ");
				bean.makeOrder("Lamivudine");
				break;
			case 3:
				bean.displayPendingList();
				break;
			case 4:
				System.out.println("Enter Doctor Name : already entered input by staticaly ");
				System.out.println(bean.serachDoctorbyName("Ridhi Malhotra"));
				break;
			case 5:
				bean.getPharmacyDetails();
				break;
			case 6:
				bean.getInventory();
				break;
			case 7:
				exit = 'e';
				System.out.println("Thanks for used our services");
				break;
			default:
				System.out.println("Please Enter Valid Choice :");
			}

		} while (exit != 'e');
	}
}

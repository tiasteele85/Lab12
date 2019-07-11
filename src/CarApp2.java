import java.util.*;

public class CarApp2 {

	public static void main(String[] args) {
		// Variables
		Scanner in = new Scanner(System.in);
		int choice = 0;
		ArrayList<Car> cars = populateCars();

		do {
			//print table
			for (int i = 0; i < cars.size(); i++) {

				System.out.print((i + 1) + ") ");
				printTable(cars.get(i));
			}
			// show user choice to quit
			System.out.println((cars.size() + 1) + ") Quit");
			
			//validate user choice
			choice = (Validator.getInt(in, "Which car would you like?") - 1);
			//test whether to quit program
			if (choice == cars.size()) {
				break;
			} else {
				printTable(cars.get(choice));
				System.out.println("Would you like to buy this car?");
				String buy = in.next().toLowerCase();				
				if (buy.startsWith("y")) {
					System.out.println("Excellent! Our finance department will be in touch shortly.");
					removeCar(cars, choice);
					choice -= 1;
				}
			}

		} while (choice != cars.size());
		
		//show end of program
		System.out.println("Have a great day!");
		//close scanner object
		in.close();
	}

	//method to populate predefined objects
	public static ArrayList<Car> populateCars() {

		ArrayList<Car> myCars = new ArrayList<>();

		myCars.add(new Car("Tesla", "Rage", 2018, 26000));
		myCars.add(new Car("Chevrolet", "Rotbox", 2019, 42000));
		myCars.add(new Car("Kia", "Scooterbill", 2019, 16000));
		myCars.add(new UsedCar("Ford", "Fiesta", 1976, 1000, 124567));
		myCars.add(new UsedCar("Tesla", "Putter", 1984, 5000, 65432));
		myCars.add(new UsedCar("Hyundai", "Lifer", 1998, 1800, 90876));

		return myCars;
	}

	//Method to format a print table
	public static void printTable(Car car) {

		if (car instanceof UsedCar) {

			System.out.printf("%-10s %-13s %-10d $%-10.2f  (Used) %-10.2f miles\n", car.getMake(), car.getModel(),
					car.getYear(), car.getPrice(), ((UsedCar) car).getMileage());
		} else {
			System.out.printf("%-10s %-13s %-10d $%-10.2f\n", car.getMake(), car.getModel(), car.getYear(),
					car.getPrice());
		}
	}

	//Method to remove arrayList item
	public static ArrayList<Car> removeCar(ArrayList<Car> list, int pos) {

		list.remove(pos);
		return list;

	}

}

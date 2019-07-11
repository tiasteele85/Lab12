import java.util.*;

public class CarApp {

	public static void main(String[] args) {
		// Variables
		Scanner in = new Scanner(System.in);
		int quantity;

		System.out.println("Welcome to the Grand Circus Motors admin console!");
		quantity = Validator.getInt(in, "How many cars are you entering:");
		 System.out.println(quantity);
		//in.nextLine();//clear scanner object after getting an int
		do {

			Car[] cars = new Car[quantity];
			
			
			for (int i = 0; i < cars.length; i++) {
				
				cars[i] = new Car();				
				cars[i].setMake(Validator.getString(in, "Enter Car #" + (i+1) + " Make:"));
				cars[i].setModel(Validator.getString(in, "Enter Car #" + (i+1) + " Model:"));
				cars[i].setYear(Validator.getInt(in, "Enter Car #" + (i+1) + " Year:"));
				cars[i].setPrice(Validator.getDouble(in, "Enter Car #" + (i+1) + " Price:"));
				quantity--;
			}
			
			System.out.println("Current Inventory:");
			for (Car car : cars) {
				System.out.printf("%-10s %-10s %-6d $%-10.2f\n",car.getMake(), car.getModel(), car.getYear(), car.getPrice() );
			}
			
			
		} while (quantity != 0);

	}

}

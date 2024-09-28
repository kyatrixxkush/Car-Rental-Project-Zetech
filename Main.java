public class Main {

    public static void main(String[] args) {

        CarRentalSystem carRentalSystem = new CarRentalSystem();

        // CreateCar objects
        Car car1 = new Car(1, "Toyota", 25.00, false);
        Car car2 = new Car(2, "Honda", 30.00, false);

        // Adding cars to the rental system
        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);

        // Create Customer objects
        Customer customer1 = new Customer(1, "John Doe", 100.00, null);
        Customer customer2 = new Customer(2, "Jane Doe", 200.00, null);

        // Adding customers to the system
        carRentalSystem.addCustomer(customer1);
        carRentalSystem.addCustomer(customer2);

        // Calculate rental prices
        double rentalPrice1 = carRentalSystem.calculateRentalPrice(car1, 5);
        double rentalPrice2 = carRentalSystem.calculateRentalPrice(car2, 7);

        // Rent cars if the customers can afford them
        if (carRentalSystem.rentCar(car1, customer1, 5)) {
            System.out.println("Rental successful for customer1.");
        } else {
            System.out.println("Rental failed for customer1 due to insufficient balance.");
        }

        if (carRentalSystem.rentCar(car2, customer2, 7)) {
            System.out.println("Rental successful for customer2.");
        } else {
            System.out.println("Rental failed for customer2 due to insufficient balance.");
        }

        // Returning cars after rental
        carRentalSystem.returnCar(car1, customer1);
        carRentalSystem.returnCar(car2, customer2);

        // Viewing all cars in the system
        carRentalSystem.viewCars();

        // Viewing all customers in the system
        carRentalSystem.viewCustomers();
    }
}

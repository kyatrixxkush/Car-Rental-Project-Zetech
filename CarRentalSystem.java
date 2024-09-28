import java.util.ArrayList;

public class CarRentalSystem {

    // List to hold the cars in the system
    ArrayList<Car> cars = new ArrayList<Car>();

    // List to hold customers in the system
    ArrayList<Customer> customers = new ArrayList<>();

    // Method to add a car to the system
    public void addCar(Car car) {
        cars.add(car);
    }

    // Method to remove car from system
    public void removeCar(Car car) {
        cars.remove(car);
    }

    // Method to add a customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Method to remove customer
    public void removeCustomer(Customer customer) {
        customers.remove(customer);
    }

    // Method to rent a car to a customer
    public boolean rentCar(Car car, Customer customer, int days) {
        double rentalPrice = calculateRentalPrice(car, days);

        // Check if customer can afford to rent
        if (customer.getBalance() >= rentalPrice) {
            car.setRented(true);
            customer.setCarRented(car);
            processPayment(customer, rentalPrice); // Subtract payment after successful rental
            System.out.println("Car rented: " + car + " to Customer: " + customer);
            return true; // Successful rental
        } else {
            System.out.println("Insufficient balance for Customer: " + customer.getName()
                    + " to rent Car: " + car.getName());
            return false; //Failed rental
        }
    }

    // Method to return car from customer
    public void returnCar(Car car, Customer customer) {
        car.setRented(false);
        customer.setCarRented(null);
        System.out.println("Car returned: " + car + " by Customer: " + customer);
    }

    // Method to calculate rental price for a car
    public double calculateRentalPrice(Car car, int days) {
        return car.getPricePerDay() * days;
    }

    // Method to process payments
    public boolean processPayment(Customer customer, double amount) {
        if (customer.getBalance() >= amount) {
            customer.setBalance(customer.getBalance() - amount);
            System.out.println("Payment successful. New balance for " + customer.getName() + ": " + customer.getBalance());
            return true;
        } else {
            System.out.println("Payment failed. Insufficient balance for " + customer.getName());
            return false;
        }
    }

    // Method to view all cars
    public void viewCars() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    // Method to view customers
    public void viewCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
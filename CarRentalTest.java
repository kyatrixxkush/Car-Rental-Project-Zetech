import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarRentalSystemTest {

    CarRentalSystem carRentalSystem;
    Car car1, car2;
    Customer customer1, customer2;

    @BeforeEach
    void setUp() {
        carRentalSystem = new CarRentalSystem();
        car1 = new Car(1, "Toyota", 25.00, false);
        car2 = new Car(2, "Honda", 30.00, false);
        customer1 = new Customer(1, "John Doe", 150.00, null);
        customer2 = new Customer(2, "Jane Doe", 100.00, null);

        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.addCustomer(customer1);
        carRentalSystem.addCustomer(customer2);
    }

    @Test
    void addCarTest() {
        assertEquals(2, carRentalSystem.cars.size());
    }

    @Test
    void removeCarTest() {
        carRentalSystem.removeCar(car1);
        assertEquals(1, carRentalSystem.cars.size());
    }

    @Test
    void addCustomerTest() {
        assertEquals(2, carRentalSystem.customers.size());
    }

    @Test
    void removeCustomerTest() {
        carRentalSystem.removeCustomer(customer1);
        assertEquals(1, carRentalSystem.customers.size());
    }

    @Test
    void rentCarSuccessTest() {
        carRentalSystem.rentCar(car1, customer1);
        assertTrue(car1.isRented());
        assertEquals(car1, customer1.getCarRented());
    }

    @Test
    void rentCarInsufficientBalanceTest() {
        customer2.setBalance(50);
        boolean result = carRentalSystem.rentCar(car2, customer2);
        assertFalse(result);
        assertFalse(car2.isRented());
        assertNull(customer2.getCarRented());
    }

    @Test
    void returnCarTest() {
        carRentalSystem.rentCar(car1, customer1);
        carRentalSystem.returnCar(car1, customer1);
        assertFalse(car1.isRented());
        assertNull(customer1.getCarRented());
    }

    @Test
    void calculateRentalPriceTest() {
        double price = carRentalSystem.calculateRentalPrice(car1, 5);
        assertEquals(125.00, price);
    }

    @Test
    void processPaymentSuccessTest() {
        boolean result = carRentalSystem.processPayment(customer1, 100.00);
        assertTrue(result);
        assertEquals(50.00, customer1.getBalance());
    }

    @Test
    void processPaymentInsufficientBalanceTest() {
        boolean result = carRentalSystem.processPayment(customer2, 150.00);
        assertFalse(result);
        assertEquals(100.00, customer2.getBalance());
    }

    @Test
    void viewCarsTest() {
        assertDoesNotThrow(() -> carRentalSystem.viewCars());
    }

    @Test
    void viewCustomersTest() {
        assertDoesNotThrow(() -> carRentalSystem.viewCustomers());
    }
}

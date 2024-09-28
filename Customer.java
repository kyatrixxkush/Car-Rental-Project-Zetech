public class Customer {

    private int id;
    private String name;
    private double balance;
    private Car carRented;

    // Constructor
    public Customer(int id, String name, double balance, Car carRented) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.carRented = carRented; // Keep passed value
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Car getCarRented() {
        return carRented;
    }

    public void setCarRented(Car carRented) {
        this.carRented = carRented;
    }

    @Override
    public String toString() {
        String carInfo = (carRented != null) ? carRented.toString() : "No car rented";
        return "Customer [Id=" + id + ", Name=" + name + ", Balance=" + balance + ", Car Rented=" + carInfo + "]";
    }

}
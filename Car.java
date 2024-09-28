public class Car {

    private int id;
    private String name;
    private double pricePerDay;
    private boolean rented;  // Use boolean

    public Car(int id, String name, double pricePerDay, boolean rented) {
        this.id = id;
        this.name = name;
        this.pricePerDay = pricePerDay;
        this.rented = rented;
    }

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

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isRented() {  // Return boolean
        return rented;
    }

    public void setRented(boolean rented) {  // Use boolean
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "Car [Id=" + id + ", name=" + name + ", pricePerDay=" + pricePerDay + ", rented=" + rented + "]";
    }
}
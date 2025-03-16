package level1Ex2.model;

public class Car {
    private static final String BRAND = "Seat";
    private static String model = "Exeo";
    private final int POWER;

    public Car() {
        POWER = 2100;
    }

    public static String getBrand() {
        return BRAND;
    }

    public static String getModel() {
        return model;
    }

    public int getPOWER() {
        return this.POWER;
    }

    public static void setModel(String model) {
        Car.model = model;
    }

    public static String brakes() {
        return "El vehicle està frenant";
    }

    public String accelerate() {
        return "El vehicle està accelerant";
    }

    @Override
    public String toString() {
        return "Car{| Brand: " + Car.BRAND +
               "| Model: " + Car.model +
               "| Power: " + this.POWER +
               '}';
    }

}

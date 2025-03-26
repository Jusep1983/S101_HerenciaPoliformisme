package level1Ex2;

import level1Ex2.model.Car;

public class Main {

    public static void main(String[] args) {
        Car exempleCar = new Car();
        //Tests:
        System.out.println(Car.brakes());
        System.out.println(exempleCar.accelerate());
        System.out.println(exempleCar);
        System.out.println(Car.getBrand());
        System.out.println(exempleCar.getPOWER());
        System.out.println(Car.getModel());
    }
}

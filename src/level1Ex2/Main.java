package level1Ex2;

import level1Ex2.model.Car;

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car();
        //Tests:
        System.out.println(Car.brakes());
        System.out.println(car1.accelerate());
        System.out.println(car1);
        System.out.println(Car.getBrand());
        System.out.println(car1.getPOWER());
        System.out.println(Car.getModel());
    }
}

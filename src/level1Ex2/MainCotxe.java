package level1Ex2;

public class MainCotxe {

    public static void main(String[] args) {
        Car car1 = new Car();
        //Tests:
        System.out.println(Car.brakes());
        System.out.println(car1.accelerate());
        System.out.println(car1);
        System.out.println(Car.BRAND);
        System.out.println(car1.getPOWER());
        System.out.println(Car.getModel());
    }

}

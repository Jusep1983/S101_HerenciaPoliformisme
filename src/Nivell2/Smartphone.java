package Nivell2;

public class Smartphone extends Telephone implements Camera, Clock{
    public Smartphone(String brand, String model) {
        super(brand, model);
    }

    @Override
    public String toString() {
        return "Smartphone{} " + super.toString();
    }
}

package level2.model;

public class Telephone {
    private String brand;
    private String model;

    public Telephone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String call(int phoneNumber) {
        return "The number " + phoneNumber + " is being called " ;
    }

    @Override
    public String toString() {
        return "Telephone{" +
               "brand='" + brand + '\'' +
               ", model='" + model + '\'' +
               '}';
    }
}

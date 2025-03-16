package level1Ex1.model;

public abstract class Instrument {
    protected String name;
    protected float price;

    public Instrument(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public abstract String play();

    @Override
    public String toString() {
        return "name: " + name + ", price:" + price + "€";
    }

    static {
        System.out.println("Static block loaded into memory!");
    }

    {
        System.out.println("Instrument class instantiated and loaded into memory!");
    }
}

package Nivell1Ex1;

public abstract class Instrument {
    protected String name = "";
    protected float price = 0f;

    public Instrument(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract String play();

    @Override
    public String toString() {
        return "name: " + name + ", price:" + price + "€";
    }

    // Tot i que està implementada al final de la classe, es carrega primer a la memòria,
    // el bloc static al instanciar la classe
    static {
        System.out.println("Instrument Class loaded into memory!");
    }
}

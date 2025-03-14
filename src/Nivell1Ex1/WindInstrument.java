package Nivell1Ex1;

public class WindInstrument extends Instrument{

    public WindInstrument(String name, float price) {
        super(name, price);
    }

    @Override
    public String play() {
        return "A wind instrument is playing";
    }

    @Override
    public String toString() {
        return "Wind instrument: " + super.toString();
    }
}

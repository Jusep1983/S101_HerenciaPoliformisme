package level1Ex1.model;

public class WindInstrument extends Instrument {

    public WindInstrument(String name, float price) {
        super(name, price);
    }

    @Override
    public String play() {
        return "A wind instrument is playing...";
    }

    @Override
    public String toString() {
        return "Wind instrument: " + super.toString();
    }
}

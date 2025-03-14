package Nivell1Ex1;

public class StringInstrument extends Instrument{
    public StringInstrument(String name, float price) {
        super(name, price);
    }

    public String play(){
        return "A string instrument is playing";
    }

    @Override
    public String toString() {
        return "String instrument: " + super.toString();
    }
}

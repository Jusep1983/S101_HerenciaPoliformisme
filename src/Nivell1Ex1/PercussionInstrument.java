package Nivell1Ex1;

public class PercussionInstrument extends Instrument{

    public PercussionInstrument(String name, float price) {
        super(name, price);
    }

    @Override
    public String play() {
        return "A percussion instrument is playing";
    }

    @Override
    public String toString() {
        return "Percussion instrument: " + super.toString();
    }

}

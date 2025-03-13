package Nivell1Ex1;

public class InstrumentPercussio extends Instrument{
    public InstrumentPercussio(String nom, float preu) {
        super(nom, preu);
    }

    @Override
    public String tocar() {
        return "";
    }

    @Override
    public String toString() {
        return "InstrumentPercussió: " + super.toString();
    }

}

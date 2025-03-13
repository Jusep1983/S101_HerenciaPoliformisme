package Nivell1Ex1;

public class InstrumentVent extends Instrument{
    public InstrumentVent(String nom, float preu) {
        super(nom, preu);
    }

    @Override
    public String tocar() {
        return "Està sonant un instrument de vent";
    }

    @Override
    public String toString() {
        return "InstrumentVent: " + super.toString();
    }
}

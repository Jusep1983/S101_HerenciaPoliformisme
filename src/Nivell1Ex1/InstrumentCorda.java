package Nivell1Ex1;

public class InstrumentCorda extends Instrument{
    public InstrumentCorda(String nom, float preu) {
        super(nom, preu);
    }

    public String tocar(){
        return "Està sonant un instrument de corda";
    }

    @Override
    public String toString() {
        return "InstrumentCorda: " + super.toString();
    }
}

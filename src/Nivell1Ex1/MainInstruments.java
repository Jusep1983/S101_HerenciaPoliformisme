package Nivell1Ex1;

public class MainInstruments {
    public static void main(String[] args) {
        // Al instanciar una classe el primer que es carrega a la memòria és el bloc estàtic.
        StringInstrument instrument1 = new StringInstrument("Guitar", 125.75f);
        WindInstrument instrument2 = new WindInstrument("Flute", 15.50f);
        PercussionInstrument instrument3 = new PercussionInstrument("Drum", 95.25f);
        System.out.println(instrument1);
        System.out.println(instrument2);
        System.out.println(instrument3);
    }

}
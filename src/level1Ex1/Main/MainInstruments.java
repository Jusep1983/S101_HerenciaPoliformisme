package level1Ex1.Main;

import level1Ex1.Model.PercussionInstrument;
import level1Ex1.Model.StringInstrument;
import level1Ex1.Model.WindInstrument;

public class MainInstruments {
    public static void main(String[] args) {
        // When instantiating any Instrument class, the first thing that is loaded into memory is the static block.
        StringInstrument instrument1 = new StringInstrument("Guitar", 125.75f);
        WindInstrument instrument2 = new WindInstrument("Flute", 15.50f);
        PercussionInstrument instrument3 = new PercussionInstrument("Drum", 95.25f);
        System.out.println(instrument1.play());
        System.out.println(instrument2.play());
        System.out.println(instrument3.play());
    }

}
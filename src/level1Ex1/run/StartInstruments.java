package level1Ex1.run;

import level1Ex1.model.PercussionInstrument;
import level1Ex1.model.StringInstrument;
import level1Ex1.model.WindInstrument;

public class StartInstruments {
    public static void start() {
        // When instantiating any Instrument class, the first thing that is loaded into memory is the static block.
        StringInstrument vintageGuitar = new StringInstrument("Guitar", 125.75f);
        WindInstrument baroqueFlute = new WindInstrument("Flute", 15.50f);
        PercussionInstrument customDrum = new PercussionInstrument("Drum", 95.25f);
        System.out.println(vintageGuitar.play());
        System.out.println(baroqueFlute.play());
        System.out.println(customDrum.play());
    }
}
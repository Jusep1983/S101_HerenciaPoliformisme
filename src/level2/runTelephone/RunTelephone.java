package level2.runTelephone;

import level2.model.Smartphone;

public class RunTelephone {

    public static void startTelephone() {
        Smartphone smartXiaomi = new Smartphone("Xiaomi", "Redmi Note 14");
        System.out.println(smartXiaomi.alarm());
        System.out.println(smartXiaomi.call(666111888));
        System.out.println(smartXiaomi.photograph());
    }

}

package level2.runTelephone;

import level2.model.Smartphone;

public class RunTelephone {

    public static void startTelephone() {
        Smartphone smartphone1 = new Smartphone("Xiaomi", "Redmi Note 14");
        System.out.println(smartphone1.alarm());
        System.out.println(smartphone1.photograph());
    }

}

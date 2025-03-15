package level2;

public class MainTelephone {

    public static void main(String[] args) {
        Smartphone smartphone1 = new Smartphone("Xiaomi","Redmi Note 14");
        System.out.println(smartphone1.alarm());
        System.out.println(smartphone1.photograph());
    }
}

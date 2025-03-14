package level1Ex2;

//Crea una classe "Cotxe" amb els atributs: marca, model i potència.
//La marca ha de ser estàtic final, el model estàtic i la potència final.
//Demostra la diferència entre els tres.
//N’hi ha algun que es pugui inicialitzar al constructor de la classe?
//
//Afegeix dos mètodes a la classe "Cotxe". Un mètode estàtic anomenat frenar()
//i un altre no estàtic anomenat accelerar().
//El mètode accelerar ha de mostrar per consola: “El vehicle està accelerant”
//i el mètode frenar() ha de mostrar: “El vehicle està frenant”.
//
//Demostra com invocar el mètode estàtic i el no estàtic des del main() de la classe principal.
public class Car {
    static final String BRAND = "Seat";
    private static String model = "Exeo";
    private final int POWER = 2100;

    public Car() {

    }

    public static String getModel() {
        return model;
    }

    public static void setModel(String model) {
        Car.model = model;
    }

    public int getPOWER() {
        return POWER;
    }

    public static String brakes() {
        return "El vehicle està frenant";
    }

    public String accelerate() {
        return "El vehicle està accelerant";
    }

    @Override
    public String toString() {
        return "Car{| Brand: " + BRAND +
                "| Model: " + model +
                "| Power: " + this.POWER +
                '}';
    }

}

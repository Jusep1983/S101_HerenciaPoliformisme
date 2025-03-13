package Nivell2;

public interface Clock {
    default String alarma() {
        return "Està sonant l’alarma";
    }
}

package Nivell2;

public interface Camera {
    default String fotografiar() {
        return "S’està fent una foto";
    }
}

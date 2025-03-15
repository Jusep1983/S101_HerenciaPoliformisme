package level2;

public interface Camera {
    default String photograph() {
        return "A photo is being taken";
    }
}

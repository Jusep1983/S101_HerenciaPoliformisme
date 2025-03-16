package level2.interfaces;

public interface Camera {

    default String photograph() {
        return "A photo is being taken";
    }

}

package level2.interfaces;

public interface Clock {

    default String alarm() {

        return "The alarm is ringing";

    }

}

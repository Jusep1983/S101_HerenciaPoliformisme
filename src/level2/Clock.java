package level2;

public interface Clock {
    default String alarm() {
        return "The alarm is ringing";
    }
}

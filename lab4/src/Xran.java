public class Xran<T> {
    private final T value;


    public Xran(T value) {
        this.value = value;
    }

    // Метод для получения значения
    public T getValue(T alternative) {
        return value != null ? value : alternative;
    }

    @Override
    public String toString() {
        return "Хранение {" + "значения=" + value + '}';
    }
}

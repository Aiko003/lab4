import java.util.*;
import java.util.function.BinaryOperator;

// Основной класс для сокращения списка
class Sokrachenie<T> {
    // Метод для редукции списка
    public T reduce(List<T> list, T identity, BinaryOperator<T> combiner) {
        T result = identity;
        for (T item : list) {
            result = combiner.apply(result, item);
        }
        return result;
    }











    @Override
    public String toString() {
        return "Сокращение{}";
    }
}

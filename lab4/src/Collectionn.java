import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Collectionn {

    public static <T, P> P collect(List<T> values, Supplier<P> collectionFactory, BiConsumer<P, T> accumulator) {
        P collection = collectionFactory.get();
        for (T value : values) {
            accumulator.accept(collection, value);
        }
        return collection;
    }










    @Override
    public String toString() {
        return "Коллекция{}";
    }
}
import java.util.ArrayList;
import java.util.List;

// Интерфейс и класс Mapper с вложенными специфичными мапперами
public interface Func<T, P> {
    P apply(T value);

    // Статический метод map
    static <T, P> List<P> map(List<T> list, Func<T, P> func) {
        List<P> resultList = new ArrayList<>();
        for (T item : list) {
            resultList.add(func.apply(item));
        }
        return resultList;
    }

    // Вложенные или статические классы специфичных мапперов
    class StringLengthFunc implements Func<String, Integer> {
        @Override
        public Integer apply(String value) {
            return value.length();
        }
    }

    class AbsoluteValueFunc implements Func<Integer, Integer> {
        @Override
        public Integer apply(Integer value) {
            return Math.abs(value);
        }
    }

    class MaxValueFunc implements Func<int[], Integer> {
        @Override
        public Integer apply(int[] array) {
            int max = Integer.MIN_VALUE;
            for (int num : array) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        }
        @Override
        public String toString() {
            return "Функция:";
        }
    }
}
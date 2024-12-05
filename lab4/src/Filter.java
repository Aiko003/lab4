import java.util.*;

// Интерфейс с методом test
interface FilterTest<T> {
    boolean test(T value);

    // Добавление метода toString в интерфейс для всех фильтров
    String toString();
}

// Основной класс для фильтрации
class Filter {
    public static <T> List<T> filter(List<T> list, FilterTest<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}

// Класс для фильтрации строк
class StringFilter implements FilterTest<String> {
    public boolean test(String value) {
        return value.length() >= 3;
    }



}

// Класс для фильтрации чисел
class IntegerFilter implements FilterTest<Integer> {
    public boolean test(Integer value) {
        return value < 0; // Отфильтровать положительные значения
    }


}

// Класс для фильтрации массивов
class ArrayFilter implements FilterTest<int[]> {
    public boolean test(int[] array) {
        for (int num : array) {
            if (num > 0) {
                return false; // Возвращаем false, если есть положительный элемент
            }
        }
        return true;
    }








    @Override
    public String toString() {
        return "Фильтрация";
    }
}

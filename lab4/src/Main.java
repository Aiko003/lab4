import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1 (1.2), 2 (3.1), 3 (3.2), 4 (3.3),5 (3.4)):");
        int v = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                v = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Пожалуйста, введите корректное целое число:");
                scanner.next(); // Очистка неверного ввода
            }
        }

        switch (v) {
            case 1:
                try {
                    // Задание 1.2
                    // Хранилище чисел с null и альтернатива 0
                    Xran<Integer> nullNumberStorage = new Xran<>(null);
                    System.out.println("Введите альтернативное значение для null чисел (например, 0):");
                    int alterna = 0;
                    boolean validInput1 = false;
                    while (!validInput1) {
                        try {
                            alterna = scanner.nextInt();
                            validInput1 = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Пожалуйста, введите корректное целое число:");
                            scanner.next(); // Очистка неверного ввода
                        }
                    }
                    System.out.println("Значение из хранилища чисел: " + nullNumberStorage.getValue(alterna));

                    // Хранилище чисел с 99 и альтернатива -1
                    Xran<Integer> numberStorageWithValue = new Xran<>(99);
                    System.out.println("Введите альтернативное значение для чисел, если они не null (например, -1):");
                    int alterna2 = 0;
                    validInput = false;
                    while (!validInput) {
                        try {
                            alterna2 = scanner.nextInt();
                            validInput = true;
                        } catch (InputMismatchException e) {
                            System.out.println("Пожалуйста, введите корректное целое число:");
                            scanner.next(); // Очистка неверного ввода
                        }
                    }
                    System.out.println("Значение из хранилища чисел: " + numberStorageWithValue.getValue(alterna2));

                    // Хранилище строк с null и альтернатива "default"
                    Xran<String> nullStringStorage = new Xran<>(null);
                    System.out.println("Введите альтернативное значение для null строк (например, \"default\"): ");
                    scanner.nextLine(); // Очистка буфера
                    String alternat3 = scanner.nextLine().trim();
                    while (alternat3.isEmpty()) {
                        System.out.println("Пожалуйста, введите непустую строку:");
                        alternat3 = scanner.nextLine().trim();
                    }
                    System.out.println("Значение из хранилища строк: " + nullStringStorage.getValue(alternat3));

                    // Хранилище строк с "hello" и альтернатива "hello world"
                    Xran<String> stringStorageWithValue = new Xran<>("hello world");
                    System.out.println("Введите альтернативное значение для строк (например, \"hello world\"): ");
                    String alternative4 = scanner.nextLine().trim();
                    while (alternative4.isEmpty()) {
                        System.out.println("Пожалуйста, введите непустую строку:");
                        alternative4 = scanner.nextLine().trim();
                    }
                    System.out.println("Значение из хранилища строк: " + stringStorageWithValue.getValue(alternative4));
                } catch (Exception e) {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                }
                break;

            case 2:
                //Задание 3.1
                try {
                    // Преобразование строк в их длины
                    System.out.println("Введите строки через запятую (например: qwerty,asdfg,zx):");
                    scanner.nextLine(); // Очистка буфера
                    String input = scanner.nextLine().trim();
                    List<String> strings = new ArrayList<>();
                    for (String str : input.split(",")) {
                        str = str.trim(); // Удаление пробелов по краям строки
                        if (!str.isEmpty()) {
                            strings.add(str);
                        } else {
                            System.out.println("Некорректная строка (пустая строка или только пробелы).");
                        }
                    }
                    Func<String, Integer> stringLengthFunc = new Func.StringLengthFunc();

                    List<Integer> lengths = Func.map(strings, stringLengthFunc);
                    System.out.println("Длины строк: " + lengths);

                    // Преобразование чисел в абсолютные значения
                    System.out.println("Введите числа через запятую (например: 1,-3,7):");
                    input = scanner.nextLine().trim();
                    List<Integer> numbers = new ArrayList<>();
                    for (String num : input.split(",")) {
                        try {
                            numbers.add(Integer.parseInt(num.trim()));
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректное число: " + num + ".");
                        }
                    }
                    Func<Integer, Integer> absoluteValueFunc = new Func.AbsoluteValueFunc();

                    List<Integer> absoluteValues = Func.map(numbers, absoluteValueFunc);
                    System.out.println("Абсолютные значения: " + absoluteValues);

                    // Получение максимальных значений из массивов
                    System.out.println("Введите массивы чисел через точку с запятой (например: 1,2,3;-1,-2,-3;5,0,4):");
                    input = scanner.nextLine().trim();
                    List<int[]> arrays = new ArrayList<>();
                    for (String arrayStr : input.split(";")) {
                        String[] elements = arrayStr.split(",");
                        int[] array = new int[elements.length];
                        for (int i = 0; i < elements.length; i++) {
                            try {
                                array[i] = Integer.parseInt(elements[i].trim());
                            } catch (NumberFormatException e) {
                                System.out.println("Некорректное число в массиве: " + elements[i] + ".");
                            }
                        }
                        arrays.add(array);
                    }
                    Func<int[], Integer> maxValueFunc = new Func.MaxValueFunc();

                    List<Integer> maxValues = Func.map(arrays, maxValueFunc);
                    System.out.println("Максимальные значения: " + maxValues);
                } catch (Exception e) {
                    System.out.println("Произошла ошибка: " + e.getMessage());
                }
                break;

            case 3:
                //Задание 3.2
                // Задача 1: Фильтрация строк
                System.out.println("Введите строки через запятую (например: qwerty,asdfg,zx):");
                String input = scanner.nextLine().trim();  // Очищаем пробелы
                while (input.isEmpty()) {  // Проверяем на пустой ввод
                    System.out.println("Пожалуйста, введите непустую строку:");
                    input = scanner.nextLine().trim();
                }
                List<String> stringList = List.of(input.split(","));
                List<String> filteredStrings = Filter.filter(stringList, new StringFilter());
                System.out.println("Отфильтрованные строки (>= 3 символа): " + filteredStrings);

                // Задача 2: Фильтрация чисел
                System.out.println("Введите числа через запятую (например: 1,-3,7):");
                input = scanner.nextLine().trim();  // Очищаем пробелы
                while (input.isEmpty()) {  // Проверяем на пустой ввод
                    System.out.println("Пожалуйста, введите непустую строку:");
                    input = scanner.nextLine().trim();
                }
                List<Integer> numberList = new ArrayList<>();
                for (String num : input.split(",")) {
                    try {
                        numberList.add(Integer.parseInt(num.trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Некорректное число: " + num + ".");
                    }
                }
                List<Integer> filteredNumbers = Filter.filter(numberList, new IntegerFilter());
                System.out.println("Отфильтрованные числа (только отрицательные): " + filteredNumbers);

                // Задача 3: Фильтрация массивов
                System.out.println("Введите массивы чисел через точку с запятой (например: 1,2,3;-1,-2,-3;5,0,4):");
                input = scanner.nextLine().trim();  // Очищаем пробелы
                while (input.isEmpty()) {  // Проверяем на пустой ввод
                    System.out.println("Пожалуйста, введите непустую строку:");
                    input = scanner.nextLine().trim();
                }
                List<int[]> arrayList = new ArrayList<>();
                for (String arrayStr : input.split(";")) {
                    String[] elements = arrayStr.split(",");
                    int[] array = new int[elements.length];
                    for (int i = 0; i < elements.length; i++) {
                        try {
                            array[i] = Integer.parseInt(elements[i].trim());
                        } catch (NumberFormatException e) {
                            System.out.println("Некорректное число в массиве: " + elements[i] + ".");
                            array[i] = 0; // Установите значение по умолчанию, если необходимо
                        }
                    }
                    arrayList.add(array);
                }
                List<int[]> filteredArrays = Filter.filter(arrayList, new ArrayFilter());
                System.out.println("Отфильтрованные массивы (без положительных элементов):");
                for (int[] array : filteredArrays) {
                    System.out.println(Arrays.toString(array));
                }

                break;

            case 4:
                // Задание №3.3
                //  тут ошибка с типами данных и получение корректных данных
                Zad4(scanner);

                break;
            case 5:
                // Задание №3.4
//
                // Задача 1: Разделение чисел на положительные и отрицательные
                scanner.nextLine(); // Очистка буфера
                System.out.println("Введите числа через запятую (например: 1,-3,7):");
                String input3 = scanner.nextLine().trim();
                List<Integer> numbers = new ArrayList<>();
                for (String num : input3.split(",")) {
                    try {
                        numbers.add(Integer.parseInt(num.trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Некорректное число: " + num + ".");
                    }
                }

                Map<String, List<Integer>> numberGroups = Collectionn.collect(
                        numbers,
                        () -> new HashMap<String, List<Integer>>() {{
                            put("Положительные", new ArrayList<>());
                            put("Отрицательные", new ArrayList<>());
                        }},
                        (map, number) -> {
                            if (number >= 0) {
                                map.get("Положительные").add(number);
                            } else {
                                map.get("Отрицательные").add(number);
                            }
                        }
                );
                System.out.println("Положительные числа: " + numberGroups.get("Положительные"));
                System.out.println("Отрицательные числа: " + numberGroups.get("Отрицательные"));

                // Задача 2: Группировка строк по длине
                System.out.println("Введите строки через запятую (например: qwerty,asdfg,zx):");
                input = scanner.nextLine().trim();
                List<String> strings = Arrays.asList(input.split(","));
                Map<Integer, List<String>> groupedByLength = Collectionn.collect(
                        strings,
                        HashMap::new,
                        (map, str) -> map.computeIfAbsent(str.length(), k -> new ArrayList<>()).add(str)
                );
                System.out.println("Строки, сгруппированные по длине: " + groupedByLength);

                // Задача 3: Получение уникальных строк
                System.out.println("Введите строки через запятую, включая возможные дубликаты (например: qwerty,asdfg,qwerty,qw):");
                input = scanner.nextLine().trim();
                List<String> stringsWithDuplicates = Arrays.asList(input.split(","));
                Set<String> uniqueStrings = Collectionn.collect(stringsWithDuplicates, HashSet::new, Set::add);
                System.out.println("Уникальные строки: " + uniqueStrings);
                break;


            default:
                System.out.println("Неверный выбор. Пожалуйста, выберите задание (1 (1.2), 2 (3.1), 3 (3.2), 4 (3.3),5 (3.4))");
                break;
        }

    }
    private static void Zad4(Scanner scanner) {
        scanner.nextLine(); // Очистка буфера
        Sokrachenie<String> stringSokrachenie = new Sokrachenie<>();
        Sokrachenie<Integer> integerSokrachenie = new Sokrachenie<>();

        // Пример со строками
        System.out.println("Введите строки через запятую (например: qwerty,asdfg,zx):");
        String input = scanner.nextLine().trim();
        List<String> stringList = input.isEmpty() ? new ArrayList<>() : Arrays.asList(input.split(","));
        String combinedString = stringSokrachenie.reduce(stringList, "", String::concat);
        System.out.println("Объединенная строка: " + combinedString);

        // Пример с числами
        System.out.println("Введите числа через запятую (например: 1,-3,7):");
        input = scanner.nextLine().trim();
        List<Integer> numberList = new ArrayList<>();
        if (!input.isEmpty()) {
            for (String num : input.split(",")) {
                try {
                    numberList.add(Integer.parseInt(num.trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Некорректное число: " + num + ".");
                }
            }
        }
        Integer sum = integerSokrachenie.reduce(numberList, 0, Integer::sum);
        System.out.println("Сумма чисел: " + sum);

        // Пример со списком списков
        System.out.println("Введите списки чисел через точку с запятой (например: 1,2,3;-1,-2,-3;5,0,4):");
        input = scanner.nextLine().trim();
        List<List<Integer>> listOfLists = new ArrayList<>();
        if (!input.isEmpty()) {
            for (String listStr : input.split(";")) {
                List<Integer> innerList = new ArrayList<>();
                for (String num : listStr.split(",")) {
                    try {
                        innerList.add(Integer.parseInt(num.trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Некорректное число: " + num + ".");
                    }
                }
                listOfLists.add(innerList);
            }
        }

        // Подсчет общего количества элементов во всех списках
        int totalElements = listOfLists.stream().mapToInt(List::size).sum();
        System.out.println("Общее количество элементов во всех списках: " + totalElements);

    }
}

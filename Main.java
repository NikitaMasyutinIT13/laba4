import java.util.*;
/**
 * Главный класс для демонстрации работы с обобщенными типов
 */
public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    InputValidator validator = new InputValidator(scanner);

    System.out.println("=== ДЕМОНСТРАЦИЯ ОБОБЩЕННЫХ ТИПОВ ===");

    boolean running = true;
    while (running) {
      showMenu();
      int choice = validator.getMenuChoice("Выберите задание: ", 8);

      switch (choice) {
        case 1:
          demonstrateComparable(validator);
          break;
        case 2:
          demonstrateStudentComparison(validator);
          break;
        case 3:
          demonstrateBoxWithPoint3d(validator);
          break;
        case 4:
          demonstrateMapMethods(validator);
          break;
        case 5:
          demonstrateFilterMethods(validator);
          break;
        case 6:
          demonstrateReduceMethods(validator);
          break;
        case 7:
          demonstrateCollectMethods(validator);
        case 8:
          running = false;
          System.out.println("Выход из программы...");
          break;
      }

      if (choice != 7) {
        System.out.println("\nНажмите Enter для продолжения...");
        scanner.nextLine();
      }
    }

    scanner.close();
  }
  /**
   * Отображение меню
   */
  private static void showMenu() {
    System.out.println("\n=== ГЛАВНОЕ МЕНЮ ОБОБЩЕННЫХ ТИПОВ ===");
    System.out.println("1. Демонстрация интерфейса Comparable");
    System.out.println("2. Сравнение студентов по среднему баллу");
    System.out.println("3. Коробка с трехмерной точкой");
    System.out.println("4. Демонстрация функций (map)");
    System.out.println("5. Демонстрация фильтрации (filter)");
    System.out.println("6. Демонстрация сокращения (reduce)");
    System.out.println("7. Демонстрация коллекционирования (collect)");

    System.out.println("8. Выход");
  }

  /**
   * Демонстрация интерфейса Comparable
   */
  private static void demonstrateComparable(InputValidator validator) {
    System.out.println("\n=== ДЕМОНСТРАЦИЯ ИНТЕРФЕЙСА COMPARABLE ===");

    System.out.print("Введите первое число для сравнения: ");
    int number1 = validator.getValidInt("");

    System.out.print("Введите второе число для сравнения: ");
    int number2 = validator.getValidInt("");

    Comparable<Integer> comparableNumber = new Comparable<Integer>() {
      @Override
      public int compareTo(Integer other) {
        return Integer.compare(number1, other);
      }
    };

    int result = comparableNumber.compareTo(number2);
    System.out.println("Результат сравнения " + number1 + " и " + number2 + ": " + result);
    System.out.println("Интерпретация:");
    if (result > 0) {
      System.out.println(number1 + " больше " + number2);
    } else if (result < 0) {
      System.out.println(number1 + " меньше " + number2);
    } else {
      System.out.println(number1 + " равно " + number2);
    }
  }
  /**
   * Демонстрация сравнения студентов
   */
  private static void demonstrateStudentComparison(InputValidator validator) {
    System.out.println("\n=== СРАВНЕНИЕ СТУДЕНТОВ ПО СРЕДНЕМУ БАЛЛУ ===");

    // Создаем первого студента
    System.out.println("Первый студент:");
    String name1 = validator.getValidStudentName("Введите имя первого студента: ");
    String group1 = validator.getValidGroup("Введите группу первого студента: ");
    ComparableStudent student1 = new ComparableStudent(name1, group1);

    System.out.println("Добавление оценок для первого студента:");
    addGradesToStudent(student1, validator);

    // Создаем второго студента
    System.out.println("\nВторой студент:");
    String name2 = validator.getValidStudentName("Введите имя второго студента: ");
    String group2 = validator.getValidGroup("Введите группу второго студента: ");
    ComparableStudent student2 = new ComparableStudent(name2, group2);

    System.out.println("Добавление оценок для второго студента:");
    addGradesToStudent(student2, validator);

    // Сравниваем студентов
    System.out.println("\n=== РЕЗУЛЬТАТЫ СРАВНЕНИЯ ===");
    System.out.println("Студент 1: " + student1);
    System.out.println("Студент 2: " + student2);

    int result = student1.compareTo(student2);

    System.out.println("\nРезультат сравнения: " + result);
    System.out.println("Интерпретация:");
    if (result > 0) {
      System.out.println(student1.getName() + " имеет более высокий средний балл");
    } else if (result < 0) {
      System.out.println(student2.getName() + " имеет более высокий средний балл");
    } else {
      System.out.println("Студенты имеют одинаковый средний балл");
    }
  }
  /**
   * Добавление оценок студенту
   */
  private static void addGradesToStudent(ComparableStudent student, InputValidator validator) {
    boolean adding = true;
    while (adding) {
      System.out.println("Текущий студент: " + student);
      System.out.println("1. Добавить оценку");
      System.out.println("2. Закончить добавление оценок");

      int choice = validator.getMenuChoice("Выберите действие: ", 2);

      if (choice == 1) {
        int grade = validator.getValidGrade("Введите оценку (2-5): ");
        if (student.tryAddGrade(grade)) {
          System.out.println("Оценка " + grade + " добавлена");
        }
      } else {
        adding = false;
      }
    }
  }
      /**
   * Демонстрация коробки с трехмерной точкой
   */

  public static void putPointToBox(Box<? super Point3D> box, InputValidator validator) {
    System.out.println("Введите координаты трехмерной точки:");
    int x = validator.getValidCoordinate("Введите координату X: ");
    int y = validator.getValidCoordinate("Введите координату Y: ");
    int z = validator.getValidCoordinate("Введите координату Z: ");

    Point3D point = new Point3D(x, y, z);
    box.putContent(point);
    System.out.println("Точка " + point + " помещена в коробку");
  }

  /**
   * Демонстрация задания "Начало отсчета"
   */
  private static void demonstrateBoxWithPoint3d(InputValidator validator) {
    System.out.println("\n=== НАЧАЛО ОТСЧЕТА - КОРОБКА С ТРЕХМЕРНОЙ ТОЧКОЙ ===");

    System.out.println("Демонстрация, что метод принимает два вида параметризации:");

    //точный тип
    System.out.println("\n1. Коробка Box<Point3d>:");
    Box<Point3D> pointBox = new Box<>();
    System.out.println("Создана коробка: " + pointBox);

    putPointToBox(pointBox, validator);
    System.out.println("После вызова метода: " + pointBox);

    //супертип
    System.out.println("\n2. Коробка Box<Object>:");
    Box<Object> objectBox = new Box<>();
    System.out.println("Создана коробка: " + objectBox);

    putPointToBox(objectBox, validator);
    System.out.println("После вызова метода: " + objectBox);


  }
  /**
   * Демонстрация функциональных методов (map)
   */
  private static void demonstrateMapMethods(InputValidator validator) {
    System.out.println("\n=== ДЕМОНСТРАЦИЯ ФУНКЦИЙ (MAP) ===");

    System.out.println("1. Преобразование строк в их длины:");
    List<String> strings = inputStringList(validator);
    System.out.println("Исходный список: " + strings);

    List<Integer> lengths = GenericUtils.map(strings, str -> str.length());
    System.out.println("Результат (длины строк): " + lengths);

    System.out.println("\n2. Преобразование чисел в их модули:");
    List<Integer> numbers = inputNumberList(validator);
    System.out.println("Исходный список: " + numbers);

    List<Integer> absolutes = GenericUtils.map(numbers, num -> Math.abs(num));
    System.out.println("Результат (модули чисел): " + absolutes);

    System.out.println("\n3. Нахождение максимальных значений в массивах:");
    List<int[]> arrays = inputArrayList(validator);
    System.out.print("Исходный список массивов: ");
    for (int[] array : arrays) {
      System.out.print(Arrays.toString(array) + " ");
    }
    System.out.println();

    List<Integer> maxValues = GenericUtils.map(arrays, array -> {
      int max = array[0];
      for (int i = 1; i < array.length; i++) {
        if (array[i] > max) {
          max = array[i];
        }
      }
      return max;
    });
    System.out.println("Результат (максимумы массивов): " + maxValues);
  }
  /**
   * Демонстрация методов фильтрации (filter)
   */
  private static void demonstrateFilterMethods(InputValidator validator) {
    System.out.println("\n=== ДЕМОНСТРАЦИЯ ФИЛЬТРАЦИИ (FILTER) ===");

    System.out.println("1. Фильтрация строк (длина >= 3):");
    List<String> strings = inputStringList(validator);
    System.out.println("Исходный список: " + strings);

    List<String> longStrings = GenericUtils.filter(strings, str -> str.length() >= 3);
    System.out.println("Результат (строки длиной >= 3): " + longStrings);

    System.out.println("\n2. Фильтрация положительных чисел:");
    List<Integer> numbers = inputNumberList(validator);
    System.out.println("Исходный список: " + numbers);

    List<Integer> positiveNumbers = GenericUtils.filter(numbers, num -> num > 0);
    System.out.println("Результат (положительные числа): " + positiveNumbers);

    System.out.println("\n3. Фильтрация массивов без положительных элементов:");
    List<int[]> arrays = inputArrayList(validator);
    System.out.print("Исходный список массивов: ");
    for (int[] array : arrays) {
      System.out.print(Arrays.toString(array) + " ");
    }
    System.out.println();

    List<int[]> noPositiveArrays = GenericUtils.filter(arrays, array -> {
      for (int element : array) {
        if (element > 0) {
          return false;
        }
      }
      return true;
    });
    System.out.print("Результат (массивы без положительных элементов): ");
    for (int[] array : noPositiveArrays) {
      System.out.print(Arrays.toString(array) + " ");
    }
    System.out.println();
  }
  /**
   * Демонстрация методов сокращения (reduce)
   */
  private static void demonstrateReduceMethods(InputValidator validator) {
    System.out.println("\n=== ДЕМОНСТРАЦИЯ СОКРАЩЕНИЯ (REDUCE) ===");

    System.out.println("1. Конкатенация строк:");
    List<String> strings = inputStringList(validator);
    System.out.println("Исходный список: " + strings);

    String concatenation = GenericUtils.reduceSafe(strings, "", (accumulator, str) -> accumulator + str);
    System.out.println("Результат (конкатенация): " + concatenation);

    System.out.println("\n2. Сумма чисел:");
    List<Integer> numbers = inputNumberList(validator);
    System.out.println("Исходный список: " + numbers);

    Integer sum = GenericUtils.reduceSafe(numbers, 0, (accumulator, num) -> accumulator + num);
    System.out.println("Результат (сумма): " + sum);

    System.out.println("\n3. Общее количество элементов во вложенных списках:");
    List<List<Integer>> lists = inputListOfLists(validator);
    System.out.println("Исходный список списков: " + lists);

    List<Integer> sizes = GenericUtils.map(lists, list -> list.size());
    Integer totalLength = GenericUtils.reduceSafe(sizes, 0, (accumulator, size) -> accumulator + size);
    System.out.println("Общее количество элементов: " + totalLength);

    System.out.println("\n4. Демонстрация безопасности с пустым списком:");
    List<String> emptyList = new ArrayList<>();
    String result = GenericUtils.reduceSafe(emptyList, "Пусто", (accumulator, str) -> accumulator + str);
    System.out.println("Результат для пустого списка: " + result);
  }
  /**
   * Ввод списка строк с клавиатуры
   */
  private static List<String> inputStringList(InputValidator validator) {
    List<String> list = new ArrayList<>();
    int count = validator.getValidPositiveInt("Введите количество строк: ");

    for (int i = 0; i < count; i++) {
      String str = validator.getValidString("Введите строку " + (i + 1) + ": ", 1);
      list.add(str);
    }
    return list;
  }
  /**
   * Ввод списка чисел с клавиатуры
   */
  private static List<Integer> inputNumberList(InputValidator validator) {
    List<Integer> list = new ArrayList<>();
    int count = validator.getValidPositiveInt("Введите количество чисел: ");

    for (int i = 0; i < count; i++) {
      int num = validator.getValidInt("Введите число " + (i + 1) + ": ");
      list.add(num);
    }
    return list;
  }

  /**
   * Ввод списка массивов с клавиатуры
   */
  private static List<int[]> inputArrayList(InputValidator validator) {
    List<int[]> list = new ArrayList<>();
    int arrayCount = validator.getValidPositiveInt("Введите количество массивов: ");

    for (int i = 0; i < arrayCount; i++) {
      int size = validator.getValidPositiveInt("Введите размер массива " + (i + 1) + ": ");
      int[] array = new int[size];

      for (int j = 0; j < size; j++) {
        array[j] = validator.getValidInt("Введите элемент " + (j + 1) + " массива " + (i + 1) + ": ");
      }
      list.add(array);
    }
    return list;
  }
  /**
   * Ввод списка списков с клавиатуры
   */
  private static List<List<Integer>> inputListOfLists(InputValidator validator) {
    List<List<Integer>> list = new ArrayList<>();
    int listCount = validator.getValidPositiveInt("Введите количество списков: ");

    for (int i = 0; i < listCount; i++) {
      System.out.println("Список " + (i + 1) + ":");
      List<Integer> sublist = inputNumberList(validator);
      list.add(sublist);
    }
    return list;
  }
  /**
   * Демонстрация задания "Коллекционирование"
   */
  private static void demonstrateCollectMethods(InputValidator validator) {
    System.out.println("\n=== КОЛЛЕКЦИОНИРОВАНИЕ ===");

    // 1. Разбиение чисел на положительные и отрицательные
    System.out.println("1. Разбиение чисел на положительные и отрицательные:");
    List<Integer> numbers = inputNumberList(validator);
    System.out.println("Исходный список: " + numbers);

    Map<String, List<Integer>> numberGroups = GenericUtils.collect(
            numbers,
            new GenericUtils.CollectionCreator<Map<String, List<Integer>>>() {
              @Override
              public Map<String, List<Integer>> create() {
                Map<String, List<Integer>> map = new HashMap<>();
                map.put("positive", new ArrayList<>());
                map.put("negative", new ArrayList<>());
                return map;
              }
            },
            new GenericUtils.CollectionAdder<Map<String, List<Integer>>, Integer>() {
              @Override
              public void add(Map<String, List<Integer>> map, Integer number) {
                if (number > 0) {
                  map.get("positive").add(number);
                } else if (number < 0) {
                  map.get("negative").add(number);
                }
              }
            }
    );

    System.out.println("Положительные: " + numberGroups.get("positive"));
    System.out.println("Отрицательные: " + numberGroups.get("negative"));

    // 2. Разбиение строк по длине
    System.out.println("\n2. Разбиение строк по длине:");
    List<String> strings = inputStringList(validator);
    System.out.println("Исходный список: " + strings);

    Map<Integer, List<String>> lengthGroups = GenericUtils.collect(
            strings,
            new GenericUtils.CollectionCreator<Map<Integer, List<String>>>() {
              @Override
              public Map<Integer, List<String>> create() {
                return new HashMap<>();
              }
            },
            new GenericUtils.CollectionAdder<Map<Integer, List<String>>, String>() {
              @Override
              public void add(Map<Integer, List<String>> map, String str) {
                int length = str.length();
                if (!map.containsKey(length)) {
                  map.put(length, new ArrayList<>());
                }
                map.get(length).add(str);
              }
            }
    );

    System.out.println("Группы по длине:");
    for (Map.Entry<Integer, List<String>> entry : lengthGroups.entrySet()) {
      System.out.println("  Длина " + entry.getKey() + ": " + entry.getValue());
    }

    System.out.println("\n3. Удаление дубликатов:");
    List<String> stringsWithDuplicates = inputStringList(validator);
    System.out.println("Исходный список: " + stringsWithDuplicates);

    Set<String> uniqueStrings = GenericUtils.collect(
            stringsWithDuplicates,
            new GenericUtils.CollectionCreator<Set<String>>() {
              @Override
              public Set<String> create() {
                return new HashSet<>();
              }
            },
            new GenericUtils.CollectionAdder<Set<String>, String>() {
              @Override
              public void add(Set<String> set, String str) {
                set.add(str);
              }
            }
    );

    System.out.println("Уникальные строки: " + uniqueStrings);
  }



}
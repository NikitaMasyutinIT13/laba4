import java.util.ArrayList;
import java.util.List;

/**
 * Утилитный класс с обобщенными методами
 */
public class GenericUtils {

  /**
   * Применяет функцию к каждому элементу списка

   */
  public static <T, R> List<R> map(List<T> list, Function<T, R> function) {
    List<R> result = new ArrayList<>();
    for (T element : list) {
      result.add(function.apply(element));
    }
    return result;
  }

  /**
   * Фильтрует список по условию

   */
  public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
    List<T> result = new ArrayList<>();
    for (T element : list) {
      if (predicate.test(element)) {
        result.add(element);
      }
    }
    return result;
  }

  /**
   * Сокращает список к одному значению
   * @param <T> тип элементов
   * @param list входной список
   * @param initialValue начальное значение аккумулятора
   * @param reducer функция сокращения
   * @return результат сокращения
   */
  public static <T> T reduce(List<T> list, T initialValue, Reducer<T> reducer) {
    T accumulator = initialValue;
    for (T element : list) {
      accumulator = reducer.reduce(accumulator, element);
    }
    return accumulator;
  }

  /**
   * Сокращает список к одному значению (безопасная версия)
   * Если список пуст, возвращает начальное значение
   * @param <T> тип элементов
   * @param list входной список
   * @param initialValue начальное значение аккумулятора
   * @param reducer функция сокращения
   * @return результат сокращения или начальное значение если список пуст
   */
  public static <T> T reduceSafe(List<T> list, T initialValue, Reducer<T> reducer) {
    if (list == null || list.isEmpty()) {
      return initialValue;
    }
    return reduce(list, initialValue, reducer);
  }
  interface CollectionCreator<P> {
    P create();
  }

  /**
   * Интерфейс для добавления элементов в коллекцию
   */
  interface CollectionAdder<P, T> {
    void add(P collection, T element);
  }

  /**
   * Метод для коллекционирования
   * @param <T> тип исходных элементов
   * @param <P> тип результирующей коллекции
   * @param sourceList исходный список значений
   * @param collectionCreator способ создания результирующей коллекции
   * @param collectionAdder способ передачи значений в результирующую коллекцию
   * @return коллекция типа P со значениями типа T
   */
  public static <T, P> P collect(
          List<T> sourceList,
          CollectionCreator<P> collectionCreator,
          CollectionAdder<P, T> collectionAdder) {

    P result = collectionCreator.create();
    for (T element : sourceList) {
      collectionAdder.add(result, element);
    }
    return result;
  }
}
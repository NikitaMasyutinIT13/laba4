/**
 * Функциональный интерфейс для применения функции
 */
interface Function<T, R> {
  /**
   * Применяет функцию к значению
   */
  R apply(T value);
}

/**
 * Функциональный интерфейс для проверки условия
 */
interface Predicate<T> {
  /**
   * Проверяет условие для значения

   */
  boolean test(T value);
}

/**
 * Функциональный интерфейс для сокращения
 */
interface Reducer<T> {
  /**
   * Сокращает два значения в одно
   */
  T reduce(T accumulator, T element);
}
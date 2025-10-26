/**
 * Интерфейс для сравнения объектов
 */
public interface Comparable<T> {

  /**
   * Сравнивает текущий объект с другим объектом
   */
  int compareTo(T other);
}
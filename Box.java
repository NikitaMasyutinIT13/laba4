/**
 * Обобщенный класс коробки для хранения одного объекта
 */
public class Box<T> {
  private T content;

  /**
   * Конструктор по умолчанию - создает пустую коробку
   */
  public Box() {
    this.content = null;
  }

  /**
   * Конструктор с содержимым
   */
  public Box(T content) {
    this.content = content;
  }

  /**
   * Получить содержимое коробки

   */
  public T getContent() {
    T temp = content;
    content = null;
    return temp;
  }

  /**
   * Положить объект в коробку
   */
  public void putContent(T content) {
    if (this.content != null) {
      throw new IllegalStateException("Коробка уже заполнена. Сначала извлеките текущее содержимое.");
    }
    this.content = content;
  }

  /**
   * Посмотреть содержимое коробки без извлечения
   */
  public T peekContent() {
    return content;
  }

  /**
   * Проверить, пуста ли коробка
   */
  public boolean isEmpty() {
    return content == null;
  }

  /**
   * Проверить, заполнена ли коробка
   */
  public boolean isFull() {
    return content != null;
  }

  /**
   * Очистить коробку
   */
  public void clear() {
    content = null;
  }

  /**
   * Строковое представление коробки
   */
  @Override
  public String toString() {
    if (isEmpty()) {
      return "Коробка пуста";
    } else {
      return "Коробка содержит: " + content.toString();
    }
  }
}
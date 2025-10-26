/**
 * Студент с возможностью сравнения по среднему баллу
 */
public class ComparableStudent extends Student implements Comparable<ComparableStudent> {

  /**
   * Конструктор по умолчанию
   */
  public ComparableStudent() {
    super();
  }

  /**
   * Конструктор с именем и группой
   */
  public ComparableStudent(String name, String group) {
    super(name, group);
  }

  /**
   * Сравнивает студентов по среднему баллу
   */
  @Override
  public int compareTo(ComparableStudent other) {
    double currentAverage = this.getAverageGrade();
    double otherAverage = other.getAverageGrade();

    if (currentAverage > otherAverage) {
      return 1;
    }
    else if (currentAverage < otherAverage) {
      return -1;
    }
    else {
      return 0;
    }
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
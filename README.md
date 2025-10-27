Структура проекта
Основные классы:
GenericsMain - главный класс с пользовательским меню

InputValidator - класс для валидации пользовательского ввода

GenericUtils - утилитный класс с обобщенными методами

Student и ComparableStudent - классы для работы со студентами

Point и Point3d - классы для работы с точками

Box - обобщенный класс коробки

FunctionalInterfaces - функциональные интерфейсы

Описание задач и алгоритмов
Задача 1: Демонстрация интерфейса Comparable
Цель: Показать работу интерфейса Comparable для сравнения объектов.

Алгоритм выполнения:

Выводим приглашение для ввода первого числа

Вызываем validator.getValidInt("") для получения первого числа

Выводим приглашение для ввода второго числа

Вызываем validator.getValidInt("") для получения второго числа

Создаем анонимный класс, реализующий Comparable<Integer>

В методе compareTo() используем Integer.compare(number1, other)

Вызываем comparableNumber.compareTo(number2) и сохраняем результат

Анализируем результат:

Если результат > 0: первое число больше

Если результат < 0: первое число меньше

Если результат = 0: числа равны

Выводим числовой результат и текстовую интерпретацию
<img width="353" height="137" alt="image" src="https://github.com/user-attachments/assets/1c734fad-07a3-4adb-9053-a68b7bf7b643" />

Задача 2: Сравнение студентов по среднему баллу
Цель: Реализовать сравнение студентов на основе среднего балла.

Алгоритм выполнения:

Для первого студента:

Вызываем validator.getValidStudentName() для ввода имени

Вызываем validator.getValidGroup() для ввода группы

Создаем объект ComparableStudent

Вызываем addGradesToStudent() для добавления оценок

Для второго студента:

Повторяем шаги 1-4 из первого студента

Добавление оценок (метод addGradesToStudent):

Выводим текущую информацию о студенте

Показываем меню: "1. Добавить оценку", "2. Закончить"

Если выбран пункт 1:

Вызываем validator.getValidGrade() для ввода оценки

Вызываем student.tryAddGrade() для добавления

Выводим подтверждение добавления

Повторяем до выбора пункта 2

Сравнение студентов:

Вызываем student1.compareTo(student2)

Анализируем результат:

Если результат > 0: первый студент имеет более высокий средний балл

Если результат < 0: второй студент имеет более высокий средний балл

Если результат = 0: средние баллы равны

Выводим подробную информацию о студентах и результат сравнения
<img width="638" height="161" alt="image" src="https://github.com/user-attachments/assets/9490d5d8-268e-4ddf-9b65-f2ed92d5f4c9" />

Задача 3: Начало отсчета - коробка с трехмерной точкой
Цель: Демонстрация работы с обобщенными типами и wildcards.

Алгоритм выполнения:

Создаем пустую коробку: Box<Point3d> box = new Box<>()

Выводим сообщение о создании коробки

Ввод координат точки:

Вызываем validator.getValidCoordinate() для координаты X

Вызываем validator.getValidCoordinate() для координаты Y

Вызываем validator.getValidCoordinate() для координаты Z

Создаем объект точки: Point3d point = new Point3d(x, y, z)

Помещаем точку в коробку: box.putContent(point)

Выводим сообщение о successful размещении

Показываем состояние коробки после операции
<img width="392" height="176" alt="image" src="https://github.com/user-attachments/assets/c9aa0489-9bc9-47b8-b59b-e298b3a83e9f" />

<img width="385" height="174" alt="image" src="https://github.com/user-attachments/assets/3b1aa2b2-65cb-41f4-bddc-04e8a8b38af8" />

Задача 4: Демонстрация функций (map)
Цель: Показать применение функции к каждому элементу списка.

Алгоритм выполнения:

Преобразование строк в длины:

Вызываем inputStringList(validator) для ввода списка строк

Вызываем GenericUtils.map(strings, str -> str.length())

Для каждой строки в списке вычисляется ее длина

Возвращается новый список с длинами строк
<img width="324" height="154" alt="image" src="https://github.com/user-attachments/assets/d7285189-f289-438f-8269-3f06139f23b7" />


Вычисление модулей чисел:

Вызываем inputNumberList(validator) для ввода списка чисел

Вызываем GenericUtils.map(numbers, num -> Math.abs(num))

Для каждого числа вычисляется абсолютное значение

Возвращается новый список с модулями
<img width="351" height="159" alt="image" src="https://github.com/user-attachments/assets/71a4f304-beab-4ce8-98e8-cd43f089e15b" />

Нахождение максимумов в массивах:

Вызываем inputArrayList(validator) для ввода массивов

Вызываем GenericUtils.map(arrays, array -> { ... })

Для каждого массива:

Инициализируем max = array[0]

Проходим по всем элементам массива от 1 до length-1

Если array[i] > max, обновляем max = array[i]

Возвращаем max

Возвращается список максимальных значений

<img width="429" height="230" alt="image" src="https://github.com/user-attachments/assets/ba0409ec-5fa9-44b4-b38e-0aaf6640961e" />

Задача 5: Демонстрация фильтрации (filter)
Цель: Показать фильтрацию элементов по условию.

Алгоритм выполнения:

Фильтрация строк по длине:

Вызываем inputStringList(validator) для ввода строк

Вызываем GenericUtils.filter(strings, str -> str.length() >= 3)

Для каждой строки проверяется условие: длина >= 3

Если условие истинно, строка добавляется в результат

Возвращается список строк длиной ≥ 3 символов
<img width="415" height="161" alt="image" src="https://github.com/user-attachments/assets/4e77dec5-434a-404f-b2d7-55dac8657062" />

Фильтрация положительных чисел:

Вызываем inputNumberList(validator) для ввода чисел

Вызываем GenericUtils.filter(numbers, num -> num > 0)

Для каждого числа проверяется условие: число > 0

Если условие истинно, число добавляется в результат

Возвращается список положительных чисел
<img width="363" height="164" alt="image" src="https://github.com/user-attachments/assets/47cfdffd-758b-455d-ba25-b64e8824f05f" />
 
 Фильтрация массивов без положительных элементов
Пошаговый алгоритм фильтрации:

Инициализация:

Создаем пустой список для результатов: List<int[]> result = new ArrayList<>()

Получаем исходный список массивов

Проверка каждого массива:

Для каждого массива в исходном списке:

Шаг 1: Устанавливаем флаг hasPositive = false

Шаг 2: Проходим по всем элементам массива:

Для каждого элемента element в массиве:

Проверяем условие: if (element > 0)

Если элемент > 0 (положительный):

Устанавливаем hasPositive = true

Прерываем цикл (break) - дальше проверять нет смысла

Шаг 3: Если hasPositive == false (в массиве нет положительных элементов):

Добавляем этот массив в результирующий список

Возврат результата:

Возвращаем отфильтрованный список массивов
<img width="488" height="176" alt="image" src="https://github.com/user-attachments/assets/336eebfc-be04-49e5-b98e-cc4e090005d0" />

Задача 6: Демонстрация сокращения (reduce)
Цель: Показать сокращение списка к одному значению.

Алгоритм выполнения:

Конкатенация строк:

Вызываем inputStringList(validator) для ввода строк

Вызываем GenericUtils.reduceSafe(strings, "", (acc, str) -> acc + str)

Инициализируем аккумулятор пустой строкой

Для каждой строки в списке: аккумулятор = аккумулятор + строка

Возвращается результирующая строка
<img width="337" height="154" alt="image" src="https://github.com/user-attachments/assets/a1991e0c-59b9-4e98-8ca5-b75557316fb8" />

Суммирование чисел:

Вызываем inputNumberList(validator) для ввода чисел

Вызываем GenericUtils.reduceSafe(numbers, 0, (acc, num) -> acc + num)

Инициализируем аккумулятор нулем

Для каждого числа в списке: аккумулятор = аккумулятор + число

Возвращается сумма всех чисел
<img width="307" height="161" alt="image" src="https://github.com/user-attachments/assets/6a2fb0b6-a424-4113-80a0-51323c44b45c" />
Общее количество элементов во вложенных списках:
Инициализация:

Устанавливаем начальное значение аккумулятора: int total = 0

Получаем список вложенных списков

Обработка каждого внутреннего списка:

Для каждого внутреннего списка innerList в основном списке:

Получаем размер текущего внутреннего списка: int size = innerList.size()

Добавляем размер к аккумулятору: total = total + size

Возврат результата:

Возвращаем итоговое значение аккумулятора
<img width="482" height="219" alt="image" src="https://github.com/user-attachments/assets/5933f6f3-092b-480c-8cef-65d314980f9d" />

Задача 7: Коллекционирование (collect)
Цель: Демонстрация преобразования списка в различные коллекции.

Алгоритм выполнения:

Группировка чисел на положительные/отрицательные:

Вызываем inputNumberList(validator) для ввода чисел

Вызываем GenericUtils.collect() с:

CollectionCreator: создает Map с ключами "positive" и "negative"

CollectionAdder: для каждого числа проверяет знак и добавляет в соответствующий список

Возвращается Map с двумя списками
<img width="450" height="184" alt="image" src="https://github.com/user-attachments/assets/9b6dece5-39e9-499a-be2e-ae24a5efc325" />

Группировка строк по длине:

Вызываем inputStringList(validator) для ввода строк

Вызываем GenericUtils.collect() с:

CollectionCreator: создает пустой HashMap

CollectionAdder: для каждой строки вычисляет длину, создает список если нужно, добавляет строку

Возвращается Map где ключ - длина строки, значение - список строк этой длины
<img width="262" height="200" alt="image" src="https://github.com/user-attachments/assets/b0155e41-c9fe-4bff-b7d0-416f306d7570" />

Удаление дубликатов:

Вызываем inputStringList(validator) для ввода строк

Вызываем GenericUtils.collect() с:

CollectionCreator: создает новый HashSet

CollectionAdder: использует метод Set.add() для добавления элементов

Возвращается Set с уникальными строками
<img width="298" height="152" alt="image" src="https://github.com/user-attachments/assets/4be1f8b6-01ba-45c8-8f59-eb68b132e38a" />

Алгоритмы работы методов GenericUtils
1. Map (преобразование)
Пошаговый алгоритм:

Создаем пустой ArrayList для результатов

Инициализируем индекс i = 0

Пока i < list.size():

Получаем элемент: T element = list.get(i)

Вызываем function.apply(element) и получаем результат R

Добавляем результат в список результатов

Увеличиваем i на 1

Возвращаем список результатов

2. Filter (фильтрация)

Пошаговый алгоритм:

Создаем пустой ArrayList для результатов

Инициализируем индекс i = 0

Пока i < list.size():

Получаем элемент: T element = list.get(i)

Вызываем predicate.test(element)

Если результат true, добавляем element в список результатов

Увеличиваем i на 1

Возвращаем отфильтрованный список

3. Reduce (сокращение)
Пошаговый алгоритм:

Инициализируем аккумулятор: T accumulator = initialValue

Инициализируем индекс i = 0

Пока i < list.size():

Получаем элемент: T element = list.get(i)

Вызываем reducer.reduce(accumulator, element)

Сохраняем результат в accumulator

Увеличиваем i на 1

Возвращаем accumulator

4. Collect (коллекционирование)

Пошаговый алгоритм:

Вызываем creator.create() для создания коллекции P

Инициализируем индекс i = 0

Пока i < sourceList.size():

Получаем элемент: T element = sourceList.get(i)

Вызываем adder.add(collection, element) для добавления элемента в коллекцию

Увеличиваем i на 1

Возвращаем заполненную коллекцию

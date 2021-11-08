import calculator.Calculator;
import lections.Lection;
import lections.Student;
import lections.StudingStatistics;
import persons.Person;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main8 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task1(){
        System.out.println("Задание 1:");
        String[] names =new String[]{"Алексей", "Иван", "Вольдемар", "Юрий", "Сергей", "Мирон"};

        final int personCount = 10;
        Random random = new Random();

        List<Person> persons = new ArrayList<>();
        for(int i=0; i<personCount; i++){
            Person person = new Person(names[random.nextInt(names.length)], random.nextInt(100));
            persons.add(person);
        }

        Collections.sort(persons, Comparator.comparing(Person::getName));
        System.out.println("Сортировка по имени:");
        System.out.println(persons);

        Collections.sort(persons, Comparator.comparing(Person::getAge));
        System.out.println("Сортировка по возрасту:");
        System.out.println(persons);
    }

    private static void task2(){
        System.out.println("Задание 2:");
        Calculator calculator = new Calculator();
        calculator.addOperation("Умножение", ((number1, number2) -> number1*number2));
        calculator.addOperation("Деление", ((number1, number2) -> number1/number2));
        calculator.addOperation("Сложение", (Double::sum));
        calculator.addOperation("Вычитание", (number1, number2) -> number1-number2);
        calculator.addOperation("Возведение в степень", (number1, number2) -> Math.pow(number1, number2));
        calculator.addOperation("Извлечение корня степени n", (number1, number2) -> Math.pow(number1, 1/number2));

        double n1 = 4;
        double n2 = 2;
        print(calculator, "Умножение", n1, n2);
        print(calculator, "Деление", n1, n2);
        print(calculator, "Сложение", n1, n2);
        print(calculator, "Вычитание", n1, n2);
        print(calculator, "Возведение в степень", n1, n2);
        print(calculator, "Извлечение корня степени n", n1, n2);
    }

    private static void print(Calculator calculator, String operationsName, Double number1, Double number2){
        Double result = calculator.calculate(operationsName, number1, number2);
        System.out.printf("Operations: %s, n1: %s, n2: %s = %s\n", operationsName, number1, number2, result);
    }

    public static void task3(){
        System.out.println("Задание 3:");
        String[] lectureNames = new String[]{
                "Матанализ",
                "Философия",
                "Английкий язык",
                "История",
                "Физкультура"
        };

        Supplier<Set<Lection>> lectionsGenerator = ()-> {
            Random random = new Random();

            LocalDate startDate = LocalDate.of(2021, 11, 1);
            LocalDate endDate = startDate.plusDays(14);

            Set<Lection> result = new HashSet<>();

            for(String lecture: lectureNames){
                List<LocalDate> dates = startDate.datesUntil(endDate)
                        .collect(Collectors.toList());
                Collections.shuffle(dates, random);
                int visitesCount = random.nextInt(dates.size()+1);

                for(int i=0; i<visitesCount; i++){
                    result.add(new Lection(lecture, dates.get(i)));
                }
            }

            return result;
        };

        List<Student> students = new ArrayList<>();

        for(int i=0; i<10; i++){
            students.add(new Student("Студент "+i, lectionsGenerator));
        }

        for(Student student: students){
            student.printInfo();
        };

        StudingStatistics studingStatistics = new StudingStatistics(students);

        studingStatistics.printStudentsVisitedAtOnce("Матанализ");
        studingStatistics.printQuantityVisits();
        studingStatistics.printLectionsNamesMaxVisites();
        studingStatistics.printStudentsMaxVisites();
        studingStatistics.printCountStudentForLections();
    }
}

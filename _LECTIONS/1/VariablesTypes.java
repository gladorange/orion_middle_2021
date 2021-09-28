public class VariablesTypes {

    public static class Person {
        static int countOfPerson = 0;
        String name;
        int age;


        public Person(String name, int age) {
            this.age = age;
            this.name = name;
            countOfPerson++;
        }


        public void printHello() {
            System.out.println("Hello, I'm " + name + ". My age is " + age + " years");
        }

        public static void printCountOfPersons() {
            System.out.printf("Count of persons is %s", countOfPerson);
        }


    }

    public static void main(String[] args) {
        Person vasya = new Person("Vasya", 18);
        vasya.printHello();


        Person petya = new Person("Petya", 30);
        petya.printHello();


        Person somePerson = petya;
        somePerson.name = "Changed";


        petya.printHello();

        Person.printCountOfPersons();
    }

}

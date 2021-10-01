public class Arguments {


    public static void main(String[] args) {


        if (args.length < 2) {
            System.out.println("Нужно два аргумента");
            return;
        }

        String arg1 = args[0];
        String arg2 = args[1];


        System.out.println("Аргументы  в обратном порядке");
        System.out.println(arg2);
        System.out.println(arg1);

    }
}

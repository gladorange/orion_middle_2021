public class ImmutableString {


    public static void main(String[] args) {
        String hello = "Hello,";
        final String replace = hello.replace(",", ", World!");

        System.out.println(hello);
        System.out.println(replace);
    }
}

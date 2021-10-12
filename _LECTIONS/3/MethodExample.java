public class MethodExample {


    public static void main(String[] args) {
        someMethod("42", 3);
    }


    /**
     * This method parses first argument then adds second argument then print sum to screen
     * @param firstArg
     * @param secondArg
     */
    public static void someMethod(String firstArg, int secondArg) {
        int firstArgParsed = Integer.parseInt(firstArg);
        System.out.println(firstArgParsed + secondArg);
    }
}

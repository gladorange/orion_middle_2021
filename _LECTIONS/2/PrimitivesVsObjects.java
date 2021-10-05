public class PrimitivesVsObjects {


    public static void main(String[] args) {
        measuteObject();
        measutePrimitive();
    }

    private static void measutePrimitive() {
        int size = 10_000_000;

        final long start = System.currentTimeMillis();

        int[] primArray = new int[size];
        for (int i = 0; i < size; i++) {
            primArray[i] = i;
        }

        System.out.println(System.currentTimeMillis() - start);
        System.out.println("Конец");
    }

    private static void measuteObject() {
        int size = 10_000_000;

        final long start = System.currentTimeMillis();

        Integer[] primArray = new Integer[size];
        for (int i = 0; i < size; i++) {
            primArray[i] = i;
        }

        System.out.println(System.currentTimeMillis() - start);
        System.out.println("Конец");

        int a = 5;
        getClassName(a);
    }


    static void getClassName(Integer a) {
        System.out.println(a.getClass().getName());
    }
}

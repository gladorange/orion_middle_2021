public class GoodExample {


    public static final String CLASS_NAME = "GoodExample";
    static int counter = 0;
    int value;

    public GoodExample(int value) {
        this.value = value;
    }

    public void printPreparedValue() {
        System.out.println(prepareValue(value));
    }

    private int prepareValue(int value) {
        if (value < 0) {
            return value * -1;
        }
        return value;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        GoodExample ex = new GoodExample(-15);
        ex.printPreparedValue();
        System.out.println(ex.getValue());
    }
}

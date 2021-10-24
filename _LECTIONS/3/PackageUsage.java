import static com.orion.lection.lesson3.PackageExample.SOME_VARIABLE;
import static com.orion.lection.lesson3.PackageExample.staticMethod;

import com.orion.lection.lesson3.PackageExample;

public class PackageUsage {

    public static void main(String[] args) {
        PackageExample example = new PackageExample();
        System.out.println(SOME_VARIABLE);
        staticMethod();
    }
}

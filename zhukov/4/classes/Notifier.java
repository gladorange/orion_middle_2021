package classes;

import org.jetbrains.annotations.NotNull;
import enums.Notices;

public class Notifier {

    public static void notice(@NotNull Notices notice){
        System.out.print(notice.getComment() );
    }
    public static void notice(@NotNull Notices notice, String... args){
        System.out.printf(notice.getComment(),  args);
    }
}

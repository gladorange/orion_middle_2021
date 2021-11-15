package lection10.task1.commands;

public class Dir extends Command{

    public Dir() {
        name = "dir";
    }

    @Override
    public String getHelp() {
        return name + " - показывает текущую директорию, команда не требует параметров";
    }

    @Override
    public void execute(String s) {
        System.out.println(System.getProperty("user.dir"));
    }
}

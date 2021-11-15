package ru.task10;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.task10.CommandExecCode.*;

enum CommandExecCode {
    ERROR, EXIT, OUTPUT //  возможные коды (инфо) которые возвращает наша выполненная команда
}

class CommandReturnInfo {
    final Set<CommandExecCode> codes = new HashSet<>();
    final List<String> messages = new ArrayList<>();

    /*
    Чтобы постоянно не писать Arrays.asList можно было бы: Сделать аргумент var-arg'ом
    Перегрузить конструктор, чтобы принимал одничное значение,
    а не коллекцию. и из перегруженного конструктора вызвать конструктор с коллекцией в качестве аргумента.
     */
    CommandReturnInfo(List<String> list, CommandExecCode... codesArr) {
        this.messages.addAll(list);
        Collections.addAll(codes, codesArr);
    }

    CommandReturnInfo(String message, CommandExecCode... codesArr) {
        this.messages.add(message);
        Collections.addAll(codes, codesArr);
    }

    CommandReturnInfo(CommandExecCode... codesArr) {
        Collections.addAll(codes, codesArr);
    }

    boolean containsCode(CommandExecCode code) {
        return codes.contains(code);
    }

    public List<String> getMessages() {
        return messages;
    }
}

public class CommandFactory {

    public CommandFactory() {
    }

    Command getCommand(String commandName) {

        return switch (commandName) {
            case "quit", "exit", "qq" -> new QuitCommand();
            case "help" -> new HelpCommand();
            case "pwd" -> new PwdCommand();
            case "cd" -> new ChangeDirCommand();
            case "cf" -> new CreateFileCommand();
            case "rf" -> new RemoveFileCommand();
            case "append" -> new AppendToFileCommand();
            case "ls" -> new ListFilesCommand();
            default -> null;
        };
    }
}

abstract class Command {
    abstract CommandReturnInfo exec(String args);
}

class QuitCommand extends Command {

    CommandReturnInfo exec(String args) {
        //  actually do nothing, only return 'EXIT' error code:
        return new CommandReturnInfo(EXIT);
    }
}

class PwdCommand extends Command {

    CommandReturnInfo exec(String args) {
        return new CommandReturnInfo(System.getProperty("user.dir"), OUTPUT);
    }
}

class ChangeDirCommand extends Command {

    CommandReturnInfo exec(String args) {
        try {
            System.setProperty(("user.dir"), args);
            //  example of command with no output:
            return new CommandReturnInfo();
        } catch (Exception e) {
            return new CommandReturnInfo(e.getMessage(), ERROR, OUTPUT);
        }
    }
}

class CreateFileCommand extends Command {

    CommandReturnInfo exec(String args) {
        try {
            //  check argument (filename) for our command and return with error if it doesn't exist:
            if (args == null || args.length() == 0) {
                return new CommandReturnInfo("you must specify filename to create", ERROR, OUTPUT);
            }
            Files.createFile(Paths.get(args));
            return new CommandReturnInfo();
        } catch (Exception e) {
            return new CommandReturnInfo(e.getMessage(), ERROR, OUTPUT);
        }
    }
}

class RemoveFileCommand extends Command {

    CommandReturnInfo exec(String args) {
        try {
            if (!Files.isReadable(Paths.get(args))) {
                return new CommandReturnInfo("file must exist on system", ERROR, OUTPUT);
            }
            Files.delete(Paths.get(args));
            return new CommandReturnInfo();
        } catch (Exception e) {
            return new CommandReturnInfo(e.getMessage(), ERROR, OUTPUT);
        }
    }
}

class ListFilesCommand extends Command {

    CommandReturnInfo exec(String args) {
        try {

            final String dir = args == null ? System.getProperty("user.dir") : args;
            //  check if directory exists:
            if (!Files.isReadable(Paths.get(dir))) {
                return new CommandReturnInfo("directory must exist on system", ERROR, OUTPUT);
            }
            List<String> messages =
                    Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
                            .map(File::getName)
                            .collect(Collectors.toList());
            return new CommandReturnInfo(messages, OUTPUT);
        } catch (Exception e) {
            return new CommandReturnInfo(e.getMessage(), ERROR, OUTPUT);
        }
    }
}

class AppendToFileCommand extends Command {

    CommandReturnInfo exec(String arg) {
        try {
            if (arg == null) {
                return new CommandReturnInfo("not enough arguments, usage: 'append \"some_text_info\" filename'", ERROR, OUTPUT);
            }

            //  extract option and argument for command:
            Pattern p = Pattern.compile("(.+?) +(.*)");
            Matcher matcher = p.matcher(arg);
            if (!matcher.find())
                throw new IllegalStateException();

            //  1. check if file exists and writable:
            final Path path = Paths.get(matcher.group(2));
            if (!Files.isReadable(path) || !Files.isWritable(path)) {
                return new CommandReturnInfo("file must exist on system and must be writable", ERROR, OUTPUT);

            }
            Files.write(path, matcher.group(1).getBytes(), StandardOpenOption.APPEND);

            return new CommandReturnInfo();
        } catch (Exception e) {
            return new CommandReturnInfo(e.getMessage(), ERROR, OUTPUT);
        }
    }
}

class HelpCommand extends Command {

    CommandReturnInfo exec(String args) {
        List<String> helpMessages = new ArrayList<>(Arrays.asList(
                "A tiny command line interpreter v.1.0, written in Java. use it at your own risk.",
                "посмотреть текущую директорию:          pwd",
                "сменить текущую директорию:             cd newdir",
                "создать файл,                           cf file.txt",
                "удалить файл,                           rf file.txt",
                "дозаписать какой-то текст в файл:       ap \"some_text_info\" file",
                "посмотреть файлы в текущей директории:  ls",
                "или в указанной директории:             ls dir",
                "выход:                                  quit or exit or qq",
                "помощь (выводит данное собщение):       help"
        ));
        return new CommandReturnInfo(helpMessages, OUTPUT);
    }
}

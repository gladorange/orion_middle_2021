package ru.task10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ru.task10.CommandExecCode.*;

enum CommandExecCode {
    ERROR, EXIT, OUTPUT //  возможные коды (инфо) которые возвращает наша выполненная команда
}

class CommandReturnInfo {
    final Set<CommandExecCode> codes;
    List<String> messages;

    CommandReturnInfo(Set<CommandExecCode> codes, List<String> messageList) {
        this.codes = codes;
        this.messages = messageList;
    }

    CommandReturnInfo(Set<CommandExecCode> codes, String message) {
        this.codes = codes;
        this.messages = new ArrayList<>(List.of(message));
    }

    boolean containsCode(CommandExecCode code) {
        if (codes == null)
            return false;
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
    abstract CommandReturnInfo exec(String option, String argument);
}

class QuitCommand extends Command {

    CommandReturnInfo exec(String option, String argument) {
        //  actually do nothing, set and return 'EXIT' error code:
        return new CommandReturnInfo(new HashSet<>(Collections.singletonList(EXIT)), "");
    }
}

class PwdCommand extends Command {

    CommandReturnInfo exec(String option, String argument) {
        return new CommandReturnInfo(new HashSet<>(Collections.singletonList(OUTPUT)), System.getProperty("user.dir"));
    }
}

class ChangeDirCommand extends Command {

    CommandReturnInfo exec(String option, String argument) {
        try {
            System.setProperty(("user.dir"), option);
            //  example of command with no output:
            return new CommandReturnInfo(null, "");
        } catch (Exception e) {
            return new CommandReturnInfo(new HashSet<>(Arrays.asList(ERROR, OUTPUT)), e.getMessage());
        }
    }
}

class CreateFileCommand extends Command {

    CommandReturnInfo exec(String option, String argument) {
        try {
            //  check argument (filename) for our command and return with error if it doesn't exist:
            if (option == null || option.length() == 0) {
                return new CommandReturnInfo(new HashSet<>(Arrays.asList(ERROR, OUTPUT)),
                        "you must specify filename to create");
            }
            Files.createFile(Paths.get(option));
            return new CommandReturnInfo(new HashSet<>(), "");
        } catch (Exception e) {
            return new CommandReturnInfo(new HashSet<>(Arrays.asList(ERROR, OUTPUT)), e.getMessage());
        }
    }
}

class RemoveFileCommand extends Command {

    CommandReturnInfo exec(String option, String argument) {
        try {
            if (!Files.isReadable(Paths.get(option))) {
                return new CommandReturnInfo(new HashSet<>(Arrays.asList(ERROR, OUTPUT)),
                        "file must exist on system");
            }
            Files.delete(Paths.get(option));
            return new CommandReturnInfo(new HashSet<>(), "");
        } catch (Exception e) {
            return new CommandReturnInfo(new HashSet<>(Arrays.asList(ERROR, OUTPUT)), e.getMessage());
        }
    }
}

class ListFilesCommand extends Command {

    CommandReturnInfo exec(String option, String argument) {
        try {
            final String dir;
            if (option == null) {
                dir = System.getProperty("user.dir");
            } else {
                dir = option;
            }
            //  check if directory exists:
            if (!Files.isReadable(Paths.get(dir))) {
                return new CommandReturnInfo(new HashSet<>(Arrays.asList(ERROR, OUTPUT)),
                        "directory must exist on system");
            }
            List<String> messages =
                    Stream.of(Objects.requireNonNull(new File(dir).listFiles()))
                            .map(File::getName)
                            .collect(Collectors.toList());
            return new CommandReturnInfo(new HashSet<>(Collections.singletonList(OUTPUT)), messages);
        } catch (Exception e) {
            return new CommandReturnInfo(new HashSet<>(Arrays.asList(ERROR, OUTPUT)), e.getMessage());
        }
    }
}

class AppendToFileCommand extends Command {

    CommandReturnInfo exec(String option, String argument) {
        try {
            if (option == null || argument == null) {
                return new CommandReturnInfo(new HashSet<>(Arrays.asList(ERROR, OUTPUT)),
                        "not enough arguments, usage: 'append \"some_text_info\" filename'");
            }
            //  1. check if file exists and writable:
            final Path path = Paths.get(argument);
            if (!Files.isReadable(path) || !Files.isWritable(path)) {
                return new CommandReturnInfo(new HashSet<>(Arrays.asList(ERROR, OUTPUT)),
                        "file must exist on system and must be writable");
            }

            //  2. append to existing file:
            BufferedWriter writer = new BufferedWriter(new FileWriter(argument, true));
            writer.append(option);
            writer.close();

            return new CommandReturnInfo(new HashSet<>(), "");
        } catch (Exception e) {
            return new CommandReturnInfo(new HashSet<>(Arrays.asList(ERROR, OUTPUT)), e.getMessage());
        }
    }
}

class HelpCommand extends Command {

    CommandReturnInfo exec(String option, String argument) {
        List<String> helpMessages = new ArrayList<>(Arrays.asList(
                "A tiny command line interpreter v.0.9, written in Java. use it at your own risk.",
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
        return new CommandReturnInfo(new HashSet<>(Collections.singletonList(OUTPUT)), helpMessages);
    }
}

package animals.cli.commands;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Commands {
    public static class CommandNotFoundException extends RuntimeException{}

    private static Map<Pattern, Class<? extends Command>> commandPatterns;

    static {
        commandPatterns = new HashMap<>();
        commandPatterns.put(Pattern.compile("show cats"), ShowCatsCommand.class);
        commandPatterns.put(Pattern.compile("show cat (\\w+)"), ShowCatByNameCommand.class);
        commandPatterns.put(Pattern.compile("show dogs"), ShowDogsCommand.class);
        commandPatterns.put(Pattern.compile("show dog (\\w+)"), ShowDogByNameCommand.class);
        commandPatterns.put(Pattern.compile("show loudest dog"), ShowLoudestDogsCommand.class);
        commandPatterns.put(Pattern.compile("show quietest cat"), ShowQuietestCatsCommand.class);
    }

    @SneakyThrows
    public static Command parse(String line) throws CommandNotFoundException {
        if (line.startsWith("exit")) {
            return new ExitCommand();
        }
        Optional<Map.Entry<Pattern, Class<? extends Command>>> match = commandPatterns.entrySet().stream()
                .filter(entry -> entry.getKey().asMatchPredicate().test(line))
                .findFirst();
        if (match.isPresent()) {
            Constructor<? extends Command> constructor;
            Class<? extends Command> commandClass = match.get().getValue();
            try {
                constructor = commandClass.getConstructor();
                return constructor.newInstance();
            } catch (NoSuchMethodException e) {
                constructor = commandClass.getConstructor(List.class);
                Pattern pattern = match.get().getKey();
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String group = matcher.group(1);
                    return constructor.newInstance(List.of(group));
                }
            }
        }
        throw new CommandNotFoundException();
    }
}

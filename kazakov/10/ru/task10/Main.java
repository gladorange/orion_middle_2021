
package ru.task10;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.task10.CommandExecCode.*;

public class Main {

    public static void main(String[] args) {

        /*
        Задание 10. Файловый менеджер.
        Создать консольный файловый менеджер, который поддерживает ввод комманд от пользователя (например,
*        посмотреть текущую директорию,          pwd
*        сменить текущую директорию,             cd newdir
*        создать файл,                           cf file.txt
*        удалить файл,                           rf file.txt
******        дозаписать какой-то текст в файл,       append "some_text_info" file.txt
*        посмотреть файлы в текущей директории   ls
*        или в указанной директории              ls dir
*        помощь:                                 help

        Задание достаточно простое, обратите внимание на архитектуры различных комманд в консоли.
        Сможете ли вы сделать их легко расширяемыми?
         */
        Scanner keyboard = new Scanner(System.in);
        final CommandFactory commandFactory = new CommandFactory();
        while (true) {
            //  show system prompt:
            System.out.print(">");

            try {
                //  get new command from user input:
                final String input = keyboard.nextLine();
                if (input.length() == 0) {
                    continue;   //  empty input (⏎ Enter pressed), just show one more system prompt
                }

                Pattern p = Pattern.compile("(.+?) +(.*)|(.+)");    //  regex ужасно кривой но хоть как то работает ^) потом сделаю лучше
                Matcher matcher = p.matcher(input);
                if (!matcher.find())
                    throw new IllegalStateException();

                //  get command name:
                String commandName = null;
                final String grpOne = matcher.group(1);
                final String grpThree = matcher.group(3);
                if (grpOne != null) {
                    commandName = grpOne;
                } else if (grpThree != null) {
                    commandName = grpThree;
                }
                Command command = commandFactory.getCommand(commandName);
                if (command == null) {
                    System.out.printf("'%s' not found. Type 'help' for help\n", commandName);
                    continue;
                }

                //  extract options & arguments for command as a single value. Let handle the extracted string by the commands:
                CommandReturnInfo returnCode = command.exec(matcher.group(2));

                //  process command return code and output:
                if (returnCode.containsCode(ERROR)) {
                    System.out.printf("An error occurred while executing command '%s': ", commandName);
                }
                if (returnCode.containsCode(OUTPUT)) {
                    returnCode.getMessages().forEach(System.out::println);
                }
                if (returnCode.containsCode(EXIT))
                    return;

            } catch (Exception e) {
                System.out.printf("Произошло исключение! сообщение: %s\n", e.getMessage());
                e.printStackTrace();
                return;
            }
        }
    }
}

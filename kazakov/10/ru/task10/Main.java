
package ru.task10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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

            //  get new command from user input:
            //  в более продвинутой версии мы д.использовать парсинг аргументов и опций введённой команды с помощью regex:
            ArrayList<String> cmndInput = new ArrayList<>(Arrays.asList(keyboard.nextLine().split(" ")));
            final String commandName = cmndInput.get(0);
            if (commandName.length() == 0) {
                continue;   //  empty input (⏎ Enter pressed), just show one more system prompt
            }
            Command command = commandFactory.getCommand(commandName);
            if (command == null) {
                System.out.printf("'%s' not found. Type 'help' for help\n", commandName);
                continue;
            }

            //  === extract at maximum 1 option and 1 argument (a very simplest and limited case): ===
            final String option = cmndInput.size() > 1 ? cmndInput.get(1) : null;
            final String argument = cmndInput.size() > 2 ? cmndInput.get(2) : null;
            //  exec user command:
            CommandReturnInfo returnCode = command.exec(option, argument);

            //  process command return code and output:
            if (returnCode.containsCode(ERROR)) {
                System.out.printf("An error occurred while executing command '%s': ", commandName);
            }
            if (returnCode.containsCode(OUTPUT)) {
                returnCode.getMessages().forEach(System.out::println);
            }
            if (returnCode.containsCode(EXIT))
                return;

        }
    }
}

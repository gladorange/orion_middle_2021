package lection10.task1.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Command {
    protected String name;

    public String getName() {
        return name;
    }

    public Boolean isInString(String s){
        return getCommandMatcher(s).find();
    }

    protected Matcher getCommandMatcher(String s){
        Pattern regex = Pattern.compile("^"+name+ "(( .*)|($))");
        return regex.matcher(s);
    }

    protected String retrieveNextArg(String s){
        Pattern regex = Pattern.compile("^\\S+");
        Matcher m = regex.matcher(s);
        String result = "";
        if(m.find()) {
            result = m.group();
        }
        return result;
    }

    protected String removeArg(String s, String arg){
        return s.replace(arg, "").trim();
    }

    protected String getArgumentsFromCmd(String s, String name){
        String ss = s.replace(name, "").trim();
        if( ss.isEmpty()){
            System.out.println("Не указаны аргументы для команды!");
            System.out.println(getHelp());
        }
        return ss;
    }

    public abstract String getHelp();
    public abstract void execute(String s);
}

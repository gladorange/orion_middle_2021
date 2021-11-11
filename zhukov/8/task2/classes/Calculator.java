package task2.classes;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.BiFunction;

public class Calculator {

    private ArrayList<CalculateFunction> functions = new ArrayList<CalculateFunction>() ;

    public Double calculate(String operationName, Double number1, Double number2){
        Optional<CalculateFunction> func = functions.stream()
                .filter(function -> function.getTitle().equals(operationName) )
                .findFirst() ;

        return func.get().function.apply(number1,number2);

    }

    public void add(String title , BiFunction<Double,Double,Double> function){
        functions.add( new CalculateFunction(title,function) );
    }

    class CalculateFunction {
        private BiFunction<Double,Double,Double> function ;
        private String title;

        public CalculateFunction(String title , BiFunction<Double,Double,Double> function){
            this.function = function;
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

}

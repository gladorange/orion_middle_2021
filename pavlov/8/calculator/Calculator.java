package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Calculator {
    private final Map<String, Operation> mapOperations= new HashMap<>();

    public Double calculate(String operationName, Double number1, Double number2) throws ArithmeticException {
        Operation operation = mapOperations.get(operationName);
        if(operation != null){
            return operation.doOperation(number1, number2);
        }
        throw new ArithmeticException("Операция "+operationName+" не определена!");
    }

    public void addOperation(String operationName, Operation operation){
        mapOperations.put(operationName, operation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(mapOperations, that.mapOperations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapOperations);
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "mapOperations=" + mapOperations +
                '}';
    }
}

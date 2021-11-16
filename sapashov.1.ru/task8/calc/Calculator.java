package task8.calc;

import java.util.Map;

public class Calculator  {
    private Map<String, Operation> operationName;

    public Calculator(Map<String, Operation> operationName) {
        this.operationName = operationName;
    }

    public Double calculate(String operationName, Double number1, Double number2){
       return this.getOperationName().get(operationName).doOperation(number1, number2);
    }

    public void addOperation(String operationName, Operation implementation){
        this.operationName.put(operationName, implementation);
    }

    public Map<String, Operation> getOperationName() {
        return operationName;
    }


}

package com.ternakkode.calculator_tdd;

import java.util.Arrays;

public class Calculator {

    double val = 0.0;
    String[] resetOperations = {"reset", "clear"};
    String[] calculationOptions = {"add", "subtract", "multiply", "divide"};

    public boolean validateOperation(String operation) {
        boolean isResetOperation = Arrays.asList(this.resetOperations).contains(operation);
        if (isResetOperation) {
            resetCalculator();
            return true;
        }

        boolean isCalculationOperation = Arrays.asList(this.calculationOptions).contains(operation);
        if (isCalculationOperation) {
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.format("%.1f", this.val);
    }

    public void addOperation(int input) {
        this.val += input;
    }

    public void minusOperation(int input) {
        this.val -= input;
    }

    public void subtractOperation(int input) {
        this.val /= input;
    }

    public void multiplyOperation(int input){
        this.val *= input;
    }

    public void resetCalculator() {
        this.val = 0.0;
    }
}

package com.ternakkode.calculator_tdd;

import java.util.Arrays;

public class Calculator {

    double val = 0.0;
    String[] resetOperations = {"reset", "clear"};
    String[] calculationOptions = {"add", "subtract", "multiply", "divide"};

    public String[] splitInputs(String input) {
        String[] inputs = input.split(" ");

        return inputs;
    }

    public boolean validateOperation(String input) {
        boolean isResetOperation = Arrays.asList(this.resetOperations).contains(input);
        if (isResetOperation) {
            resetCalculator();
            return true;
        }

        String[] inputs = splitInputs(input);
        String operation = inputs[0];
        boolean isCalculationOperation = Arrays.asList(this.calculationOptions).contains(operation);
        if (isCalculationOperation & inputs.length > 1) {
            int value = Integer.parseInt(inputs[1]);
            doMathOperation(operation, value);
            return true;
        }

        return false;
    }

    public void doMathOperation(String operation, int value) {
        switch (operation){
            case "add":
                addOperation(value);
                break;
            case "minus":
                minusOperation(value);
                break;
            case "subtract":
                if (value == 0) {
                    resetCalculator();
                    break;
                }
                subtractOperation(value);
                break;
            case "multiply":
                multiplyOperation(value);
                break;
            default:
                break;
        }
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

    public void multiplyOperation(int input) {
        this.val *= input;
    }

    public void resetCalculator() {
        this.val = 0.0;
    }
}

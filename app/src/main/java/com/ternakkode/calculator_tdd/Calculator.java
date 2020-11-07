package com.ternakkode.calculator_tdd;

import java.util.Arrays;

public class Calculator {

    double val = 0.0;
    String[] resetOperations = {"reset", "clear"};

    public boolean validateOperation(String operation) {
        boolean isResetOperation = Arrays.asList(this.resetOperations).contains(operation);
        if (isResetOperation) resetCalculator();

        return true;
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

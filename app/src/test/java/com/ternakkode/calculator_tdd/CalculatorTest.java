package com.ternakkode.calculator_tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

public class CalculatorTest {

    @Test
    public void testGiven_CalculatorApp_When_Output_Then_PrintValue() {
        Calculator calculatorClass = new Calculator();
        assertNotNull(calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_CancelOrExit_Then_ResetValue() {
        Calculator calculatorClass = new Calculator();
        calculatorClass.resetCalculator();
        assertEquals("0.0",calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_AddByTwo_Then_ValueTwoHigherThanBefore() {
        Calculator calculatorClass = new Calculator();
        double initialValue = calculatorClass.val;
        calculatorClass.addOperation(2);
        assertEquals(String.format("%.1f", initialValue+2),calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_MinusByTwo_Then_ValueTwoLowerThanBefore() {
        Calculator calculatorClass = new Calculator();
        double initialValue = calculatorClass.val;
        calculatorClass.minusOperation(2);
        assertEquals(String.format("%.1f", initialValue-2),calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_SubtractByTwo_Then_ValueIsHalfThanBefore() {
        Calculator calculatorClass = new Calculator();
        double initialValue = calculatorClass.val;
        calculatorClass.subtractOperation(2);
        assertEquals(String.format("%.1f", initialValue/2),calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_MultiplyByTwo_Then_ValueIsTwiceThanBefore() {
        Calculator calculatorClass = new Calculator();
        double initialValue = calculatorClass.val;
        calculatorClass.multiplyOperation(2);
        assertEquals(String.format("%.1f", initialValue*2),calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_SelectedOperationIsForResetValue_Then_ReturnTrue() {
        Calculator calculatorClass = new Calculator();
        assertTrue(calculatorClass.validateOperation("reset"));
    }

    @Test
    public void testGiven_CalculatorApp_When_SelectedOperationIsForCalculation_Then_ReturnTrue() {
        Calculator calculatorClass = new Calculator();
        assertTrue(calculatorClass.validateOperation("add 2"));
    }

    @Test
    public void testGiven_CalculatorApp_When_SelectMathOperation_Then_ChangeCalculatorValue() {
        Calculator calculatorClass = new Calculator();
        double initialValue = calculatorClass.val;
        String operation = "add";
        calculatorClass.doMathOperation(operation, 3);
        assertNotEquals(String.format("%.1f", initialValue), calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_CallSplitInputFunction_Then_SplittingInputToArray() {
        Calculator calculatorClass = new Calculator();
        String[] splittedInput = calculatorClass.splitInputs("add 2");
        assertEquals(2, splittedInput.length);
    }

    @Test
    public void testGiven_CalculatorApp_When_DependencyInjectionOnCalculator_Then_CanCallCalculatorObject() {
        Main mainClass = new Main(new Calculator());
        assertEquals("0.0", mainClass.calculatorService.toString());
    }
}

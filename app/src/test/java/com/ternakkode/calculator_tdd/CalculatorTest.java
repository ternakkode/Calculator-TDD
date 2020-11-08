package com.ternakkode.calculator_tdd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

public class CalculatorTest {
    Calculator calculatorClass;
    Main mainClass;

    @Before
    public void init() {
        this.calculatorClass = new Calculator();
        this.mainClass = new Main(new Calculator());
    }

    @Test
    public void testGiven_CalculatorApp_When_Output_Then_PrintValue() {
        assertNotNull(this.calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_CancelOrExit_Then_ResetValue() {
        this.calculatorClass.resetCalculator();
        assertEquals("0.0",this.calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_AddByTwo_Then_ValueTwoHigherThanBefore() {
        double initialValue = this.calculatorClass.val;
        this.calculatorClass.addOperation(2);
        assertEquals(String.format("%.1f", initialValue+2),this.calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_MinusByTwo_Then_ValueTwoLowerThanBefore() {
        double initialValue = this.calculatorClass.val;
        this.calculatorClass.minusOperation(2);
        assertEquals(String.format("%.1f", initialValue-2),this.calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_SubtractByTwo_Then_ValueIsHalfThanBefore() {
        double initialValue = this.calculatorClass.val;
        this.calculatorClass.subtractOperation(2);
        assertEquals(String.format("%.1f", initialValue/2),this.calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_MultiplyByTwo_Then_ValueIsTwiceThanBefore() {
        double initialValue = this.calculatorClass.val;
        this.calculatorClass.multiplyOperation(2);
        assertEquals(String.format("%.1f", initialValue*2),this.calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_SelectedOperationIsForResetValue_Then_ReturnTrue() {
        assertTrue(this.calculatorClass.validateOperation("reset"));
    }

    @Test
    public void testGiven_CalculatorApp_When_SelectedOperationIsForCalculation_Then_ReturnTrue() {
        assertTrue(this.calculatorClass.validateOperation("add 2"));
    }

    @Test
    public void testGiven_CalculatorApp_When_SelectMathOperation_Then_ChangeCalculatorValue() {
        double initialValue = this.calculatorClass.val;
        String operation = "add";
        this.calculatorClass.doMathOperation(operation, 3);
        assertNotEquals(String.format("%.1f", initialValue), this.calculatorClass.toString());
    }

    @Test
    public void testGiven_CalculatorApp_When_CallSplitInputFunction_Then_SplittingInputToArray() {
        String[] splittedInput = this.calculatorClass.splitInputs("add 2");
        assertEquals(2, splittedInput.length);
    }

    @Test
    public void testGiven_CalculatorApp_When_DependencyInjectionOnCalculator_Then_CanCallCalculatorObject() {
        assertEquals("0.0", this.mainClass.calculatorService.toString());
    }
}

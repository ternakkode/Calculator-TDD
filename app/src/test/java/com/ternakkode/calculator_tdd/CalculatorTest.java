package com.ternakkode.calculator_tdd;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class CalculatorTest {

    @Test
    public void testGiven_CalculatorApp_When_Output_Then_PrintValue(){
        Calculator calculatorClass = new Calculator();
        assertNotNull(calculatorClass.toString());
    }
}

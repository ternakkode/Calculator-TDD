package com.ternakkode.calculator_tdd;

import java.util.Scanner;

public class Main {

    public final Calculator calculatorService;

    public Main(
            Calculator calculatorService
    ){
        this.calculatorService = calculatorService;
    }

    public static void main(String[] args) {
        Main main = new Main(new Calculator());
        Scanner scanner = new Scanner(System.in);

        String input;
        boolean isContinued = true;
        do {
            input = scanner.nextLine();
            if (!main.calculatorService.validateOperation(input) & input.equals("exit")) {
                isContinued = false;
            }
            if (isContinued) System.out.println(main.calculatorService.toString());
        } while (isContinued);
    }
}

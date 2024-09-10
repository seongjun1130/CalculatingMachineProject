package com.calculator.lv3;

public class MultCalculator<T extends Number> extends AbstractCalculator {
    @Override
    public double calculate(Number firstNumber, Number secondNumber) {
        return firstNumber.doubleValue() * secondNumber.doubleValue();
    }
}
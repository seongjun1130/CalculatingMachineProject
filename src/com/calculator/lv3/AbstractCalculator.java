package com.calculator.lv3;

public abstract class AbstractCalculator<T extends Number> {
    public abstract double calculate(T firstNumber, T secondNumber);
}

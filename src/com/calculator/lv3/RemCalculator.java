package com.calculator.lv3;

public class RemCalculator<T extends Number> extends AbstractCalculator {
    @Override
    public double calculate(Number firstNumber, Number secondNumber) {
        if (secondNumber.doubleValue() == 0 || secondNumber.doubleValue() == 0.0) {
            throw new ArithmeticException("0으로는 나눌 수 없습니다.");
        }
        return firstNumber.doubleValue() % secondNumber.doubleValue();
    }
}

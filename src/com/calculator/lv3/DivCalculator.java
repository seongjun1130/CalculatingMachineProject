package com.calculator.lv3;

public class DivCalculator<T extends Number> extends AbstractCalculator {
    @Override
    public double calculate(Number firstNumber, Number secondNumber) {
        // 분모가 0일경우 예외 발생 유도.
        if (secondNumber.doubleValue() == 0 || secondNumber.doubleValue() == 0.0) {
            throw new ArithmeticException("0으로는 나눌 수 없습니다.");
        }
        return firstNumber.doubleValue() / secondNumber.doubleValue();
    }
}

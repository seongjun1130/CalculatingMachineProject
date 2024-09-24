package com.calculator.lv3.operations;

// 추상클래스를 상속받아 오버라이딩 하여 기능 구현.
public class RemCalculator<T extends Number> extends AbstractCalculator {
    @Override
    public double calculate(Number firstNumber, Number secondNumber) {
        // 분모가 0일경우 예외 발생 유도.
        if (secondNumber.doubleValue() == 0 || secondNumber.doubleValue() == 0.0) {
            throw new ArithmeticException("0으로는 나눌 수 없습니다.");
        }
        return firstNumber.doubleValue() % secondNumber.doubleValue();
    }
    public String getOperator(){
        return "%";
    }
}

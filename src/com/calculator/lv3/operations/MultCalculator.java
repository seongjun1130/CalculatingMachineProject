package com.calculator.lv3.operations;

// 추상클래스를 상속받아 오버라이딩 하여 기능 구현.
public class MultCalculator<T extends Number> extends AbstractCalculator {
    @Override
    public double calculate(Number firstNumber, Number secondNumber) {
        return firstNumber.doubleValue() * secondNumber.doubleValue();
    }
    public String getOperator(){
        return "*";
    }
}
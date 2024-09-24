package com.calculator.lv3.operations;

// 계산기 기능 class들이 구현할 공유목적의 추상클래스 선언
public abstract class AbstractCalculator<T extends Number> {
    private String operator;

    public abstract double calculate(T firstNumber, T secondNumber);

    public abstract String getOperator();
}

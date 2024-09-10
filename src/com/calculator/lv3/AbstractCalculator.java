package com.calculator.lv3;

// 계산기 기능 class들이 구현할 공유목적의 추상클래스 선언
public abstract class AbstractCalculator<T extends Number> {
    public abstract double calculate(T firstNumber, T secondNumber);
}

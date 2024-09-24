package com.calculator.lv3;

import com.calculator.lv3.operations.AbstractCalculator;

// 각각의 기능 Class 들을 관리할 CalculatorManager 매니저 Class 생성
public class CalculatorManager {
    // 각 기능들의 객체가 들어갈 필드
    private AbstractCalculator calculator = null;

    // 기본생성자
    CalculatorManager() {
    }
    // 생성하면서 기능을 넣고싶을때 사용할 생성자
    CalculatorManager(AbstractCalculator calculator) {
        this.calculator = calculator;
    }

    // 기능을 교체할때 사용하기위한 메소드
    public void setCalculate(AbstractCalculator calculator) {
        this.calculator = calculator;
    }

    // 각 기능별 계산 기능을 불러오기위한 객체호출
    public AbstractCalculator getCalculate() {
        return calculator;
    }
}
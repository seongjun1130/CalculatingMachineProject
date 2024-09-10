package com.calculator.lv3;

public class CalculatorManager {
    private AbstractCalculator calculator = null;

    CalculatorManager() {

    }

    CalculatorManager(AbstractCalculator calculator) {
        this.calculator = calculator;
    }

    public void setCalculate(AbstractCalculator calculator) {
        this.calculator = calculator;
    }

    public AbstractCalculator getCalculate() {
        return calculator;
    }
}
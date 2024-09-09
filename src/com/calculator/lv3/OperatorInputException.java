package com.calculator.lv3;

// 정규연산자 외 문자 입력시 커스텀예외.
public class OperatorInputException extends RuntimeException {
    public OperatorInputException() {
        super();
    }

    public OperatorInputException(String message) {
        super(message);
    }
}

package com.calculator.lv2;
// 정규연산자 외 문자 입력시 커스텀예외.
public class OperatorInputException extends RuntimeException {
    OperatorInputException() {
        super();
    }

    OperatorInputException(String message) {
        super(message);
    }
}

package com.calculator.lv2.customexception;

// 빈 리스트 작업 요청시 발생 커스텀예외
public class EmptyListException extends Exception {

    public EmptyListException() {
        super();
    }

    public EmptyListException(String message) {
        super(message);
    }
}

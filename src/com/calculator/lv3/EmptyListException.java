package com.calculator.lv3;

// 빈 리스트 작업 요청시 발생 커스텀예외
public class EmptyListException extends Exception {

    public EmptyListException() {
        super();
    }

    public EmptyListException(String message) {
        super(message);
    }
}

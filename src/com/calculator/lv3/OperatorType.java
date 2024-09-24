package com.calculator.lv3;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum OperatorType {
    ADD("+"),
    SUB("-"),
    MULT("*"),
    DIV("/"),
    REM("%");

    // 프로그램이 실행되면 Map을 캐싱해 찾고자 하는 키값과 필드값을 매칭 스트림과 람다식을 활용.
    private static final Map<String, OperatorType> OPERATOR_MAP =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(OperatorType::getOperator, Function.identity())));
    private final String operator;

    // 생성자를 통한 String 매칭
    OperatorType(String operator) {
        this.operator = operator;
    }

    // 입력된 연산자를 통해 Map 안에서 열거 객체 리턴
    public static OperatorType find(String operator) {
        if (OPERATOR_MAP.containsKey(operator)) {
            return OPERATOR_MAP.get(operator);
        }
        //연산자 외 문자 입력시 예외 발생 유도
        throw new IllegalArgumentException("맞지 않는 연산자 입력 : " + operator);
    }

    public String getOperator() {
        return operator;
    }
}


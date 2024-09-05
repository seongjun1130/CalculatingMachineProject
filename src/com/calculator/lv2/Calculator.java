package com.calculator.lv2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private double result = 0;
    // 연산과정 및 결과 확인 List 생성
    private ArrayList<Integer> firstNumbers = new ArrayList<>();
    private ArrayList<Integer> secondNumbers = new ArrayList<>();
    private ArrayList<Double> results = new ArrayList<>();
    private ArrayList<Character> operators = new ArrayList<>();

    // 사칙연산 계산 부분 메소드 매개변수로 요소를 받아 계산 후 리턴.
    // throws 키워드를 통해 직접 예외를 처리하지않고 발생지에 처리요청
    public double calculate(int firstNum, int secondNum, char operator) throws InputMismatchException, ArithmeticException {
        switch (operator) {
            case '+':
                result = firstNum + secondNum;
                // 연산 과정 및 결과 저장 메서드 호출.
                saveOperationProcess(firstNum, secondNum, result, operator);
                break;
            case '-':
                result = firstNum - secondNum;
                saveOperationProcess(firstNum, secondNum, result, operator);
                break;
            case '*':
                result = firstNum * secondNum;
                saveOperationProcess(firstNum, secondNum, result, operator);
                break;
            case '/':
                // 분모가 0일경우 예외 발생 유도.
                if (secondNum == 0) {
                    throw new ArithmeticException();
                }
                result = firstNum / secondNum;
                saveOperationProcess(firstNum, secondNum, result, operator);
                break;
            case '%':
                result = firstNum % secondNum;
                saveOperationProcess(firstNum, secondNum, result, operator);
                break;
        }
        return result;
    }

    // 연산 과정 및 결과 저장 메소드.
    private void saveOperationProcess(int firstNumber, int secondNumber, double result, char operator) {
        firstNumbers.add(firstNumber);
        secondNumbers.add(secondNumber);
        results.add(result);
        operators.add(operator);
    }
}

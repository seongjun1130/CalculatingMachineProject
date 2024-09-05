package com.calculator.lv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // 숫자 1,2 를 입력받기 위한 스캐너 객체 생성.
        Scanner sc = new Scanner(System.in);
        // 연산 용 값 저장 변수
        int firstNum = 0;
        int secondNum = 0;
        double result = 0;
        // 숫자가 아닌 문자를 입력시 예외 발생 후 프로그램 종료
        try {
            // 스캐너를 통한 숫자 1,2 입력 후 변수저장.
            System.out.print("첫 번째 숫자를 입력하세요 : ");
            firstNum = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요 : ");
            secondNum = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요.");
            System.exit(0);
        }
        // 스캐너를 통한 사칙연산 기호 삽입.
        System.out.print("사칙연산 기호를 입력하세요 : ");
        char operator = sc.next().charAt(0);
        // 0으로 나누기를 실행할경우 예외 발생
        try {
            // 연산자의 따른 연산 진행 제어문
            switch (operator) {
                case '+':
                    result = firstNum + secondNum;
                    System.out.println(firstNum + " " + operator + " " + secondNum + " = " + result);
                    break;
                case '-':
                    result = firstNum - secondNum;
                    System.out.println(firstNum + " " + operator + " " + secondNum + " = " + result);
                    break;
                case '*':
                    result = firstNum * secondNum;
                    System.out.println(firstNum + " " + operator + " " + secondNum + " = " + result);
                    break;
                case '/':
                    result = firstNum / secondNum;
                    System.out.println(firstNum + " " + operator + " " + secondNum + " = " + result);
                    break;
                case '%':
                    result = firstNum % secondNum;
                    System.out.println(firstNum + " " + operator + " " + secondNum + " = " + result);
                    break;
                default:
                    System.out.println("존재하지 않는 연산자 입니다.");
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println("0으로는 나눌 수 없습니다.");
        }

    }
}

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
        boolean flag = true;
        boolean onOfflag;
        // 계산기 무한반복 진행.
        while (flag) {
            try {
                onOfflag = true;
                // 스캐너를 통한 숫자 1,2 입력 후 변수저장.
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                firstNum = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요 : ");
                secondNum = sc.nextInt();
                // 스캐너를 통한 사칙연산 기호 삽입.
                System.out.print("사칙연산 기호를 입력하세요 : ");
                char operator = sc.next().charAt(0);
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
                // yes 와 exit 외의 문자가 입력될 경우 다시 반복.
                while (onOfflag) {
                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)(yes 입력 시 계속)");
                    String onOff = sc.next();
                    // exit 가 입력될경우 프로그램 종료
                    if (onOff.equals("exit")) {
                        flag = !flag;
                        onOfflag = !onOfflag;
                        // yes 입력시 계산 재진행.
                    } else if (onOff.equals("yes")) {
                        System.out.println("계산을 다시 진행합니다.");
                        onOfflag = !onOfflag;
                    } else {
                        System.out.println("yes 혹은 exit 로 만 입력해주세요.");
                    }
                }
                // 0 으로 나누기 연산시 예외발생 처리
            } catch (ArithmeticException e) {
                System.out.println("0으로는 나눌 수 없습니다.");
                // 숫자 실수 및 문자 입력시 예외발생 처리
            } catch (InputMismatchException e) {
                System.out.println("숫자 혹은 정수를 입력해주세요.");
                sc.nextLine();
            }
        }
    }
}
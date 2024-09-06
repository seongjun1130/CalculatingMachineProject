package com.calculator.lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

// 서비스 흐름제어를 위한 매니저 클래스생성
public class ServiceManager {
    // 제어용 멤버변수 생성
    private int firstNum = 0;
    private int secondNum = 0;
    private boolean flag = true;
    private boolean onOfflag;
    private Calculator calc = new Calculator();
    private Scanner sc = new Scanner(System.in);

    // 서비스 시작 메소드
    public void run() {
        // 계산 로직 무한 반복.
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
                // Calculator 객체를 통한 calculate() 메소드를 통해 계산.
                System.out.println(firstNum + " " + operator + " " + secondNum + " = " + calc.calculate(firstNum, secondNum, operator));
                // 프로그램을 계속 실행할것인지 종료할건지 반복.
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
                        // 그외 문자 입력시 반복
                    } else {
                        System.out.println("yes 혹은 exit 로 만 입력해주세요.");
                    }
                }
                // 0으로 나눗셈 시도시 예외발생 처리
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                // 숫자 실수 및 문자 입력시 예외발생 처리
            } catch (InputMismatchException e) {
                System.out.println("숫자 혹은 정수를 입력해주세요.");
                sc.nextLine();
                // 정해진 연산자외의 연산자 입력시 예외발생 처리
            } catch (OperatorInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
package com.calculator.lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // 숫자 1,2 를 입력받기 위한 스캐너 객체 생성.
        Scanner sc = new Scanner(System.in);
        // 스캐너를 통한 숫자 1,2 입력 후 변수저장.
        System.out.print("첫 번째 숫자를 입력하세요 : ");
        int firstNum = sc.nextInt();
        System.out.print("두 번째 숫자를 입력하세요 : ");
        int secondNum = sc.nextInt();
        // 스캐너를 통한 사칙연산 기호 삽입.
        System.out.print("사칙연산 기호를 입력하세요 : ");
        char operator = sc.next().charAt(0);
        System.out.println(firstNum + " " + operator + " " + secondNum);
    }
}

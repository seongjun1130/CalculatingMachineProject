package com.calculator.lv1;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자를 입력하세요.");
        int firstNum = sc.nextInt();
        System.out.println("두 번째 숫자를 입력하세요.");
        int secondNum = sc.nextInt();
        System.out.println("첫 번째 = "+firstNum+"두 번째 = "+secondNum);
    }
}

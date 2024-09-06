package com.calculator.lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

// 서비스 흐름제어를 위한 매니저 클래스생성
public class ServiceManager {
    // 제어용 멤버변수 생성
    private int firstNum = 0;
    private int secondNum = 0;
    private String selIndex = "0";
    private String menu;
    private boolean flag = true;
    private boolean menuFlag;
    private boolean inMenuFlag = false;
    private Calculator calc = new Calculator();
    private Scanner sc = new Scanner(System.in);

    // 서비스 시작 메소드
    public void run() {
        // 로직 무한 반복.
        while (true) {
            try {
                menuFlag = true;
                /* 프로그램을 계속 실행할것인지 종료할건지 반복.
                exit 가 입력될경우 프로그램 종료
                yes 입력시 계산 진행
                hist 입력시 기록 확인
                그외 문자 입력시 반복 */
                while (menuFlag) {
                    System.out.println("================================================================================");
                    System.out.println("계산하시겠습니까? / exit 입력 시 종료 / yes 입력 시 계속 / hist 입력 시 저장된 결과 확인");
                    System.out.print("메뉴 입력 : ");
                    menu = sc.nextLine();
                    System.out.println("================================================================================");
                    switch (menu) {
                        case "exit":
                            System.exit(0);
                            break;
                        case "yes":
                            System.out.println("계산을 진행합니다.");
                            menuFlag = !menuFlag;
                            break;
                        case "hist":
                            inMenuFlag = !inMenuFlag;
                            while (inMenuFlag) {
                                System.out.println("=========================================================================");
                                System.out.println("메뉴를 0 ~ 9 사이로만 입력해주세요.");
                                System.out.println("1. 가장 최근 연산 확인. 2. 모든 연산 결과확인. 3. 지정 연산결과 확인.");
                                System.out.println("4. 가장 최근 연산 과정 확인. 5. 모든 연산 과정확인. 6. 지정 연산과정 확인.");
                                System.out.println("7. 가장 최근 연산 기록 삭제. 8. 모든 연산 삭제. 9. 지정 연산기록 삭제");
                                System.out.println("0. 메뉴 빠져나오기");
                                System.out.println("=========================================================================");
                                System.out.print("메뉴 입력 :");
                                selIndex = sc.nextLine();
                                System.out.println("=========================================================================");
                                // 숫자를 입력받아 정규식으로 검증 후 메뉴 실행.
                                if (!selIndex.matches("[0-9]+")) {
                                    System.out.println("0 ~ 9 사이에서만 입력이 가능합니다.");
                                } else {
                                    switch (selIndex) {
                                        case "0":
                                            inMenuFlag = !inMenuFlag;
                                            break;
                                        case "1":
                                            System.out.println("가장 최근 결과는 = " + calc.getRecentResult());
                                            break;
                                        case "2":
                                            calc.getAllResult();
                                            break;
                                        case "3":
                                            System.out.println("알고싶은 순번의 번호를 입력해주세요.");
                                            selIndex = sc.nextLine();
                                            System.out.println("지정 순번의 결과는 = " + calc.getResult(Integer.parseInt(selIndex)) + " 입니다.");
                                            break;
                                        case "4":
                                            System.out.println("가장 최근 연산 과정은 = " + calc.getRecentCulationProcess());
                                            break;
                                        case "5":
                                            calc.getAllcalCulationProcess();
                                            break;
                                        case "6":
                                            System.out.println("알고싶은 순번의 번호를 입력해주세요.");
                                            selIndex = sc.nextLine();
                                            System.out.println("지정 순번의 결과는 : " + calc.getcalCulationProcess(Integer.parseInt(selIndex)) + " 입니다.");
                                            break;
                                        case "7":
                                            calc.removeRecentResults();
                                            break;
                                        case "8":
                                            System.out.println("모든 저장결과를 삭제합니다.");
                                            calc.removeAll();
                                            break;
                                        case "9":
                                            System.out.println("삭제하고 싶은 순번의 번호를 입력해주세요.");
                                            selIndex = sc.nextLine();
                                            calc.removeResults(Integer.parseInt(selIndex));
                                            break;
                                    }
                                }
                            }
                        default:
                            System.out.println("yes, exit, hist 로 만 입력해주세요.");
                    }
                }
                // 스캐너를 통한 숫자 1,2 입력 후 변수저장.
                System.out.print("첫 번째 숫자를 입력하세요 : ");
                firstNum = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요 : ");
                secondNum = sc.nextInt();
                sc.nextLine();
                // 스캐너를 통한 사칙연산 기호 삽입.
                System.out.print("사칙연산 기호를 입력하세요 : ");
                String operator = sc.nextLine();
                // Calculator 객체를 통한 calculate() 메소드를 통해 계산.
                System.out.println(firstNum + " " + operator + " " + secondNum + " = " + calc.calculate(firstNum, secondNum, operator));
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
                // 비어있는 List 삭제요청시 예외발생 처리
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
                // index 값 예외발생 처리
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
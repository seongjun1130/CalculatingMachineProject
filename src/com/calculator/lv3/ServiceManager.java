package com.calculator.lv3;

import com.calculator.lv3.customexception.*;
import com.calculator.lv3.operations.*;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// 메뉴타입 enum 클래스 화
enum MainmenuType {
    EXIT("exit"),
    YES("yes"),
    HISTORY("hist");

    // 프로그램이 실행되면 Map을 캐싱해 찾고자 하는 키값과 필드값을 매칭 스트림과 람다식을 활용.
    private static final Map<String, MainmenuType> MAINMENU_TYPE_MAP_MAP =
            Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(MainmenuType::getMainmenu, Function.identity())));
    private final String mainmenu;

    // 생성자를 통한 String 매칭
    MainmenuType(String mainmenu) {
        this.mainmenu = mainmenu;
    }

    // 입력된 연산자를 통해 Map 안에서 열거 객체 리턴
    public static MainmenuType find(String mainmenu) {
        if (MAINMENU_TYPE_MAP_MAP.containsKey(mainmenu)) {
            return MAINMENU_TYPE_MAP_MAP.get(mainmenu);
        } else {
            // 지정메뉴외 문자 입력시 예외발생
            throw new NullPointerException("메뉴중에서 입력해주세요.");
        }
    }

    public String getMainmenu() {
        return mainmenu;
    }
}

// 서비스 흐름제어를 위한 매니저 클래스생성
public class ServiceManager {
    // 제어용 멤버변수 생성
    private int firstNumInt;
    private int secondNumInt;
    private double firstNumDouble;
    private double secondNumDouble;
    private double baseNum = 0.0;
    private String number = null;
    private String selIndex = "0";
    private String menu;
    private boolean inMenuFlag = false;
    private ArithmeticCalculator calc = new ArithmeticCalculator();
    private Scanner sc = new Scanner(System.in);
    private MainmenuType Mainmenu;

    // 서비스 시작 메소드
    public void run() {
        // 로직 무한 반복.
        while (true) {
            try {
                /* 프로그램을 계속 실행할것인지 종료할건지 반복.
                exit 가 입력될경우 프로그램 종료
                yes 입력시 계산 진행
                hist 입력시 기록 확인
                그외 문자 입력시 반복 */
                displayMenu();
                Mainmenu = MainmenuType.find(menu);
                switch (Mainmenu) {
                    case EXIT:
                        System.exit(0);
                        break;
                    case YES:
                        System.out.println("계산을 진행합니다.");
                        calculationControl();
                        break;
                    case HISTORY:
                        recordMenuControl();
                        break;
                }
            }
            // 0으로 나눗셈 시도시 예외발생 처리
            catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
            // 비어있는 List 삭제요청시 예외발생 처리
            catch (EmptyListException e) {
                System.out.println(e.getMessage());
            }
            // index 값 초과,0 미만시 예외발생 처리
            catch (IndexOutOfBoundsException e) {
                System.out.println("정확한 인덱스를 입력해주세요.");
            }
            // 숫자외 다른 문자열 입력시 예외발생 처리
            catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("숫자를 입력해주세요.");
            }
            // 연산자 외 문자 입력시 예외발생 처리
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            // 지정 메뉴 외 문자 입력시 예외발생 처리
            catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 계산부분 흐름 담당 메소드
    private void calculationControl() {
        // 해당 입력 숫자가 INT형 인지 DOUBLE형 인지 확인
        int fisrtdoublecnt = 0;
        int firstintcnt = 0;
        int seconddoublecnt = 0;
        int secondintcnt = 0;
        CalculatorManager cm = new CalculatorManager();
        // 스캐너를 통한 숫자 1,2 입력 후 변수저장.
        System.out.print("첫 번째 숫자를 입력하세요 : ");
        number = sc.nextLine();
        // 입력받은 숫자가 정수인지 실수인지 검사.
        if (number.contains(".")) {
            firstNumDouble = Double.parseDouble(number);
            fisrtdoublecnt++;
        } else {
            firstNumInt = Integer.parseInt(number);
            firstintcnt++;
        }
        System.out.print("두 번째 숫자를 입력하세요 : ");
        number = sc.nextLine();
        if (number.contains(".")) {
            secondNumDouble = Double.parseDouble(number);
            seconddoublecnt++;
        } else {
            secondNumInt = Integer.parseInt(number);
            secondintcnt++;
        }
        // 스캐너를 통한 사칙연산 기호 삽입.
        System.out.print("사칙연산 기호를 입력하세요 : ");
        String operator = sc.nextLine();
        // enum 열거객체를 받아와 연산확인
        /* CalculatorManager 가 가지는 구현객체를 통해 객체를 추상클래스타입 변수로 갈아끼워 호출명은 동일하지만
         * 계산연산이 바뀌도록 다형성 부여 */
        switch (OperatorType.find(operator)) {
            case ADD:
                cm.setCalculate(new AddCalculator());
                break;
            case SUB:
                cm.setCalculate(new SubCalculator());
                break;
            case MULT:
                cm.setCalculate(new MultCalculator());
                break;
            case DIV:
                cm.setCalculate(new DivCalculator());
                break;
            case REM:
                cm.setCalculate(new RemCalculator());
                break;
        }
        /* Calculator 객체를 통한 calculate() 메소드를 통해 계산.
        정수인지 실수인지에 대한 타입분간.
        입력값중 음수가 있는지 판단.*/
        if (fisrtdoublecnt != 0 && seconddoublecnt != 0) {
            if (calc.isNegativeNumber(firstNumDouble, secondNumDouble)) {
                System.out.println("양수만 입력해주세요.");
            }
            System.out.println(firstNumDouble + " " + operator + " " + secondNumDouble + " = " + calc.calculate(firstNumDouble, secondNumDouble, cm.getCalculate()));
        } else if (firstintcnt != 0 && secondintcnt != 0) {
            if (calc.isNegativeNumber(firstNumInt, secondNumInt)) {
                System.out.println("양수만 입력해주세요.");
            }
            System.out.println(firstNumInt + " " + operator + " " + secondNumInt + " = " + calc.calculate(firstNumInt, secondNumInt, cm.getCalculate()));
        } else if (firstintcnt != 0 && seconddoublecnt != 0) {
            if (calc.isNegativeNumber(firstNumInt, secondNumDouble)) {
                System.out.println("양수만 입력해주세요.");
            }
            System.out.println(firstNumInt + " " + operator + " " + secondNumDouble + " = " + calc.calculate(firstNumInt, secondNumDouble, cm.getCalculate()));
        } else {
            if (calc.isNegativeNumber(firstNumDouble, secondNumInt)) {
                System.out.println("양수만 입력해주세요.");
            }
            System.out.println(firstNumDouble + " " + operator + " " + secondNumInt + " = " + calc.calculate(firstNumDouble, secondNumInt, cm.getCalculate()));
        }
    }

    // 기록메뉴 흐름 관리 및 호출담당 메소드
    private void recordMenuControl() throws ArithmeticException, EmptyListException {
        inMenuFlag = !inMenuFlag;
        // 연산 과정, 결과를 확인,삭제 하는 메뉴 생성.
        while (inMenuFlag) {
            System.out.println("=========================================================================");
            System.out.println("메뉴를 보기에 맞게 입력해주세요.");
            System.out.println("1. 가장 최근 연산 결과 확인. 2. 모든 연산 결과확인. 3. 지정 연산결과 확인.");
            System.out.println("4. 가장 최근 연산 과정 확인. 5. 모든 연산 과정확인. 6. 지정 연산과정 확인.");
            System.out.println("7. 가장 최근 연산 기록 삭제. 8. 모든 연산 삭제. 9. 지정 연산기록 삭제");
            System.out.println("#. 입력값보다 큰 결과 값 보기 *. 결과들의 평균 보기 !. 결과 최댓값 보기");
            System.out.println("@. 결과 최솟값 보기. 0. 메뉴 빠져나오기");
            System.out.println("=========================================================================");
            System.out.print("메뉴 입력 :");
            selIndex = sc.nextLine();
            System.out.println("=========================================================================");
            // 문자를 입력받아 정규식으로 검증 후 메뉴 실행.
            if (!selIndex.matches("[0-9#*!@]+")) {
                System.out.println("보기에 있는 문자만 입력이 가능합니다.");
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
                    case "#":
                        System.out.println("입력값보다 큰 결과값을 가져옵니다.");
                        System.out.print("값을 입력해주세요 : ");
                        baseNum = sc.nextDouble();
                        calc.getInputLargerThanContent(baseNum);
                        sc.nextLine();
                        break;
                    case "*":
                        System.out.println("결과들의 평균값을 가져옵니다.");
                        System.out.println(Math.round(calc.getAvg() * 100) / 100.0);
                        break;
                    case "!":
                        System.out.println("결과의 최댓값은");
                        System.out.println(calc.getMax());
                        break;
                    case "@":
                        System.out.println("결과의 최솟값은");
                        System.out.println(calc.getMin());
                        break;
                }
            }
        }
    }

    // Menu 출력용 메소드
    private void displayMenu() {
        System.out.println("================================================================================");
        System.out.println("메뉴를 선택해주세요.");
        System.out.println("exit 입력 시 종료 / yes 입력 시 계산 / hist 입력 시 저장된 결과 확인");
        System.out.print("메뉴 입력 : ");
        menu = sc.nextLine();
        System.out.println("================================================================================");
    }
}
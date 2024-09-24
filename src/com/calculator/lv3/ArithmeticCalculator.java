package com.calculator.lv3;

import com.calculator.lv3.customexception.*;
import com.calculator.lv3.operations.*;

import java.util.*;

// Class 제네릭화 Number 하위클래스만 받을수있게 제약
public class ArithmeticCalculator<T extends Number> {
    private double result;
    // 연산과정 및 결과 저장 List 생성
    private ArrayList<T> firstNumbers = new ArrayList<>();
    private ArrayList<T> secondNumbers = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();
    private ArrayList<Double> results = new ArrayList<>();
    // 연산 과정 출력용 String 변수
    private String calculationProcess = "";
    // 연산자 열거객체 저장변수
    private OperatorType operatorType;
    // 계산식 다형성 부여를 위한 매니저 객체생성
    private CalculatorManager cm = new CalculatorManager();

    /* 사칙연산 계산 부분 메소드 매개변수로 요소를 받아 계산 후 리턴
     throws 키워드를 통해 직접 예외를 처리하지않고 발생지에서 처리요청*/
    // AbstractCalculator 객체를 받음으로써 calculate()는 오퍼레이터를 몰라도 연산이 가능
    public double calculate(T firstNum, T secondNum, AbstractCalculator cm) throws ArithmeticException {
        // 연산 과정 및 결과 저장 메서드 호출.
        result = cm.calculate(firstNum, secondNum);
        saveCalculationProcess(firstNum, secondNum, result, cm.getOperator());
        return result;
    }

    // 연산 과정 및 결과 저장 메소드.
    private void saveCalculationProcess(T firstNumber, T secondNumber, double result, String operator) {
        firstNumbers.add(firstNumber);
        secondNumbers.add(secondNumber);
        results.add(result);
        operators.add(operator);
    }

    // 빈 List 요청 확인 메소드
    private boolean isEmptyList() {
        return firstNumbers.isEmpty();
    }

    // 요청 index 가 size 를 넘지 않았는지 체크메소드
    private boolean isIndexOutOfBounds(int index) {
        return firstNumbers.size() < index;
    }

    //입력값 중 음수가 있는지 확인하는 메소드
    public boolean isNegativeNumber(T firstNum, T secondNum) {
        return firstNum.doubleValue() < 0 || secondNum.doubleValue() < 0;
    }

    // 지정된 연산 결과 출력
    public double getResult(int index) throws IndexOutOfBoundsException, EmptyListException {
        // List가 비어있을 경우 예외발생
        if (isEmptyList()) {
            throw new EmptyListException("저장된 연산결과가 없습니다.");
            // size를 초과하는 인덱스를 입력시 예외발생.
        } else if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        } else {
            return results.get(index - 1);
        }
    }


    // 저장된 모든 연산결과 출력
    public void getAllResult() throws EmptyListException {
        // List가 비어있을 경우 예외발생
        if (isEmptyList()) {
            throw new EmptyListException("저장된 연산결과가 없습니다.");
        } else {
            // 스트림을 이용한 출력.
//            results.stream().forEach(System.out::println);
            for (int i = 0; i < results.size(); i++) {
                System.out.println(i + 1 + ". 번째 결과 : " + results.get(i));
            }
        }
    }

    // 지정된 연산 과정 출력
    public String getcalCulationProcess(int index) throws IndexOutOfBoundsException, EmptyListException {
        // List가 비어있을 경우 예외발생
        if (isEmptyList()) {
            throw new EmptyListException("저장된 연산결과가 없습니다.");
            // size를 초과하는 인덱스를 입력시 예외발생.
        } else if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        } else {
            calculationProcess = firstNumbers.get(index - 1).toString() + " " + operators.get(index - 1) + " " + secondNumbers.get(index - 1).toString()
                    + " = " + results.get(index - 1).toString();
            return calculationProcess;
        }
    }

    // 저장된 모든 연산 과정 출력
    public void getAllcalCulationProcess() throws EmptyListException {
        // List가 비어있을 경우 예외발생
        if (isEmptyList()) {
            throw new EmptyListException("저장된 연산결과가 없습니다.");
        } else {
            for (int i = 0; i < firstNumbers.size(); i++) {
                System.out.println(i + 1 + " . 번째 연산 과정 : " + firstNumbers.get(i).toString() + " " + operators.get(i) + " " + secondNumbers.get(i).toString()
                        + " = " + results.get(i).toString());
            }
        }
    }

    // 가장 최근 연산 결과 반환
    public double getRecentResult() throws EmptyListException {
        // List가 비어있을 경우 예외발생
        if (isEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다.");
        } else {
            return results.get(results.size() - 1);
        }
    }

    // 가장 최근 연산 과정 반환
    public String getRecentCulationProcess() throws EmptyListException {
        // List가 비어있을 경우 예외발생
        if (isEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다.");
        } else {
            calculationProcess = firstNumbers.get(firstNumbers.size() - 1).toString() + " " + operators.get(operators.size() - 1) + " " + secondNumbers.get(secondNumbers.size() - 1).toString()
                    + " = " + results.get(results.size() - 1).toString();
            return calculationProcess;
        }
    }

    // 가장 최근에 저장된 값 제거
    public void removeRecentResults() throws EmptyListException {
        // List가 비어있을 경우 예외발생
        if (isEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다.");
        } else {
            System.out.println("가장 최근 연산과정인 " + firstNumbers.get(firstNumbers.size() - 1) + operators.get(operators.size() - 1)
                    + secondNumbers.get(secondNumbers.size() - 1) + " = " + results.get(results.size() - 1) + " 가 삭제되었습니다.");
            firstNumbers.remove(firstNumbers.size() - 1);
            secondNumbers.remove(secondNumbers.size() - 1);
            results.remove(results.size() - 1);
            operators.remove(operators.size() - 1);
        }

    }

    // 지정된 연산 결과, 과정 제거
    public void removeResults(int index) throws IndexOutOfBoundsException, EmptyListException {
        // List가 비어있을 경우 예외발생
        if (isEmptyList()) {
            throw new EmptyListException("저장된 연산결과가 없습니다.");
            // size를 초과하는 인덱스를 입력시 예외발생.
        } else if (isIndexOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        } else {
            System.out.println(index + ". 번째 연산과정인 " + firstNumbers.get(index - 1) + operators.get(index - 1)
                    + secondNumbers.get(index - 1) + " = " + results.get(index - 1) + " 가 삭제되었습니다.");
            firstNumbers.remove(index - 1);
            secondNumbers.remove(index - 1);
            results.remove(index - 1);
            operators.remove(index - 1);
        }
    }

    // 모든 저장결과 삭제.
    public void removeAll() throws EmptyListException {
        // List가 비어있을 경우 예외발생
        if (isEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다.");
        } else {
            firstNumbers.clear();
            secondNumbers.clear();
            operators.clear();
            results.clear();
        }
    }

    // 입력값보다 큰값 출력, 스트림,람다식 사용
    public void getInputLargerThanContent(double baseValue) throws EmptyListException {
        if (isEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다.");
        } else {
            System.out.println(baseValue + " 보다 큰 값은");
            results.stream().filter(result -> baseValue < result).forEach(System.out::println);
            System.out.println("입니다.");
        }
    }

    // 결과 리스트의 평균값 리턴
    public double getAvg() throws EmptyListException {
        if (isEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다.");
        } else {
            return results.stream().filter(Objects::nonNull).mapToDouble(Double::doubleValue).average().orElse(0);
        }
    }

    // 결과 리스트중 최댓값 리턴
    public double getMax() throws EmptyListException {
        if (isEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다.");
        } else {
            return results.stream().filter(Objects::nonNull).mapToDouble(Double::doubleValue).max().orElse(0);
        }
    }

    // 결과 리스트중 최솟값 리턴
    public double getMin() throws EmptyListException {
        if (isEmptyList()) {
            throw new EmptyListException("저장된 결과값이 없습니다.");
        } else {
            return results.stream().filter(Objects::nonNull).mapToDouble(Double::doubleValue).min().orElse(0);
        }
    }
}

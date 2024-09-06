package com.calculator.lv2;

import com.calculator.lv2.customexception.*;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Calculator {
    private double result = 0;
    // 연산과정 및 결과 확인 List 생성
    private ArrayList<Integer> firstNumbers = new ArrayList<>();
    private ArrayList<Integer> secondNumbers = new ArrayList<>();
    private ArrayList<String> operators = new ArrayList<>();
    private ArrayList<Double> results = new ArrayList<>();
    // 연산 과정 출력용 String 변수
    private String calculationProcess = "";


    // 사칙연산 계산 부분 메소드 매개변수로 요소를 받아 계산 후 리턴.
    // throws 키워드를 통해 직접 예외를 처리하지않고 발생지에 처리요청
    public double calculate(int firstNum, int secondNum, String operator) throws InputMismatchException, ArithmeticException, OperatorInputException {
        switch (operator) {
            case "+":
                result = firstNum + secondNum;
                // 연산 과정 및 결과 저장 메서드 호출.
                saveCalculationProcess(firstNum, secondNum, result, operator);
                break;
            case "-":
                result = firstNum - secondNum;
                saveCalculationProcess(firstNum, secondNum, result, operator);
                break;
            case "*":
                result = firstNum * secondNum;
                saveCalculationProcess(firstNum, secondNum, result, operator);
                break;
            case "/":
                // 분모가 0일경우 예외 발생 유도.
                if (secondNum == 0) {
                    throw new ArithmeticException("0으로는 나눌 수 없습니다.");
                }
                result = firstNum / secondNum;
                saveCalculationProcess(firstNum, secondNum, result, operator);
                break;
            case "%":
                result = firstNum % secondNum;
                saveCalculationProcess(firstNum, secondNum, result, operator);
                break;
            //연산자 외 문자 입력시 예외 발생 유도
            default:
                throw new OperatorInputException("+,-,*,% 연산자만 입력해주세요");
        }
        return result;
    }

    // 연산 과정 및 결과 저장 메소드.
    private void saveCalculationProcess(int firstNumber, int secondNumber, double result, String operator) {
        firstNumbers.add(firstNumber);
        secondNumbers.add(secondNumber);
        results.add(result);
        operators.add(operator);
    }

    // 빈 List 요청 확인 메소드
    private boolean emptyListChecker() {
        if (firstNumbers.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // List index 가 size 를 넘지않았는지 체크
    private boolean listIndexChecker(int index) {
        if (firstNumbers.size() < index) {
            return true;
        } else {
            return false;
        }
    }

    public boolean negativeIntegerCheck(int firstNum, int secondNum) {
        if (firstNum < 0 || secondNum < 0) {
            return true;
        } else {
            return false;
        }
    }

    // 지정된 연산 결과 출력
    public double getResult(int index) throws IndexOutOfBoundsException, EmptyListException {
        // 맞지않는 인덱스를 입력시.
        if (listIndexChecker(index)) {
            throw new IndexOutOfBoundsException("정확한 인덱스를 입력해주세요.");
        } else if (emptyListChecker()) {
            throw new EmptyListException("저장된 연산결과가 없습니다.");
        } else {
            return results.get(index);
        }
    }


    // 저장된 모든 연산결과 출력
    public void getAllResult() throws EmptyListException {
        // 비어있는 List에게 요청시
        if (emptyListChecker()) {
            throw new EmptyListException("저장된 연산결과가 없습니다.");
        } else {
            for (int i = 0; i < results.size(); i++) {
                System.out.println(i + ". 번째 결과 : " + results.get(i));
            }
        }
    }

    // 지정된 연산 과정 출력
    public String getcalCulationProcess(int index) throws IndexOutOfBoundsException, EmptyListException {
        // 맞지않는 인덱스를 입력시.
        if (listIndexChecker(index)) {
            throw new IndexOutOfBoundsException("정확한 인덱스를 입력해주세요.");
        } else if (emptyListChecker()) {
            throw new EmptyListException("저장된 연산결과가 없습니다.");
        } else {
            calculationProcess = firstNumbers.get(index).toString() + " " + operators.get(index) + " " + secondNumbers.get(index).toString()
                    + " = " + results.get(index).toString();
            return calculationProcess;
        }
    }

    // 저장된 모든 연산 과정 출력
    public void getAllcalCulationProcess() throws EmptyListException {
        // 비어있는 List에게 요청시
        if (emptyListChecker()) {
            throw new EmptyListException("저장된 연산결과가 없습니다.");
        } else {
            for (int i = 0; i < firstNumbers.size(); i++) {
                System.out.println(i + " . 번째 연산 과정 : " + firstNumbers.get(i).toString() + " " + operators.get(i) + " " + secondNumbers.get(i).toString()
                        + " = " + results.get(i).toString());
            }
        }
    }

    // 가장 최근 연산 결과 반환
    public double getRecentResult() throws EmptyListException {
        if (emptyListChecker()) {
            throw new EmptyListException("저장된 결과값이 없습니다.");
        } else {
            return results.get(results.size() - 1);
        }
    }

    // 가장 최근 연산 과정 반환
    public String getRecentCulationProcess() throws EmptyListException {
        if (emptyListChecker()) {
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
        if (emptyListChecker()) {
            throw new EmptyListException("저장된 결과값이 없습니다.");
            // 비어있지 않을 경우 최근값 제거
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
        if (listIndexChecker(index)) {
            throw new IndexOutOfBoundsException("정확한 인덱스를 입력해주세요.");
        } else if (emptyListChecker()) {
            throw new EmptyListException("저장된 연산결과가 없습니다.");
        } else {
            System.out.println(index + ". 번째 연산과정인 " + firstNumbers.get(index) + operators.get(index)
                    + secondNumbers.get(index) + " = " + results.get(index) + " 가 삭제되었습니다.");
            firstNumbers.remove(index);
            secondNumbers.remove(index);
            results.remove(index);
            operators.remove(index);
        }
    }

    // 모든 저장결과 삭제.
    public void removeAll() throws EmptyListException {
        if (emptyListChecker()) {
            throw new EmptyListException("저장된 결과값이 없습니다.");
        } else {
            firstNumbers.clear();
            secondNumbers.clear();
            operators.clear();
            results.clear();
        }
    }
}

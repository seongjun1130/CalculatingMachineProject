#     CalculatingMachineProject 📝
이 프로젝트는 자바의 **Enum**, **제네릭**, **람다**, **스트림 API**와 **OOP** 개념을 활용한 계산기입니다. 각 연산은 Enum으로 정의하고, 제네릭을 통해 다양한 타입을 처리하며, 람다와 스트림으로 데이터 처리를 간결하게 구현했습니다. 가독성과 확장성을 고려한 객체지향 설계로 유연한 계산 기능을 제공합니다.

해당 계산기는 하단 구현 가이드라인에 초점을 맞추어 구현하였습니다.

[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fseongjun1130&count_bg=%2379C83D&title_bg=%23555555&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://github.com/seongjun1130)

## 목차
- [개요](#개요)
- [기능 구현 가이드라인](#기능-구현-가이드라인)
- [프로그램 기능구현표](#프로그램-기능구현표)
- [프로그램 플로우차트](#프로그램-플로우차트)
- [프로그램 동작화면](#프로그램-동작-화면)
- [아키텍쳐](#Architecture)

## 개요
- 프로젝트 이름 : CalculatingMachineProject
- 프로젝트 지속기간 : 2024.09.05 ~ 2024.09.10
- 개발언어 : JAVA
- 멤버 : 조성준

## 기능 구현 가이드라인
<details>
<summary>접기/펼치기</summary>
  
![image](https://github.com/user-attachments/assets/bd10b9bd-2922-4821-ae2f-79908cdc5f5d)
![image](https://github.com/user-attachments/assets/f2ad5b70-4100-48d3-8f48-6c030fef5ea0)
![image](https://github.com/user-attachments/assets/5558d73b-95dc-4e57-8fa9-7fff1eba938e)

</details>

## 프로그램 기능구현표
![image](https://github.com/user-attachments/assets/590bfb4d-3fc7-4bc0-b90c-5e3819fe30d4)

## 프로그램 플로우차트
- ### Main Flow
![계산기 Main](https://github.com/user-attachments/assets/b7c879fe-5e19-4547-944c-acd3ad0593ea)
- ### result index remove Flow
![계산기 index 삭제](https://github.com/user-attachments/assets/c6376530-11cb-4c9e-8d39-d06995ff5607)
## 주요기능
- 연산 결과 및 연산 **과정** 확인 가능.
- 연산 결과 및 과정 삭제 가능.
- 연산 결과에 대한 Index식 접근 가능.


## 프로그램 동작 화면
<details>
<summary>접기/펼치기</summary>
  
![](https://velog.velcdn.com/images/lionjojo/post/87e50e26-19ba-441c-a97d-eb59c486fb39/image.png)![](https://velog.velcdn.com/images/lionjojo/post/91670e85-49d0-4543-a7d1-9dce24b4229b/image.png)![](https://velog.velcdn.com/images/lionjojo/post/15200186-ab0f-4daf-9da4-b47256c20ce3/image.png)


</details>

## Stacks
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"> <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
## Communication
- ### Main blog
https://velog.io/@lionjojo/posts
- ### Main project Documentation
https://velog.io/@lionjojo/JAVA-%EA%B3%84%EC%82%B0%EA%B8%B0-%EB%A7%8C%EB%93%A4%EA%B8%B0-Lv.3
- ### project troubleshooting
https://velog.io/@lionjojo/JAVA-%EA%B3%84%EC%82%B0%EA%B8%B0-%EB%A7%8C%EB%93%A4%EA%B8%B0-%ED%8A%B8%EB%9F%AC%EB%B8%94%EC%8A%88%ED%8C%85
## Architecture
```
📦 
├─ .gitignore
├─ .idea
│  ├─ .gitignore
│  ├─ material_theme_project_new.xml
│  ├─ misc.xml
│  ├─ modules.xml
│  ├─ uiDesigner.xml
│  └─ vcs.xml
├─ CalculatingMachineProject.iml
├─ gitmessage.txt
└─ src
   └─ com
      └─ calculator
         ├─ lv1 : Lv.1 제약으로 구현한 계산기
         │  └─ Calculator.java 
         ├─ lv2 : Lv.2 제약으로 구현한 계산기
         │  ├─ App.java : main 실행 class
         │  ├─ Calculator.java : 계산 담당 Class
         │  ├─ ServiceManager.java : 프로그램 흐름 제어 class
         │  └─ customexception : 커스텀 예외
         │     ├─ EmptyListException.java
         │     └─ OperatorInputException.java
         └─ lv3: Lv.3 제약으로 구현한 계산기
            ├─ AbstractCalculator.java : 계산기능 추상 Class
            ├─ AddCalculator.java
            ├─ App.java : main 실행 class
            ├─ ArithmeticCalculator.java : 계산 흐름 담당 및 추가기능 담당 Class
            ├─ CalculatorManager.java : 계산기능구현 Class 관리 Class
            ├─ DivCalculator.java
            ├─ MultCalculator.java
            ├─ RemCalculator.java
            ├─ ServiceManager.java : 프로그램 흐름 제어 Class
            ├─ SubCalculator.java
            └─ customexception
               ├─ EmptyListException.java
               └─ OperatorInputException.java
```

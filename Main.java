package org.example;

import java.util.Scanner;

// public : java 파일의 주인 객체 이름.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력
        String a = sc.next();
        // 계산
        StringBuilder sb = getStrings(a);
        // 출력
        System.out.println(sb);
    }

    private static StringBuilder getStrings(String a) {
        StringBuilder result = new StringBuilder(); // result 생성
        // 기본형 타입 char를 참조형 타입 Character로 바꿔주는 warpper 클래스
        // char -> Character로 바꿔주는 코드를 넣은게 없다...
        // ------------------------------------------
        // boxing, 반대는 unboxing
        for(Character c : a.toCharArray()) {
            // 삼항연산자
            c = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
            result.append(c);
        }
        return result;
    }
}


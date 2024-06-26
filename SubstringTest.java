package org.example;

import java.util.Scanner;

public class SubstringTest {
    public static void main(String[] args) {
        String hi = "Hello 안녕하세요.";
        String result = hi.substring(2); //(2) 퍼라미터 인수 인자
        System.out.println(hi);
        String result1 = hi.substring(2);
        System.out.println(result1);
        String result2  = hi.substring(2,4); // 파람스
        System.out.println(result2);
        CharSequence result3 = hi.subSequence(2,4);
        System.out.println(result3);

        int[] nums = new int[5]; //인트 기본형타입에 배열 길이는 5야
        int[] nums2= {1,2,3,4,5};
        int num3 = nums[2];
        System.out.println(num3);
        nums[3] = 2;
    }
}

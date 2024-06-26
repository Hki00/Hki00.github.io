package org.example;

public class test2 {
    public static void main(String[] args) {
        int result = solution(9,91);
        System.out.println(result);
    }

    public static int solution(int a, int b) {
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);
        int ab = Integer.parseInt(strA + strB);
        int ba = Integer.parseInt(strB + strA);
        return ab>=ba ? ab : ba;

        //return Math.max(ab, ba);
    }
}
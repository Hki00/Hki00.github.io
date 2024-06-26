package org.example;

public class test1 {
    public static void main(String[] args) {
        test1 a = new test1();
        String res = a.solution("string", 3);
        System.out.println(res);
    }

    public String solution (String my_string,int k){

        String answer = my_string;

        for(int i = 1; i < k; i++){
            answer = answer + my_string;

        }
        return answer;
    }
}

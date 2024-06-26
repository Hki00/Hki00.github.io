package org.example;

public class test {
    public static void main(String[] args) {
        test t = new test();
        test g = new test();
        String res =  t.solution("He11oWor1d","lloWorl",2);
        System.out.println(res);

        String reslut =  g.solution("Program29b8UYP","merS123",7);
        System.out.println(reslut);

    }

    public String solution(String my_string, String overwrite_string, int s){

        //String answer = my_string.substring(s,s+overwrite_string.length());
        //String a = my_string.replace(answer,overwrite_string);
        String a = my_string.substring(0,s);
        String b = my_string.substring(s+overwrite_string.length());;

        return a+overwrite_string+b;
        //return answer1;

    }
}

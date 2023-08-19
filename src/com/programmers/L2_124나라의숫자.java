package com.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class L2_124나라의숫자 {
    public static String solution(int n) {
        String answer = "";
//        String arr[] = new String[500001];
//        arr[0] = "4";
//        arr[1] = "1";
//        arr[2] = "2";
//        arr[3] = "4";
//        String temp = "";
//        for(int i=4; i<arr.length; i++){
//            if(i%3 == 0){
//                arr[i] = arr[(i-1)/3] + arr[i%3];
//            }else{
//                arr[i] = arr[i/3] + arr[i%3];
//            }
//        }
//        answer = arr[n];
        answer = dp(n);
        return answer;
    }

    static String dp(int num){
        if(num == 0){
            return "4";
        }
        if(num == 1){
            return "1";
        }
        if (num == 2){
            return "2";
        }
        if (num == 3){
            return "4";
        }

        if(num % 3 == 0){
            return dp((num-1)/3) + dp(num%3);
        }else{
            return dp(num/3) + dp(num%3);
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<38; i++){
            System.out.println(solution(i));
        }
    }
}
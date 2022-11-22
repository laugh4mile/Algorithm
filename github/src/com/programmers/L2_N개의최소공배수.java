package com.programmers;

import java.util.Arrays;

class L2_N개의최소공배수 {
    public static int solution(int[] arr) {
        int answer = arr[0];

        for(int i=1; i<arr.length; i++){
            answer = getLCM(answer, arr[i]);
        }
        return answer;
    }

    static int getLCM(int num1, int num2){
        return num1 * num2 / getGCD(num1,num2);
    }

    static int getGCD(int num1, int num2){
        int a = Integer.max(num1, num2);
        int b = Integer.min(num1, num2);

        int r = a%b;

        if(r == 0){
            return b;
        }else{
            return getGCD(b, r);
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,6,8,14};
        System.out.println(solution(arr));
    }
}
package com.codingtest.kakaoMobility;

import java.util.Arrays;

public class Q3 {
    static int[] A = {1,2,3,4};
    public static void main(String[] args) {
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int answer = 0;
        if(check(A)){
            return 0;
        }
        for(int i=0; i<A.length; i++){
            int temp = A[i];
            A[i] = 0;
            if(check(A)){
                answer++;
            }
            A[i] = temp;
        }

        if(answer == 0){
            return -1;
        }
        return answer;
    }

    private static boolean check(int[] A) {
        boolean isHigh = false;
        if(A[0] < A[1]){
            isHigh = true;
        }else{
            isHigh = false;
        }

        for(int i=1; i<A.length-1; i++){
            if(isHigh){
                if (A[i] <= A[i+1]){
                    return false;
                }else{
                    isHigh = false;
                }
            }else{
                if(A[i] >= A[i+1]){
                    return false;
                }else{
                    isHigh = true;
                }
            }
        }
       return true;
    }
}

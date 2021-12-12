package com.codingtest.line.fintechIntern;

public class Q1 {
    static int[] arr = {5, 2, -16, 4,1,2,1,-4,-5,-7,10,30,-5,-5,-5,-5,-5};
    public static void main(String[] args) {
        System.out.println(solution(arr));
    }
    public static int solution(int[] arr) {
        int answer = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(sum > 0){
                answer++;
            }
        }
        return answer;
    }
}

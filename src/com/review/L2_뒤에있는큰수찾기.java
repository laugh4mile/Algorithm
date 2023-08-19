package com.review;

import java.util.Arrays;

public class L2_뒤에있는큰수찾기 {
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        int[] answerIdx = new int[numbers.length];
        answerIdx[numbers.length-1] = numbers.length;

        for(int i=numbers.length-2; i>=0; i--){
            int next = i+1;
            while(numbers[i] >= numbers[next]){
                next = answerIdx[next];
                if(next == numbers.length) break;
            }
            answerIdx[i] = next;
        }
//        System.out.println(Arrays.toString(answerIdx));
        for(int i=0; i<numbers.length; i++){
            if(answerIdx[i] == numbers.length){
                answer[i] = -1;
            }else{
                answer[i] = numbers[answerIdx[i]];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5}; // 3, 5, 5, -1
//        int[] numbers = {9, 1, 5, 3, 6, 2}; // -1, 5, 6, 6, -1, -1
        System.out.println(Arrays.toString(solution(numbers)));
    }
}

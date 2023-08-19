package com.programmers;

import java.util.Arrays;

class L2_카펫 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int i=1; i<= yellow; i++){
            int h = yellow/i;
            if(i*h != yellow) continue;

            if((i+2)*2 + (h+2)*2 - 4 == brown){
                answer[0] = Integer.max(i+2, h+2);
                answer[1] = Integer.min(i+2, h+2);
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(24,24)));
    }
}
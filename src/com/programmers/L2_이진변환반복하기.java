package com.programmers;

import java.util.Arrays;

class L2_이진변환반복하기 {
    public static int[] solution(String s) {
        int[] answer = new int[2];
        int a = 0; // 제거한 0의 수
        int b = 0;
        while(!s.equals("1")){
            b++;
            int xLength = 0;
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i) == '1'){
                    xLength++;
                }
            }
            a += s.length()-xLength;
            s = Integer.toBinaryString(xLength);
        }
        answer[0] = b;
        answer[1] = a;

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
    }
}
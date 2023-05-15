package com.programmers;

import java.util.Arrays;

class L2_주식가격 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0; i<prices.length-1; i++){
            int j = 0;
            for(j=i+1; j<prices.length; j++){
                if(prices[i] > prices[j]){
                    break;
                }
            }
            if(j-i-1 == 0){
                answer[i] = 1;
            }else{
                answer[i] = j-i-1;
            }
            System.out.println(j-i-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] prices = {2, 2, 2};
        System.out.println(Arrays.toString(solution(prices)));
    }
}
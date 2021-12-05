package com.codingtest.kakao.recommand;

import java.util.Arrays;
import java.util.List;

public class Q1 {
    public static int solution(List<Integer> stockPrices, int k) {
        int answer = 0;

        int arr[] = new int [stockPrices.size()];
        Arrays.fill(arr,1);
        for(int i=1; i<stockPrices.size(); i++){
            if(stockPrices.get(i-1) < stockPrices.get(i)){
                arr[i] = arr[i-1]+1;
            }
        }

        for(int i=0; i<arr.length; i++){
            if(arr[i] >= k){
                answer++;
            }
        }

        return answer;
    }
}

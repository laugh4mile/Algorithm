package com.codingtest.woowa.test2021;

import java.util.Arrays;

public class Q1 {
	static int arr[] = {2, 1, 3, 1, 2, 1};
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(arr)));
	}
	
	public static int[] solution(int[] arr) {
        int[] answer = new int[3];
        int max = 0;
        
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 1){
            	answer[0]++; 
            }else if(arr[i] == 2){
            	answer[1]++; 
            }else{
            	answer[2]++; 
            }
        }
        max = Math.max(answer[0], Math.max(answer[1], answer[2]));
        answer[0] = max - answer[0];
        answer[1] = max - answer[1];
        answer[2] = max - answer[2];
        
        return answer;
    }
}

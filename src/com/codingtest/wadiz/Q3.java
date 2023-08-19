package com.codingtest.wadiz;

public class Q3 {
//	static int[] arr = {1, 2, 4, 8, 4, 2, 1};
//	static int[] arr = {1, 3, 5, 7, 6, 8, 9, 5, 1};
//	static int[] arr = {10, 0, 10, 0, 10, 0};
	static int[] arr = {5, 4, 5, 4, 5, 5};
	public static void main(String[] args) {
		int answer = solution(arr);
		System.out.println(answer);
	}
	
	private static int solution(int[] arr) {
		int answer = 0;
		int temp[] = new int[arr.length];
		int min, start=0, end=0;
		
		boolean flag = true;
		
		while(flag) {
			flag = false;
			for(int i=0; i<arr.length; i++) {
				if(arr[i] != temp[i]) {
					flag = true;
					break;
				}
			}
			for(int i=0; i<arr.length; i++) {
				min = Integer.MAX_VALUE;
				if(arr[i] > temp[i]) {
					start = i;
					for(int j=i; j<arr.length; j++) {
						if(arr[j] > temp[j]) {
							end = j;
							if(min > arr[j]) {
								min = arr[j];
							}
						}else {
							break;
						}
					}
					for(int j=start; j<=end; j++) {
						temp[j] = min;
					}
					answer++;
				}
			}
			
		}
		return answer;
	}
}

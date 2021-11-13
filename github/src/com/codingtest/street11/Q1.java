package com.codingtest.street11;

public class Q1 {
	static int[] A = {5,3,10,6,1,1_000_000_000,1_000_000_001};
	public static void main(String[] args) {
		System.out.println(solution(A));
	}
	public static int solution(int[] A) {
        int maxOdd = 0;
        int maxEven = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] % 2 == 0 && A[i] > maxEven){
                maxEven = A[i];
            }else if(A[i] % 2 == 1 && A[i] > maxOdd){
                maxOdd = A[i];
            }
        }
        return maxOdd+maxEven;
    }
}

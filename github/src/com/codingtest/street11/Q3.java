package com.codingtest.street11;

public class Q3 {
	static int[] A = {1,2,2,4,4,4};
	public static void main(String[] args) {
		System.out.println(solution(A));
	}
	public static int solution(int[] A) {
        int answer = 0;
        int num = A[0];
        int cnt = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] == num) {
                cnt++;
            }else{
                answer += Math.min(cnt, Math.abs(num-cnt)); // 다 없애는 경우 or 개수 맞추는 경우의 최소
                num = A[i];
                cnt = 1;
            }
        }
        answer += Math.min(cnt, Math.abs(num-cnt));

        // System.out.println(answer);
        return answer;
    }
}

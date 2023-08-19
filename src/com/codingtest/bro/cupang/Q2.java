package com.codingtest.bro.cupang;

public class Q2 {
	public static void main(String[] args) {
//		int[] s = {1,2,3};
//		int[] s = {3,-1,0,4};
//		int[] s = {3,-1,0,4,3,2,1,3,4,2,1,3};
		int[] s = {0,0,0,0};
		
		int answer = solution(s);
		System.out.println(answer);
	}

	private static int solution(int[] s) {
		int answer = 0;
		int cur = s[0];
		boolean toggle = false; // false면 up, true면 down
		for(int i=1; i<s.length; i++) {
//			System.out.println(cur+ " " + toggle );
			int next = s[i];
			if(!toggle) {
				if(cur < next) {
					cur = next;
				}else {
					answer++;
					cur = Integer.MAX_VALUE;
					i--;
				}
			}else{
				if(cur > next) {
					cur = next;
				}else {
					answer++;
					cur = Integer.MIN_VALUE;
					i--;
				}
			}
			toggle = !toggle;
		}
		
		return answer;
	}
}

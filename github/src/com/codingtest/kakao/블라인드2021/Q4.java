package com.codingtest.kakao.블라인드2021;

import java.util.Arrays;

public class Q4 {
	static int n = 5;
	static int[] info = {2,1,1,1,0,0,0,0,0,0,0};
	public static void main(String[] args) {
		solution(n, info);
		System.out.println(Arrays.toString(answer));
	}
	
	
	static int[] answer;
	static int[] temp = new int[11];
	static int[] result;
	static int maxChai = 0;
	public static int[] solution(int n, int[] info) {
        int[] answer2 = {-1};
        answer = new int[11];
        result = new int[n];
        combi(info, n, 0, 0, n);
        int sum = 0;
        for(int i=0; i<11; i++) {
        	sum += answer[i];
        }
        if(sum>0) {
        	return answer;
        }else {
        	return answer2;
        }
    }
	private static void combi(int[] info, int R, int start, int cnt, int n) {
		if(cnt == R) {
			check(info, n);
			return;
		}
		for(int i=start; i<11; i++) {
			result[cnt] = 10-i;
			combi(info, R, i, cnt+1, n);
		}
	}
	private static void check(int[] info, int n) {
		Arrays.fill(temp, 0);
		for(int i=0; i<n; i++) {
			temp[10-result[i]]++;
		}
		int ryanScore = 0;
		int apeachScore = 0;
		for(int i=0; i<11; i++) {
			if(info[i]+temp[i] > 0) { // 둘다 0이면 안됨
				if(info[i] < temp[i]) {
					ryanScore += 10 - i;
				}else {
					apeachScore += i;
				}
			}
		}
		if(maxChai < ryanScore - apeachScore) {
			answer = new int[11];
			maxChai = ryanScore - apeachScore;
			for(int i=0; i<11; i++) {
				answer[i] = temp[i];
			}
		}
	}
}










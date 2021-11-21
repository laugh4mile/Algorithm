package com.codingtest.devMatchingSiliconValley;

import java.util.Arrays;

public class Q3 {
//	static long[] wave1 = {1,2,2,1,1,2};
//	static long[] wave2 = {-2,-1};
	static long[] wave1 = {2, 0, 1, 1, 1, 0};
	static long[] wave2 = {0,0,-1};
	public static void main(String[] args) {
		System.out.println(solution(wave1, wave2));
	}
	static long min = Long.MAX_VALUE;
	public static long solution(long[] wave1, long[] wave2) {
        long answer = -1;
        int len1 = wave1.length;
        int len2 = wave2.length;
        
        int gcd = getGcd(len1, len2);
        int N = (len1 * len2) / gcd; // 최소 공배수
        
        long[] n_wave1 = new long[N];
        long[] n_wave2 = new long[N];
        long[] c_wave = new long[N];
        
        for(int i=0; i<N; i++) {
        	n_wave1[i] = wave1[i%len1];
        	n_wave2[i] = wave2[i%len2];
        }
        for(int i=0; i<len2; i++) { // 0~len2 번 딜레이.
        	long temp = n_wave2[0];
        	for(int j=0; j<N-1; j++) {
        		n_wave2[j] = n_wave2[j+1];
        	}
        	n_wave2[N-1] = temp;
        	for(int j=0; j<N; j++) {
            	c_wave[j] = n_wave1[j] + n_wave2[j];
            }
        	getAD(c_wave);
        	if(min == 0) {
        		return 0;
        	}
        }
        answer = min;
        return answer;
    }
	
	private static void getAD(long[] c_wave) {
		long check = c_wave[0];
		boolean allEqual = true;
		int N = c_wave.length;
		long sum = 0;
		for(int i=0; i<N; i++) {
			sum += Math.pow(c_wave[i], 2) ;
			if(c_wave[i] != check) {
				allEqual = false;
			}
		}
		if(allEqual) {
			min = 0;
			return;
		}
		if(min > sum) {
			min = sum;
		}
		sum = 0;
		// 주기가 있는지 확인해야 함
		// N의 모든 약수를 구한다.
		outer : for(int i=2; i<=N; i++) {
			if((N%i) == 0) { // 약수는 i.
				long[] fq = new long[i];
				for(int j=0; j<i; j++) {
					fq[j] = c_wave[j];
				}
				for(int j=i; j<N; j++) {
					if(fq[j%i] != c_wave[j]) {
						continue outer;
					}
				}
//				// 여기까지 왔다면 주기가 i라는 의미.
				for(int j=0; j<i; j++) {
					sum+= Math.pow(c_wave[j], 2);
				}
				if(min > sum) {
					min = sum;
				}
			}
		}
	}
	
	private static int getGcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}

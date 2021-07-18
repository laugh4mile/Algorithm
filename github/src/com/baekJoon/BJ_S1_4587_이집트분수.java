package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S1_4587_이집트분수 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int M,N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		while(true) {
			tokens = new StringTokenizer(input.readLine());
			M = Integer.parseInt(tokens.nextToken());
			N = Integer.parseInt(tokens.nextToken());

			// 1. 0 0 이 나오면 종료
			if(M == 0 && N == 0) break;
			
			// 2. 다음 단위 분수의 분모를 정해야 함
			while(M!=1) {
				int nextN = (int) Math.ceil((double) N/M);
				while(true) { // 단위 분수의 분모가 1000000보다 크거나 같으면 nextN을 1씩 증가
					// N과 nextN의 최소 공배수가 분모이다.
					// 최소 공배수는 N * nextN / 최대 공약수이다.
					// 따라서 최대 공약수를 먼저 구한다.
					int gcd = getGcd(N, nextN);
					int lcm = N * nextN / gcd;
					
					int newM1 = (lcm/N)*M;
					int newM2 = lcm/nextN;
					int newM = newM1 - newM2;
					
					// 새로나온 분자와 분모를 약분해서 분모가 1000000이 넘지 않아야 한다.
					// 약분은 분자 분모의 최대공약수로 나눌 거임.
					gcd = getGcd(newM, lcm);
					newM = newM/gcd;
					lcm = lcm/gcd;
					if(lcm >= 1000000) {
						nextN++;
					}else {
						System.out.print(nextN+" ");
						N = lcm;
						M = newM;
						break;
					}
				}
			}
			System.out.println(N+" ");
		}
	}

	private static int getGcd(int a, int b) {
		int temp = 0;
		while(b>0) {
			temp = a;
			a = b;
			b = temp%b;
		}
		return a;
	}

	static String src =
			"3 4\r\n" + 
//			"2 7\r\n" + 
//			"9 20\r\n" + 
//			"17 69\r\n" + 
//			"5 92\r\n" + 
//			"16 17\r\n" + 
//			"21 23\r\n" + 
//			"36 37\r\n" + 
//			"35 47\r\n" + 
//			"44 53\r\n" + 
//			"5 61\r\n" + 
//			"4 73\r\n" + 
//			"50 89\r\n" + 
//			"8 97\r\n" + 
			"0 0";
}

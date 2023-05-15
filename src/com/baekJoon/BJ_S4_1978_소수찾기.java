package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2021. 4. 11
 * @see 
 * @mem
 * @time
 * @caution
 * [고려사항] 
 * [입력사항] 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 * [출력사항] 주어진 수들 중 소수의 개수를 출력한다.
 */
public class BJ_S4_1978_소수찾기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static boolean isPrime[]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		tokens = new StringTokenizer(input.readLine());

		isPrime = new boolean[1001];
		for(int i=2; i<1001; i++) {
			isPrime[i] = true;
		}
		
		// 에라토스테네스의 채
		for(int i=2; i*i<=1000; i++) {
			for(int j=i*i; j<=1000; j+=i) {
				isPrime[j] = false;
			}
		}
		
		int answer = 0;
		for(int n=0; n<N; n++) {
			if(isPrime[Integer.parseInt(tokens.nextToken())]) {
				answer ++;
			}
		}
		System.out.println(answer);
		
	}

	static String src =

			"4\r\n" + 
			"1 3 5 7";
}

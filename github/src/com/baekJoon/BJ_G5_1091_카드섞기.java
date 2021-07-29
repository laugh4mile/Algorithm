package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G5_1091_카드섞기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,P[],S[],card[],temp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		P = new int[N];
		S = new int[N];
		card = new int[N];
		temp = new int[N];
		int cnt = 0;
		
		for(int i=0; i<N; i++) { // card 초기상태
			card[i] = i%3;
		}
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			P[i] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			S[i] = Integer.parseInt(tokens.nextToken());
		}
		
		while(true) {
//			System.out.println(Arrays.toString(card));
			boolean isMatched = true; 
			boolean inf = true;
			for(int i=0; i<N; i++) { // card가 P와 같은지 확인
				if(card[i] != P[i]) {
					isMatched = false;
					break;
				}
			}
			if(!isMatched) { // card와 P가 다를 경우 
				for(int i=0; i<N; i++) {
					temp[i] = card[S[i]];
				}
				card = temp.clone();
				cnt++;
			}else { // card가 P와 같다면 cnt 출력.
				System.out.println(cnt);
				break;
			}
			
			for(int i=0; i<N; i++) {
				if(card[i] != i%3) {
					inf = false;
				}
			}
			if(inf) {
				System.out.println(-1);
				break;
			}
		}
		
		 
		// card가 P와 다르다면 셔플. 
		
	}

	static String src =
			"6\r\n" + 
			"0 1 2 0 1 2\r\n" + 
			"1 4 0 3 2 5";
}

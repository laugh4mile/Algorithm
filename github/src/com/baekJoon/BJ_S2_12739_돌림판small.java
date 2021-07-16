package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_12739_돌림판small {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, K;
	static char board[], temp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		String line = input.readLine();
		board = new char[N];
		temp = new char[N];
		for(int i=0; i<N; i++) {
			board[i] = line.charAt(i);
		}
//		System.out.println(Arrays.toString(board));
		if(N == 1) { 
			board[0] = 'G';
		}else {
			for(int k=0; k<K; k++) {
				for(int i=0; i<N; i++) {
					if(i == 0) {
						if((board[0] == board[1] && board[0] == board[N-1]) ||
								(board[0] != board[1] && board[0] != board[N-1] && board[1] != board[N-1])) {
							temp[0] = 'B';
						}else {
							separate(board[N-1],board[0],board[1], i);
						}
					}else if(i == N-1) {
						if((board[0] == board[N-2] && board[0] == board[N-1]) ||
								(board[0] != board[N-2] && board[0] != board[N-1] && board[N-2] != board[N-1])) {
							temp[N-1] = 'B';
						}else {
							separate(board[N-2],board[N-1],board[0], i);
						}
					}else {
						if((board[i] == board[i+1] && board[i] == board[i-1]) ||
								(board[i] != board[i+1] && board[i] != board[i-1] && board[i+1] != board[i-1])) {
							temp[i] = 'B';
						}else {
							separate(board[i-1],board[i],board[i+1], i);
						}
					}
				}
				board = temp.clone();
//				System.out.println(Arrays.toString(board));
			}
		}
		int cR = 0, cG = 0, cB = 0;
		for(int i=0; i<N; i++) {
			if(board[i] == 'R') {
				cR++;
			}else if(board[i] == 'G') {
				cG++;
			}else {
				cB++;
			}
		}
		System.out.println(cR+" "+cG+" "+cB);
	}

	private static void separate(char color1, char color2, char color3, int i) {
		int cR=0, cG=0, cB=0;
		if(color1 == 'R') {
			cR++;
		}else if(color1 == 'G') {
			cG++;
		}else {
			cB++;
		}
		if(color2 == 'R') {
			cR++;
		}else if(color2 == 'G') {
			cG++;
		}else {
			cB++;
		}
		if(color3 == 'R') {
			cR++;
		}else if(color3 == 'G') {
			cG++;
		}else {
			cB++;
		}
		if((cR==2 && cG==1) || (cG==2 && cB==1) || (cB==2 && cR==1)) {
			temp[i] = 'R';
		}else {
			temp[i] = 'G';
		}
	}
	
	

	static String src =
			"1 5\r\n"
			+ "R";
}

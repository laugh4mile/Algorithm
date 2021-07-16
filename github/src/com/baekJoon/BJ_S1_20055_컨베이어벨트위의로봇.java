package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S1_20055_컨베이어벨트위의로봇 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K,belt[][], temp[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		
		belt = new int [2*N][2];
		temp = new int [2*N][2];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<2*N; i++) {
			belt[i][0] = Integer.parseInt(tokens.nextToken());
		}
		int answer = 0;
		int count;
		while(true) {
			answer++;
			count = 0;
			for(int i=0; i<N; i++) {
				System.out.printf("(%3d %d) ", belt[i][0], belt[i][1]);
			}
			System.out.println();
			for(int i=2*N-1; i>=N; i--) {
				System.out.printf("(%3d %d) ", belt[i][0], belt[i][1]);
			}
			System.out.println();
			System.out.println();
			// 1. 한칸씩 이동
			for(int i=0; i<2*N; i++) {
				if(i == 0) {
					for(int j=0; j<2; j++) {
						temp[i][j] = belt[2*N-1][j];
					}
				}else {
					for(int j=0; j<2; j++) {
						temp[i][j] = belt[i-1][j];
					}
				}
			}
			// 2. 로봇이 내리는 위치에 닿으면 빼야함
			if(temp[N-1][1] == 1) {
				temp[N-1][1] = 0;
			}
			// 3. 로봇은 한칸 더 이동
			for(int i=1; i<N-1; i++) {
				if(temp[i][1] == 1 && temp[i+1][1] != 1 && temp[i+1][0] > 0) {
					temp[i+1][0]--;
					temp[i][1] = 0;
					temp[i+1][1] = 1;
				}
			}
			// 4. 이동한 로봇이 내리는 위치이면 빼야함
			if(temp[N-1][1] == 1) {
				temp[N-1][1] = 0;
			}
			// 5. 새로운 로봇을 올림
			if(temp[0][0] > 0) {
				temp[0][0]--;
				temp[0][1] = 1;
			}
			
			// 6. 내구도 검사
			for(int i=0; i<2*N; i++) {
				if(temp[i][0] <= 0) {
					count++;
				}
			}
			if(count >= K) {
				break;
			}
			// 7. belt를 temp로 초기화
			for(int i=0; i<2*N; i++) {
				for(int j=0; j<2; j++) {
					belt[i][j] = temp[i][j];
				}
			}
//			for(int x[]: belt) {
//				System.out.println(Arrays.toString(x));
//			}
//			System.out.println();
			if(answer>3) {
				break;
			}
			
		}
		System.out.println(answer);
	}

	static String src =
			"4 5\r\n"
			+ "10 1 10 6 3 4 8 2";
}

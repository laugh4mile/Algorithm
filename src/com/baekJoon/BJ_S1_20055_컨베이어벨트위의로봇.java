package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
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
			// 2. belt를 temp로 초기화
			for(int i=0; i<2*N; i++) {
				for(int j=0; j<2; j++) {
					belt[i][j] = temp[i][j];
				}
			}
			// 3. 로봇이 내리는 위치에 닿으면 빼야함
			if(belt[N-1][1] == 1) {
				belt[N-1][1] = 0;
			}
			// 4. 로봇은 한칸 더 이동
			for(int i=N-2; i>=1; i--) {
				if(belt[i][1] == 1 && belt[i+1][1] != 1 && belt[i+1][0] > 0) {
					belt[i][1] = 0;
					belt[i+1][1] = 1;
					belt[i+1][0]--;
				}
			}
			// 5. 이동한 로봇이 내리는 위치이면 빼야함
			if(belt[N-1][1] == 1) {
				belt[N-1][1] = 0;
			}
			// 6. 새로운 로봇을 올림
			if(belt[0][0] > 0) {
				belt[0][0]--;
				belt[0][1] = 1;
			}
			
			// 7. 내구도 검사
			for(int i=0; i<2*N; i++) {
				if(belt[i][0] <= 0) {
					count++;
				}
			}
			if(count >= K) {
				break;
			}
//			for(int i=0; i<N; i++) {
//				System.out.printf("(%3d %d) ", belt[i][0], belt[i][1]);
//			}
//			System.out.println();
//			for(int i=2*N-1; i>=N; i--) {
//				System.out.printf("(%3d %d) ", belt[i][0], belt[i][1]);
//			}
//			System.out.println();
//			System.out.println();			
		}
		System.out.println(answer);
	}

	static String src =
			"5 8\r\n" + 
			"100 99 60 80 30 20 10 89 99 100";
}

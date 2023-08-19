package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S2_5464_주차장 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,Rs[],Wk[], cars[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		Rs = new int[N+1];
		cars = new int[N+1];
		Wk = new int[M+1];
		for(int n=1; n<=N; n++) {
			Rs[n] = Integer.parseInt(input.readLine());
		}
		for(int m=1; m<=M; m++) {
			Wk[m] = Integer.parseInt(input.readLine());
		}
		
		int sum = 0;
		Queue<Integer> wating = new LinkedList<>();
		outer : for(int t=0; t<2*M; t++) {
			int car = Integer.parseInt(input.readLine());
			
			if(car >= 0) { // 입차
				// 빈자리 있는지 확인
				for(int n=1; n<N+1; n++) { // 빈자리 있을경우
					if(cars[n] == 0) {
						cars[n] = car;
						continue outer;
					}
				}
				// 빈자리 없을 경우
				wating.offer(car);
				
			}else { // 출차
				for(int n=1; n<N+1; n++) {
					if(cars[n] == car*(-1)) {
						cars[n] = 0;
						sum += Rs[n] * Wk[car*(-1)];
						if(!wating.isEmpty()) {
							cars[n] = wating.poll();
						}
						break;
					}
				}
			}
		}
		
		System.out.println(sum);
	}

	static String src =
			"2 4\r\n"
			+ "5\r\n"
			+ "2\r\n"
			+ "100\r\n"
			+ "500\r\n"
			+ "1000\r\n"
			+ "2000\r\n"
			+ "3\r\n"
			+ "1\r\n"
			+ "2\r\n"
			+ "4\r\n"
			+ "-1\r\n"
			+ "-3\r\n"
			+ "-2\r\n"
			+ "-4";
}

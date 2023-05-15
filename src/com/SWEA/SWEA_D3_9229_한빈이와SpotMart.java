package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2020. 8. 3
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AW8Wj7cqbY0DFAXN&solveclubId=AXOJsQN67-MDFAXS&problemBoxTitle=0803&problemBoxCnt=2&probBoxId=AXOzGZs6n8UDFAXS
 * @mem 26608KB
 * @time 193ms
 * @caution #조합
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */

public class SWEA_D3_9229_한빈이와SpotMart {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int T,N,M, snack[], result[], sum, max;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			tokens = new StringTokenizer(input.readLine());
			snack = new int[N];
			result = new int[2];
			for(int i=0; i<N; i++) {
				snack[i] = Integer.parseInt(tokens.nextToken());
//				System.out.print(snack[i]+" ");
			}
//			System.out.println();
			combination(0,0);
			if(max == 0) {
				output.append("-1");
			}else {
				output.append(max);
			}
			System.out.printf("#%d %s\n",t,output);
			output.setLength(0);
			max = 0;
		}
	}
	private static void combination(int start, int cnt) {
		if(cnt == 2) {
			for(int i=0; i<2; i++) {
				sum += result[i];
			}
			if(sum<=M && sum>max) {
				max = sum;
			}
			sum=0;
			return;
		}
		for(int i=start; i<N; i++) {
			result[cnt] = snack[i];
			combination(i+1, cnt+1);
		}
	}
//	static String src = "4\r\n" + 
//			"3 45\r\n" + 
//			"20 20 20\r\n" + 
//			"6 10\r\n" + 
//			"1 2 5 8 9 11\r\n" + 
//			"4 100\r\n" + 
//			"80 80 60 60\r\n" + 
//			"4 20\r\n" + 
//			"10 5 10 16";

}

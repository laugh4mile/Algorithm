package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2020. 8. 2
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AWT-lPB6dHUDFAVT&solveclubId=AXOJsQN67-MDFAXS&problemBoxTitle=0727&problemBoxCnt=2&probBoxId=AXOJsQN67-QDFAXS
 * @mem 21,108 kb
 * @time 1,011 ms
 * @caution #부분집합
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
public class SWEA_D3_5215_햄버거다이어트 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int T,N,L,max;
	static int[][] menu;
	static boolean[] isSelected;
	static int sumCal,sumTaste;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			max =0;
			
			StringTokenizer tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken()); //재료의 개수
			L = Integer.parseInt(tokens.nextToken()); // 제한 칼로리
			menu = new int[N][2];
			isSelected = new boolean[N];
			for(int c=0; c<N; c++) {
				StringTokenizer tokens2 = new StringTokenizer(input.readLine());
				menu[c][0] = Integer.parseInt(tokens2.nextToken()); // 맛 점수
				menu[c][1] = Integer.parseInt(tokens2.nextToken()); // 칼로리 점수
			}
			subSet(0);
			System.out.printf("#%d %d\n",testCase,max);
		}
	}
	
	public static void subSet(int cnt) {
		if(cnt == N) {
			sumCal = 0;
			sumTaste = 0;
			for(int i=0; i<N; i++) {
				if(isSelected[i]) {
					sumTaste += menu[i][0];
					sumCal += menu[i][1];
				}
			}
			if(sumCal<=L && max<sumTaste) {
				max = sumTaste;
			}
//			System.out.println(sumTaste +"  "+ sumCal+"  "+ max);
			
			return;
		}
		isSelected[cnt] = true;
		subSet(cnt+1);
		isSelected[cnt] = false;
		subSet(cnt+1);
	}
	
//	
//	static String src = "1\r\n" + 
//			"5 1000\r\n" + 
//			"100 200\r\n" + 
//			"300 500\r\n" + 
//			"250 300\r\n" + 
//			"500 1000\r\n" + 
//			"400 400";
	
	
//			"3 5\r\n" + 
//			"1 5\r\n" + 
//			"2 3\r\n" + 
//			"4 2";
}

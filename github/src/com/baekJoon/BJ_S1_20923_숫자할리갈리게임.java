package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S1_20923_숫자할리갈리게임 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		Deque<Integer> dodo = new LinkedList<>();
		Deque<Integer> suyun = new LinkedList<>();
		Deque<Integer> gD = new LinkedList<>();
		Deque<Integer> gS = new LinkedList<>();
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int d = Integer.parseInt(tokens.nextToken());
			int s = Integer.parseInt(tokens.nextToken());
			dodo.offerFirst(d);
			suyun.offerFirst(s);
		}
		System.out.println(getWinner(dodo,suyun,gD,gS,M));
		
	}

	private static String getWinner(Deque<Integer> dodo, Deque<Integer> suyun, Deque<Integer> gD, Deque<Integer> gS, int M) {
		while(M>0) {
			System.out.println(dodo);
			System.out.println(suyun);
			System.out.println();
//			System.out.println(gD);
//			System.out.println(gS);
//			System.out.println();
			// 1. 도도 턴
			if(!dodo.isEmpty()) {
				gD.offerFirst(dodo.pollFirst());
			}else { // 도도 패 다 털렸네?
				return "su";
			}
			// 2. 종 칠지 확인
			if(!gD.isEmpty() && !gS.isEmpty() && gD.peek() + gS.peek() == 5) { // 수연이가 종을 치는 경우
				while(!gD.isEmpty()) {
					suyun.offerLast(gD.poll());
				}
				while(!gS.isEmpty()) {
					suyun.offerLast(gS.poll());
				}
			}else if((!gD.isEmpty() && gD.peek() == 5) || (!gS.isEmpty() && gS.peek() == 5)) { // 도도가 종을 치는 경우
				while(!gS.isEmpty()) {
					dodo.offerLast(gS.poll());
				}
				while(!gD.isEmpty()) {
					dodo.offerLast(gD.poll());
				}
			}
			
			// 3. 수연 턴
			if(!suyun.isEmpty()) {
				gS.offerFirst(suyun.pollFirst());
			}else { // 수연이 패 다 털렸네?
				return "do";
			}
			
			// 4. 종 칠지 확인
			if(!gD.isEmpty() && !gS.isEmpty() && gD.peek() + gS.peek() == 5) { // 수연이가 종을 치는 경우
				while(!gD.isEmpty()) {
					suyun.offerLast(gD.poll());
				}
				while(!gS.isEmpty()) {
					suyun.offerLast(gS.poll());
				}
			}else if((!gD.isEmpty() && gD.peek() == 5) || (!gS.isEmpty() && gS.peek() == 5)) { // 도도가 종을 치는 경우
				while(!gS.isEmpty()) {
					dodo.offerLast(gS.poll());
				}
				while(!gD.isEmpty()) {
					dodo.offerLast(gD.poll());
				}
			}
			M--;
		}
		if(dodo.size() > suyun.size()) {
			return "do";
		}else if(dodo.size() == suyun.size()) {
			return "dosu";
		}else {
			return "su";
		}
	}

	static String src = 
			"3 4\r\n" + 
			"1 2\r\n" + 
			"2 2\r\n" + 
			"1 1";
}

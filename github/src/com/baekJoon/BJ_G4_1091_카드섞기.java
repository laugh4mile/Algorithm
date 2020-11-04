package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2020. 9. 2
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항] 카드 섞을 함수, 사이클 체크 함수, 일치확인 함수
 * [입력사항]
 * [출력사항]
 */

public class BJ_G4_1091_카드섞기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,P[],S[],cnt, card[], copy[], result, nc[];
	static boolean isNotEqualP,isNotCycle, fkflag, c8flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		P = new int[N];
		S = new int[N];
		card = new int[N];
		copy = new int[N];
		nc = new int[N];
		
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			P[i] = Integer.parseInt(tokens.nextToken());
		}
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<N; i++) {
			S[i] = Integer.parseInt(tokens.nextToken());
			card[i] = i;
		}
		copy = card.clone();
		
		
		if(checkMatch(card)) {
			System.out.println(0);
		}else {
			while(!c8flag || !fkflag) {
				shuffle(card);
			}
			
			if(c8flag) {
				System.out.println(cnt-2);
			}else {
				System.out.println(-1);
			}
		}
		
	}
	
	public static boolean checkCycle(int[] cd) {
        boolean flag = true;
        for (int i=0; i<N; i++) {
            if (copy[i] != cd[i]) {
                flag = false;
                break;
            }
        }
        fkflag = flag;
        return flag; // true면 사이클 있는거
    }
	public static boolean checkMatch(int[] cd) {
		boolean flag2 = true;
		for(int i=0; i<N; i++) {
			if(P[i] != cd[i]%3) {
				flag2 = false;
				break;
			}
		}
		c8flag = flag2;
		return flag2; // true 면 일치 
	}
	
	static void shuffle(int card[]) {
		cnt++;
				
		for (int i=0; i<N; i++)
		{
			nc[S[i]] = card[i];
		}
		for (int i = 0; i < N; i++)
		{
			card[i] = nc[i];
		}
		
		if(checkMatch(nc)) {
			return;
		}
		if(checkCycle(nc)) {
			return;
		}
	}
	
	static String src = 
			"48\r\n" + 
			"1 0 1 2 0 1 2 0 1 2 0 0 2 0 1 2 1 1 2 0 1 2 0 0 2 0 1 2 0 1 2 0 1 2 1 1 2 0 1 2 0 1 2 0 1 2 0 2\r\n" + 
			"1 2 3 4 5 6 7 0 9 10 8 12 13 14 15 11 17 18 19 20 21 22 16 24 25 26 27 28 29 30 31 32 33 23 35 36 37 38 39 40 41 42 43 44 45 46 34 47\r\n" + 
			"";
}
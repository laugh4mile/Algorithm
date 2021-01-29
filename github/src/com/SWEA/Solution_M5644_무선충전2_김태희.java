package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
메모리 :22,900 kb 
실행시간 : 141 ms
 */
/**
 * @author taeheekim
 */
public class Solution_M5644_무선충전2_김태희 {

	static int M,aCnt;
	static int[] pathA, pathB, playerA, playerB, ap[];
	static int[] dx = {0,0,1,0,-1};// 그대로, 상우하좌
	static int[] dy = {0,-1,0,1,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		playerA = new int[2];
		playerB = new int[2];
		
		for(int t=1; t<=TC; ++t) {
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			aCnt = Integer.parseInt(st.nextToken());
			
			playerA[0] = playerA[1] = 1;
			playerB[0] = playerB[1] = 10;
			
			pathA = new int[M+1];
			pathB = new int[M+1];
			ap = new int[aCnt][4];
			
			String[] charsA = in.readLine().split(" ");
			String[] charsB = in.readLine().split(" ");
			for(int c=0; c<M; ++c) {
				pathA[c+1] = charsA[c].charAt(0)-'0'; 
				pathB[c+1] = charsB[c].charAt(0)-'0'; 
			}
			
			for(int a=0; a<aCnt; ++a) {
				st = new StringTokenizer(in.readLine());
				ap[a][0] = Integer.parseInt(st.nextToken()); //x
				ap[a][1] = Integer.parseInt(st.nextToken()); //y
				ap[a][2] = Integer.parseInt(st.nextToken()); //c
				ap[a][3] = Integer.parseInt(st.nextToken()); //p
			}
			System.out.println("#"+t+" "+move());
		}
	}

	static int move() {
		ArrayList<Integer> apListA, apListB; 
		int totalSum = 0;
		int time = 0;
		 while (time<=M){
			// 두 플레이어 위치 이동
			playerA[0] += dx[pathA[time]];
			playerA[1] += dy[pathA[time]];
			playerB[0] += dx[pathB[time]];
			playerB[1] += dy[pathB[time]];
				
			// 현 위치에서 가능한 두 플레이어의 ap 리스트 찾기
			apListA= getAp(playerA[0],playerA[1]);
			apListB= getAp(playerB[0],playerB[1]);			
			
			// 두 플레이어의 위치가 같아 AP리스트가 같아도 두 플레이어가 각각 충전하면 더 합이 커질 수 있으므로 조합을 따져봐야한다.
			// 100, 90  충전소라면  playerA:100, playerB : 90에서 각각 충전하면 됨
			// 두 플레이어의 가능한 ap리스트의 조합으로 최대 충전량 구하기
			totalSum += getCombinationMaxPower(apListA,apListB);
			time++;
		}
		return totalSum;
	}

	private static int getCombinationMaxPower(ArrayList<Integer> apListA, ArrayList<Integer> apListB) {
		int max  = 0,temp = 0;
		int aSize = apListA.size(), bSize = apListB.size();
		
		if(aSize == 0 && bSize == 0) return 0;
		else if(aSize==0) return getMaxPower(apListB);
		else if(bSize==0) return getMaxPower(apListA);
		
		for (Integer a : apListA) {
			for (Integer b : apListB) {
				temp = Math.max(ap[a][3],ap[b][3]);	
				if(a != b) temp += Math.min(ap[a][3], ap[b][3]);
				max = Math.max(max,temp);
			}
		}
		return max;
	}

	static int getMaxPower(ArrayList<Integer> apList) {
		int max = 0;
		for (Integer a : apList) {
			if(ap[a][3]>max) max = ap[a][3];
		}
		return max;
	}
	
	static ArrayList<Integer> getAp(int x, int y){
		ArrayList<Integer> apList = new ArrayList<Integer>();
		int d=0;
		for(int a=0; a<aCnt; ++a) {
			d = Math.abs(ap[a][0]-x)+Math.abs(ap[a][1]-y);
			if(d<=ap[a][2])	apList.add(a);
		}
		return apList;
	}
}

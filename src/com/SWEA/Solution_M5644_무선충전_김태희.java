package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author taeheekim
 */
public class Solution_M5644_무선충전_김태희 {

	static int M,aCnt;
	static int[] pathA, pathB, players[], ap[];
	// rc 아닌 x축,y축으로.. // 그대로, 상우하좌
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,-1,0,1,0};	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		players = new int[2][2];
		
		for(int t=1; t<=TC; ++t) {
			st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken()); // 총 이동시간 
			aCnt = Integer.parseInt(st.nextToken()); // BC 개수 
			
			players[0][0] = players[0][1] = 1; // 1,1 위치 
			players[1][0] = players[1][1] = 10; // 10,10 위치 
			
			pathA = new int[M+1];
			pathB = new int[M+1];
			ap = new int[aCnt][4];
			 
			String[] charsA = in.readLine().split(" ");
			String[] charsB = in.readLine().split(" ");
			for(int c=0; c<M; ++c) {
				pathA[c+1] = charsA[c].charAt(0)-'0'; 
				pathB[c+1] = charsB[c].charAt(0)-'0'; 
			}
			
			// AP 의 정보 (4, 4),1, 100 : 좌표, 충전범위, 성능 
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

	// 매 시간마다의 두 사용자의 최대 충전량의 합을 구하여 모두 더함.
	static int move() {
		int totalSum = 0;
		for(int time=0; time<=M; ++time){ // 처음 있는 자리부터 처리해야하므로 시간은 0부터 
			// 두 플레이어 위치 이동
			players[0][0] += dx[pathA[time]];
			players[0][1] += dy[pathA[time]];
			players[1][0] += dx[pathB[time]];
			players[1][1] += dy[pathB[time]];
			
			totalSum += getCharge();
		}
		
		return totalSum;
	}
	// 중복 순열 
	static int getCharge() {
		int max = 0;
		for(int a=0; a<aCnt; ++a) {
			for (int b = 0;  b< aCnt; ++b) {
				int sum = 0;
				int aSum = check(a,players[0][0],players[0][1]);
				int bSum = check(b,players[1][0],players[1][1]);
				if(a != b) {
					sum = aSum + bSum;
				}else {
					//같은 충전소에 둘다 충전이 가능하면 충전량이 같으니 둘 중 아무거나 충전량으로 사용하고
					//같은 충전소에 한쪽만 충전이 가능하면 하나는 0,다른 하나는 0이 아닌 값이므로 
					//결국, 최대값으로 사용하면 됨.
					sum = Math.max(aSum, bSum);
				}
				if(max<sum) max = sum;
			}
		}
		return max;
	}
	static int check(int a, int x, int y) {
		return Math.abs(ap[a][0]-x)+Math.abs(ap[a][1]-y) <= ap[a][2] ? ap[a][3] : 0;
	}
}

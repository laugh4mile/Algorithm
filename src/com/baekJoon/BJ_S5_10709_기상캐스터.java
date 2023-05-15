package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S5_10709_기상캐스터 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int H = Integer.parseInt(tokens.nextToken());
		int W = Integer.parseInt(tokens.nextToken());
		int map[][] = new int[H][W];
		for(int r=0; r<H; r++) {
			String line = input.readLine();
			for(int c=0; c<W; c++) {
				if(line.charAt(c) != 'c') {
					map[r][c] = 100;
				}
			}	
		}
		
		for(int r=0; r<H; r++) {
			for(int c=1; c<W; c++) {
				if(map[r][c] != 0 && map[r][c-1]+1 < map[r][c]) {
					map[r][c] = map[r][c-1]+1;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int r=0; r<H; r++) {
			for(int c=0; c<W; c++) {
				if(map[r][c] == 100) {
					sb.append(-1+" ");
				}else {
					sb.append(map[r][c]+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static String src =
			"6 8\r\n" + 
			".c......\r\n" + 
			"........\r\n" + 
			".ccc..c.\r\n" + 
			"....c...\r\n" + 
			"..c.cc..\r\n" + 
			"....c...";
}

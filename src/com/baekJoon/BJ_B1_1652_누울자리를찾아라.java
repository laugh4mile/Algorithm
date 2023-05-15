package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B1_1652_누울자리를찾아라 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static char map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new char[N][N];
		
		for(int r=0; r<N; r++) {
			String line = input.readLine();
			for(int c=0; c<N; c++) {
				map[r][c] = line.charAt(c);
			}	
		}
		int answer1 = 0;
		int answer2 = 0;
		for(int r=0; r<N; r++) {
			StringBuffer sb = new StringBuffer();
			for(int c=0; c<N; c++) {
				sb.append(map[r][c]);
			}
			String line = sb.toString();
			String lines[] = line.split("X");
			for(String l : lines) {
				if(l.length()>=2) {
					answer1++;
				}
			}
		}		
		for(int c=0; c<N; c++) {
			StringBuffer sb = new StringBuffer();
			for(int r=0; r<N; r++) {
				sb.append(map[r][c]);
			}
			String line = sb.toString();
			String lines[] = line.split("X");
			for(String l : lines) {
				if(l.length()>=2) {
					answer2++;
				}
			}
		}		
		System.out.println(answer1+" "+answer2);
	}

	static String src =
			"5\r\n" + 
			"....X\r\n" + 
			"..XX.\r\n" + 
			".....\r\n" + 
			".XX..\r\n" + 
			"X....";
}

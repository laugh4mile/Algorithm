package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G5_15961_회전초밥 {
	static int N,d,k,c,sushi[];
	static int isSelected[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		isSelected = new int[d + 1];
		sushi = new int[N];
		for (int i = 0; i < N; i++)
			sushi[i] = Integer.parseInt(br.readLine());
		
		System.out.println(search());
	}
	
	private static int search() {
		int total = 0, max = 0;
		for (int i = 0; i < k; i++) {
			if (isSelected[sushi[i]] == 0) total++;
			isSelected[sushi[i]]++;
		}
//		if (visit[c] == 0) total++;
		max = total;
		
		for (int i = 1; i < N; i++) {
			if (max <= total) {
				if (isSelected[c] == 0)
					max = total + 1;
				else
					max = total;
			}
			isSelected[sushi[i - 1]]--;
			if (isSelected[sushi[i - 1]] == 0) total--;
			
			if (isSelected[sushi[(i + k - 1) % N]] == 0) total++;
			isSelected[sushi[(i + k - 1) % N]]++;
			
		}
		return max;
	}

	static String src = 
			"8 50 4 7\r\n" + 
			"2\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"25\r\n" + 
			"7\r\n" + 
			"9\r\n" + 
			"7\r\n" + 
			"30";
}

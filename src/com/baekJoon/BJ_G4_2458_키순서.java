package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_2458_키순서 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static boolean isVisited[];
	static int N,M,cnt1,cnt2,answer;
	static List<Integer> graph1[], graph2[];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		
		graph1 = new List[N+1];
		graph2 = new List[N+1];
		isVisited = new boolean[N+1];
		for(int n=1; n<=N; n++) {
			graph1[n] = new ArrayList<>();
			graph2[n] = new ArrayList<>();
		}
		
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			
			int a = Integer.parseInt(tokens.nextToken());
			int b = Integer.parseInt(tokens.nextToken());
			
			graph1[a].add(b);
			graph2[b].add(a); 
			
		}
//		for(int i=1; i<=N; i++) {
//			System.out.println(graph1[i]);
//		}
//		System.out.println();
//		for(int i=1; i<=N; i++) {
//			System.out.println(graph2[i]);
//		}
		for(int i=1; i<=N; i++) {
			int result = 0;
			
			dfs1(i);
			Arrays.fill(isVisited, false);
			dfs2(i);
			Arrays.fill(isVisited, false);
//			System.out.println(cnt1 + " " + cnt2);
			result = cnt1 + cnt2;
			
			if(result == N+1) {
				answer++;
			}
			
			cnt1 = 0;
			cnt2 = 0;
			result = 0;
		}
		System.out.println(answer);
	}
	private static void dfs1(int cnt) {
		cnt1++;
		List<Integer> childs = graph1[cnt];
		for(int i=0; i<childs.size(); i++) {
			Integer child = childs.get(i);
			if(!isVisited[child]) {
				isVisited[child] = true;
				dfs1(child);
			}
		}
	}
	private static void dfs2(int cnt) {
		cnt2++;
		List<Integer> childs = graph2[cnt];
		for(int i=0; i<childs.size(); i++) {
			Integer child = childs.get(i);
			if(!isVisited[child]) {
				isVisited[child] = true;
				dfs2(child);
			}
		}
	}
	static String src =
			"6 6\r\n" + 
			"1 5\r\n" + 
			"3 4\r\n" + 
			"5 4\r\n" + 
			"4 2\r\n" + 
			"4 6\r\n" + 
			"5 2";
}

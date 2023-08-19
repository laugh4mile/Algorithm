package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
/**
 * @author yhs
 * @date 2020. 12. 3
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 1) 경로의 길이는 경로 상에 등장하는 정점의 개수
 * [입력사항]
 * [출력사항]
 */
public class SWEA_D3_2814_최장경로 {

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,M,arr[], max = Integer.MIN_VALUE;
	static boolean isVisited[];
	static List<Integer> graph[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			graph = new List[N+1];
			isVisited = new boolean[N+1];
			for(int i=1; i<N+1; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			for(int m=0; m<M; m++) {
				tokens = new StringTokenizer(input.readLine());
				int from = Integer.parseInt(tokens.nextToken());
				int to = Integer.parseInt(tokens.nextToken());
				graph[from].add(to);
				graph[to].add(from);
			}
			
			for(int i=1; i<N+1; i++) {
				isVisited[i] = true;
				dfs(i,1);
				isVisited[i] = false;
			}
			
			System.out.println("#"+t+" "+max);
//			System.out.println(Arrays.toString(isVisited));
			max = Integer.MIN_VALUE;
		}
	}

	private static void dfs(int start, int cnt) {
		if(cnt > max) {
			max = cnt;
		}
		List<Integer> childs = graph[start];
		for(int i=0; i<childs.size(); i++) {
			Integer child = childs.get(i);
			if(!isVisited[child]) {
				isVisited[child] = true;
				dfs(child,cnt+1);
				isVisited[child] = false;
			}
		}
	}

	static String src =
			"2\r\n" + 
			"1 0\r\n" + 
			"3 2\r\n" + 
			"1 2\r\n" + 
			"3 2"; 
}
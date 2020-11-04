package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_5014_스타트링크 {
	static BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int F, S, G, U, D, el[],cnt[];
	static boolean isVisited[];
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader (src));
		tokens = new StringTokenizer(input.readLine());
		F = Integer.parseInt(tokens.nextToken());
		S = Integer.parseInt(tokens.nextToken());
		G = Integer.parseInt(tokens.nextToken());
		U = Integer.parseInt(tokens.nextToken());
		D = Integer.parseInt(tokens.nextToken());
		
		el = new int[F+1];
		cnt = new int[F+1];
		isVisited = new boolean[F+1];
		isVisited[0] = true;
		Arrays.fill(el, -1);
		el[S] = 0;
		el[G] = -2;

		
		if(S == G) {
			System.out.println(0);
		}
		else {
			bfs(S);
			if(cnt[G]==0) {
				System.out.println("use the stairs");
			}else {
				System.out.println(cnt[G]);
			}
		}
		
		
		
	}
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		isVisited[start] = true;
//		System.out.println(start);
		
		while(!queue.isEmpty()) {
			
			int front = queue.poll();
			int []ud = {U,-D};
			for(int i=0; i<2; i++) {
				int np = front + ud[i];
				if(isIn(np) && !isVisited[np] ) {
					
					cnt[np] = cnt[front]+1;
					queue.offer(np);
					isVisited[np] = true;
				}
			}
		}
	}
	static boolean isIn(int p) {
		return (p>=1 && p<F+1);
	}
	static String src = "100 2 1 1 0";

}

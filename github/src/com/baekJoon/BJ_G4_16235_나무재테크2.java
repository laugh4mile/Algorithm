package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_16235_나무재테크2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K,map[][], add[][]; // map 은 양분이다.
	static List<Tree> list = new ArrayList<>();
	static PriorityQueue<Tree> queue = new PriorityQueue<>();
	static Queue<Tree> temp = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map = new int[N][N];
		add = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = 5; //가장 처음에 양분은 모든 칸에 5만큼 들어있다.
			}	
		}
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				add[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		for(int m=0; m<M; m++) {
			tokens = new StringTokenizer(input.readLine());
			int r = Integer.parseInt(tokens.nextToken())-1;
			int c = Integer.parseInt(tokens.nextToken())-1;
			int age = Integer.parseInt(tokens.nextToken());
			list.add(new Tree(r, c, age, true));
			queue.offer(new Tree(r, c, age, true));
		} // 입력 끝
		
		while(K-- > 0) {
			spring();
			summer();
			if(queue.isEmpty()) break;
			fall();
			winter();
		}
		System.out.println(queue.size());
	}
	private static void spring() {
		while(!queue.isEmpty()) {
			Tree tree = queue.poll();
			if(map[tree.r][tree.c] < tree.age) { // 자기 나이보다 양분이 적을 경우
				tree.isAlive = false; // 나무 쥬금 ㅜㅜ
			}else { // 안죽을 경우 자기 나이 만큼 양분이 사라지고 나이가 증가한다.
				map[tree.r][tree.c] = map[tree.r][tree.c] - tree.age;
				tree.age++;
			}
			temp.offer(tree);
		}
		while(!temp.isEmpty()) {
			queue.offer(temp.poll());
		}
	}
	private static void summer() {
		while(!queue.isEmpty()) {
			Tree tree = queue.poll();
			if(!tree.isAlive) { // 죽은 나무일 경우 나이의 절반이 양분으로 변함
				map[tree.r][tree.c] = map[tree.r][tree.c] + tree.age/2; 
			}else {
				temp.offer(tree);
			}
		}
		while(!temp.isEmpty()) {
			queue.offer(temp.poll());
		}
	}
	
	private static void fall() {
		while(!queue.isEmpty()) {
			Tree tree = queue.poll();
			if(tree.age % 5 == 0) { // 5의 배수일 경우 새끼 깜
				for(int d=0; d<8; d++) {
					int nr = tree.r + dr[d];
					int nc = tree.c + dc[d];
					if(isIn(nr, nc)) {
						temp.offer(new Tree(nr, nc, 1, true));
					}
				}
			}
			temp.offer(tree);
		}
		while(!temp.isEmpty()) {
			queue.offer(temp.poll());
		}
	}
	private static void winter() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] += add[r][c];
			}	
		}
	}
	static int dr[] = {-1,-1,-1,0,0,1,1,1};
	static int dc[] = {-1,0,1,-1,1,-1,0,1};
	static boolean isIn(int r, int c) {
		return (r>=0 && c>=0 && r<N && c<N);
	}
	static class Tree implements Comparable<Tree>{
		int r;
		int c;
		int age;
		boolean isAlive;

		public Tree(int r, int c, int age, boolean isAlive) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
			this.isAlive = isAlive;
		}
		@Override
		public String toString() {
			return "Tree [r=" + r + ", c=" + c + ", age=" + age + ", isAlive=" + isAlive + "]";
		}

		@Override
		public int compareTo(Tree o) {
			return Integer.compare(this.age, o.age);
		}
	}
	static String src =
			"5 2 6\r\n"
			+ "2 3 2 3 2\r\n"
			+ "2 3 2 3 2\r\n"
			+ "2 3 2 3 2\r\n"
			+ "2 3 2 3 2\r\n"
			+ "2 3 2 3 2\r\n"
			+ "2 1 3\r\n"
			+ "3 2 3";
}

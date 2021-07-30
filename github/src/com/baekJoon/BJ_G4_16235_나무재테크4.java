package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_16235_나무재테크4 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,M,K,map[][], add[][], dead[][]; // map 은 양분이다.
	static List<Tree> list = new LinkedList<>();
	static List<Tree> temp = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		map = new int[N][N];
		add = new int[N][N];
		dead = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = 5; //가장 처음에 양분은 모든 칸에 5만큼 들어있다.
			}	
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
			list.add(new Tree(r, c, age));
		} // 입력 끝
		Collections.sort(list); // 어린 나무순으로 정렬
		
		while(K-- > 0) {
			springAndfall();
			summerAndwinter();
			if(list.size() == 0) break;
		}
		System.out.println(list.size());
	}
	private static void springAndfall() {
		Tree tree;
		for(Iterator<Tree> iter = list.iterator(); iter.hasNext();) {
			tree = iter.next();
			int r = tree.r;
			int c = tree.c;
			int age = tree.age;
			
			if(map[r][c] < age) { // 자기 나이보다 양분이 적을 경우
				dead[r][c] += age/2; // 쥬금 + 더해질 양분 기억
				iter.remove(); // 해당 list의 데이터도 삭제된다.
			}else { // 안 죽을 경우 양분이 빨리고 나이가 증가한다.
				map[r][c] -= age;
				tree.age++;
				if(tree.age%5 == 0) {
					for(int d=0; d<8; d++) {
						int nr = r + dr[d];
						int nc = c + dc[d];
						if(isIn(nr, nc)) {
							temp.add(0, new Tree(nr, nc, 1));
						}
					}
				}
			}
			
		}
		list.addAll(0, temp);
		temp.clear();
	}
	private static void summerAndwinter() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] += dead[r][c];
				map[r][c] += add[r][c];
				dead[r][c] = 0;
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

		public Tree(int r, int c, int age) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Tree [r=" + r + ", c=" + c + ", age=" + age + "]";
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

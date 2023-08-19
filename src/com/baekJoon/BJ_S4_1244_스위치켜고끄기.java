package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_S4_1244_스위치켜고끄기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K, map[];
	static Queue<Student> queue = new LinkedList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		map = new int[N];
		tokens = new StringTokenizer(input.readLine());
		for(int n=0; n<N; n++) {
			map[n] = Integer.parseInt(tokens.nextToken());
		}
//		System.out.println(Arrays.toString(map));
		K = Integer.parseInt(input.readLine());
		for(int k=0; k<K; k++) {
			tokens = new StringTokenizer(input.readLine());
			int gender = Integer.parseInt(tokens.nextToken());
			int num = Integer.parseInt(tokens.nextToken());
			queue.offer(new Student(gender, num));
		}
		solve();
		for(int n=0; n<N; n++) {
			System.out.print(map[n]+" ");
			if((n+1)%20 == 0) System.out.println();
		}
		// 주의사항
	}
	
	private static void solve() {
		while(!queue.isEmpty()) {
			Student front = queue.poll();
			if(front.gender == 1) { // 남학생
				int num = front.num;
				for(int i=0; i<N; i++) {
					if((i+1)%num == 0) {
						if(map[i] == 0) {
							map[i] = 1;
						}else {
							map[i] = 0;
						}
					}
				}
			}
			else { // 여학생
				int num = front.num-1;
				int nl = num;
				int nr = num;
				if(map[num] == 0) {
					map[num] = 1;
				}else {
					map[num] = 0;
				}
				for(int i=0; i<N/2; i++) {
					if(isIn(--nl) && isIn(++nr) && map[nl] == map[nr]) {
						if(map[nl] == 0) {
							map[nl] = 1;
							map[nr] = 1;
						}else {
							map[nl] = 0;
							map[nr] = 0;
						}
						
					}else {
						break;
					}
				}
			}
		}
	}
	static boolean isIn(int n){
		return (n>=0 && n<N);
	}
	static class Student{
		int gender;
		int num;
		public Student(int gender, int num) {
			super();
			this.gender = gender;
			this.num = num;
		}
		@Override
		public String toString() {
			return "Student [gender=" + gender + ", num=" + num + "]";
		}
	}
	
	static String src =
			"21\r\n" + 
			"0 1 0 1 0 0 0 1 1 0 1 0 1 0 1 0 1 0 1 1 0\r\n" + 
			"2\r\n" + 
			"1 3\r\n" + 
			"2 3";
}

package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S2_1713_후보추천하기2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		int recommend = Integer.parseInt(input.readLine());
		int vote[] = new int [recommend];
		tokens = new StringTokenizer(input.readLine());
		for(int i=0; i<recommend; i++) {
			vote[i] = Integer.parseInt(tokens.nextToken());
		}
		solution(N, recommend, vote);
	}

	private static void solution(int N, int recommend, int vote[]) {
		int student[] = new int[101];
		List<Node> list = new ArrayList<>();
		for(int i=0; i<recommend; i++) {
			if(student[vote[i]] != 0) {
				student[vote[i]]++;
				for(int j=0; j<list.size(); j++) {
					if(list.get(j).student == vote[i]) {
						list.get(j).count++;
						break;
					}
				}
			}else {
				student[vote[i]]++;
				if(list.size() >= N) {
					Collections.sort(list);
					student[list.get(0).student] = 0;
					list.remove(0);
					list.add(new Node(i, vote[i], 1));
				}else {
					list.add(new Node(i, vote[i], 1));
				}
			}
		}
		for(int i=0; i<student.length; i++) {
			if(student[i]!=0) {
				System.out.print(i+" ");
			}
		}
	}
	
	static class Node implements Comparable<Node>{
		int no;
		int student;
		int count;
		
		public Node(int no, int student, int count) {
			super();
			this.no = no;
			this.student = student;
			this.count = count;
		}
		@Override
		public int compareTo(Node o) {
			if(this.count == o.count) {
				return Integer.compare(this.no, o.no);
			}
			return Integer.compare(this.count, o.count);
		}
		@Override
		public String toString() {
			return "Node [no=" + no + ", student=" + student + ", count=" + count + "]";
		}
		
	}

	static String src =
			"3\r\n"
			+ "14\r\n"
			+ "2 1 4 3 5 6 2 7 2 100 100 54 54 50";
}

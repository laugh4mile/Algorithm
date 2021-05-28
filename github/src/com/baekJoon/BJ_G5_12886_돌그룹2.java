package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import com.baekJoon.BJ_G5_12886_돌그룹2.Node;

public class BJ_G5_12886_돌그룹2 { 
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static boolean isVisited[][] = new boolean[1501][1501];
	static boolean answer;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		int a = Integer.parseInt(tokens.nextToken());
		int b = Integer.parseInt(tokens.nextToken());
		int c = Integer.parseInt(tokens.nextToken());
		sum = a+b+c;
		
		bfs(a,b,c);
		if(answer) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
	private static void bfs(int first, int mid, int last) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(first, mid, last));
		isVisited[queue.peek().first][queue.peek().last] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			System.out.println(front);
			if(front.first == front.last) {
				answer = true;
				break;
			}
			
			if(!isVisited[front.first*2][front.mid-front.first]) {
				isVisited[front.first*2][front.mid-front.first] = true;
				queue.offer(new Node(front.first*2, front.mid-front.first, front.last));
			}
			if(!isVisited[front.first*2][front.last-front.first]) {
				isVisited[front.first*2][front.last-front.first] = true;
				queue.offer(new Node(front.first*2, front.mid, front.last-front.first));
			}
			if(!isVisited[front.mid*2][front.last-front.mid]) {
				isVisited[front.mid*2][front.last-front.mid] = true;
				queue.offer(new Node(front.first, front.mid*2, front.last-front.mid));
			}
		}
	}
	
	static class Node {
		int first;
		int mid;
		int last;
		
		public Node(int first, int mid, int last) {
			super();
			if(first<mid) {
				if(mid<last) {
					this.first = first;
					this.mid = mid;
					this.last = last;
				}else {
					if(first < last) {
						this.first = first;
						this.mid = last;
						this.last = mid;
					}else {
						this.first = last;
						this.mid = first;
						this.last = mid;
					}
				}
			}else {
				if(first<last) {
					this.first = mid;
					this.mid = first;
					this.last = last;
				}else {
					if(mid<last) {
						this.first = mid;
						this.mid = last;
						this.last = first;
					}else {
						this.first = last;
						this.mid = mid;
						this.last = first;
					}
				}
			}
		}
		@Override
		public String toString() {
			return "Node [first=" + first + ", mid=" + mid + ", last=" + last + "]";
		}
		
	}
	
	static boolean isIn(int a, int b, int c) {
		return(a>=0 && b>=0 && c>=0);
	}
	
	static String src =
			"1 1 2";
}













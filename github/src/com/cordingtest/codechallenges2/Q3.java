package com.cordingtest.codechallenges2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class Q3 {
	
	static int a[] = {-5,0,2,1,2};
	static int edges[][] = {{0,1},{3,4},{2,3},{0,3}};
	
	public static long solution(int[] a, int[][] edges) {
        long answer = 0;
        
        int sum = 0;
        for(int i=0; i<a.length; i++) {
        	sum += a[i];
        }
        
        if(sum != 0) return -1;
        return answer;
    }
	
	public static class Node{
		int to;
		int w;
		public Node(int to, int w) {
			super();
			this.to = to;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Node [to=" + to + ", w=" + w + "]";
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		solution(a, edges);
	}
	//포기
}

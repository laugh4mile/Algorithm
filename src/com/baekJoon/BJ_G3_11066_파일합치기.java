package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G3_11066_파일합치기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		char c = '1';
		System.out.println(Character.isDigit(c));
		Stack<Integer> st = new Stack<Integer>();
		st.push(123);
		st.push(st.peek());
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		System.out.println(st.isEmpty());
//		int T = Integer.parseInt(input.readLine());
//		for(int t=0; t<T; t++) {
//			int K = Integer.parseInt(input.readLine());
//			int[] arr = new int[K];
//			PriorityQueue<Integer> pq = new PriorityQueue<>();
//			tokens = new StringTokenizer(input.readLine());
//			Stack<Integer> st = new Stack<>();
//			
//			for(int k=0; k<K; k++) {
//				arr[k] = Integer.parseInt(tokens.nextToken());
//				pq.offer(arr[k]);
//			}
//			int sum = 0;
//			int cur = 0;
//			for(int i=0; i<K-1; i++) {
//				cur = pq.poll();
////				int front = pq.poll();
////				sum += front;
//				System.out.print(cur+" ");
//				cur += pq.poll();
//				sum += cur;
//				pq.offer(cur);
//				System.out.println(cur+"  "+sum);
//			}
//			System.out.println(sum);
//			System.out.println();
//			System.out.println();
//		}
	}

	static String src =
			"2\r\n" + 
			"4\r\n" + 
			"40 30 30 50\r\n" + 
			"15\r\n" + 
			"1 21 3 4 5 35 5 4 3 5 98 21 14 17 32";
}

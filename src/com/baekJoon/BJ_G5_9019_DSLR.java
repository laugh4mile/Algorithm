package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G5_9019_DSLR {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int T;
	static boolean isVisited[];
	static String A, B, result[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			isVisited = new boolean[10000];
			result = new String[10000];
			A = tokens.nextToken();
			B = tokens.nextToken();
			A = fix(A);
			B = fix(B);

			bfs(A);
//			System.out.println(result[Integer.parseInt(B)]);
			output.append(result[Integer.parseInt(B)] + "\n");
		}
		output.close();
	}
	
	private static void bfs(String n) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(n);
		isVisited[Integer.parseInt(n)] = true;
		result[Integer.parseInt(n)] = "";
		
		while(!queue.isEmpty()) {
			String front = queue.poll();
			if(front.equals(B)) {
				break;
			}
			for(int d=0; d<4; d++) {
				if(d == 0) {
					if(!isVisited[Integer.parseInt(D(front))]) {
						queue.offer(D(front));
						isVisited[Integer.parseInt(D(front))] = true;
						result[Integer.parseInt(D(front))] = result[Integer.parseInt(front)] + "D";
					}
				}else if(d == 1) {
					if(!isVisited[Integer.parseInt(S(front))]) {
						queue.offer(S(front));
						isVisited[Integer.parseInt(S(front))] = true;
						result[Integer.parseInt(S(front))] = result[Integer.parseInt(front)] + "S";
					}
				}else if(d == 2) {
					if(!isVisited[Integer.parseInt(L(front))]) {
						queue.offer(L(front));
						isVisited[Integer.parseInt(L(front))] = true;
						result[Integer.parseInt(L(front))] = result[Integer.parseInt(front)] + "L";
					}
				}else {
					if(!isVisited[Integer.parseInt(R(front))]) {
						queue.offer(R(front));
						isVisited[Integer.parseInt(R(front))] = true;
						result[Integer.parseInt(R(front))] = result[Integer.parseInt(front)] + "R";
					}
				}
			}
		}
	}
	
	static String D (String n){
		int temp = Integer.parseInt(n);
		temp = (temp * 2) % 10000;
		
		String result = Integer.toString(temp);
		result = fix(result);
		return result;
	}

	static String S (String n){
		int temp = Integer.parseInt(n);
		temp = temp - 1;
		if(temp == -1) {
			temp = 9999;
		}
		
		String result = Integer.toString(temp);
		result = fix(result);
		return result;
	}
	
	static String L (String n){
		String result = fix(n);
		result = result.substring(1, 4) + result.substring(0, 1);
		return result;
	}
	
	static String R (String n){
		String result = fix(n);
		result = result.substring(3, 4) + result.substring(0, 3);
		return result;
	}

	private static String fix(String result) {
		if(result.length() < 4) {
			String zeros = "";
			for(int i=0; i<4-result.length(); i++) {
				zeros = zeros + "0";
			}
			result = zeros.concat(result);
		}
		return result;
	}
	
	static String src =
			"3\r\n" + 
			"1234 3412\r\n" + 
			"1000 1\r\n" + 
			"1 16";
}
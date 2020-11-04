package com.baekJoon;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2020. 8. 3
 * @see https://www.acmicpc.net/problem/1158
 * @mem 97MB
 * @time 1080ms
 * @caution #큐
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */

public class BJ_S5_1158_요세푸스문제 {
	static BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
	static int N,K;
	static Queue<Integer> list = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
//		input = new BufferedReader(new StringReader(src));
		StringTokenizer tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
//		System.out.println(N);
//		System.out.println(K);
		for(int i=1; i<=N; i++) {
			list.offer(i);
		}
		System.out.print("<");
		while(true) {
			for(int i=0; i<K-1; i++) {
				list.offer(list.poll());
			}
			System.out.print(list.poll());
			if(list.isEmpty()) {
				break;
			}
			System.out.print(", ");
		}
		System.out.print(">");
//		System.out.println(list.toString());;
		
		
	}
//	static String src = "7 3";

}

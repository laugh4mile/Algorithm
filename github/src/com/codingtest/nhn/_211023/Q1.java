package com.codingtest.nhn._211023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q1 {
	static int copy[][];
	public static void main(String[] args) {
		int[][] arr = {{0},{0,1,2},{0,1}};
		copy = arr.clone();
		bfs();
		List<Node> list = new ArrayList<>();
		list.add(new Node(0, Type.m));
		System.out.println(list);
//		String str = "zzz";
//		if(str.equals("zzz")) {
//			System.out.println("Zz");
//		}
		if(list.get(0).type == Type.m) {
			System.out.println("맞냐");
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(2);
		pq.offer(1);
		pq.offer(4);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(list.getClass().getName());
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<10; i++) {
			sb.append(i+" ");
		}
		System.out.println(sb);
	}
	
	private static void bfs() {
		// TODO Auto-generated method stub
		for(int x[] : copy) {
			System.out.println(Arrays.toString(x));
		}
	}

	static class Node{
		int num;
		Type type;
		public Node(int num, Type type) {
			super();
			this.num = num;
			this.type = type;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", type=" + type + "]";
		}
		
	}
	
	static enum Type{
		b,
		m;
	}
}

package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AAA {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static List<Integer> list = new ArrayList<>();
	static List<Integer> list2 = new ArrayList<>();
	static List<String> list3 = new ArrayList<>();
	static List<String> list4 = new ArrayList<>();
	static List<Node> list5 = new ArrayList<>();
	static List<Node> list6 = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		setList();
		setList2();
		setList3();
//		iterPractice();
		copyList();
		copyList2();
		copyList3();
		changeCopyList();
		changeCopyList2();
		changeCopyList3();
		printList();
		printList2();
		printList3();
	}
	
	//
	private static void setList() {
		for(int i=0; i<5; i++) {
			list.add(i);
		}
	}
	private static void setList2() {
		for(int i=0; i<5; i++) {
			list3.add(Integer.toString(i));
		}
	}
	private static void setList3() {
		for(int i=0; i<3; i++) {
			list5.add(new Node(i, i, i, false));
		}
	}
	//
	private static void copyList() {
		list2.addAll(list);
	}
	private static void copyList2() {
		list4.addAll(list3);
	}
	private static void copyList3() {
//		list6.addAll(list5);
		for(int i=0; i<list5.size(); i++) {
			Node front = list5.get(i);
			list6.add(new Node(front));
		}
//		list6 = new ArrayList<>(list5);
//		list6 = list5;
	}
	//
	private static void changeCopyList() {
		list2.add(5);
		list2.set(3, 33);
		list2.remove(4);
	}
	private static void changeCopyList2() {
		list4.set(3, list.get(3)+"zz");
		list4.remove(4);
	}
	private static void changeCopyList3() {
		list6.get(2).flag = true;
//		list6.add(new Node(3,3,3,false));
//		list6.get(3).flag = true;
//		list6.remove(0);
	}
	
	//
	private static void printList() {
		System.out.println("원본 list");
		System.out.println(list);
		System.out.println("복사된 list2");
		System.out.println(list2);
		System.out.println();
	}
	private static void printList2() {
		System.out.println("원본 list3");
		System.out.println(list3);
		System.out.println("복사된 list4");
		System.out.println(list4);
		System.out.println();
	}
	private static void printList3() {
		System.out.println("원본 list5");
		System.out.println(list5);
		System.out.println("복사된 list6");
		System.out.println(list6);
		System.out.println();
	}
	
	static class Node{
		int r;
		int c;
		int d;
		boolean flag;
		public Node(int r, int c, int d, boolean flag) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
			this.flag = flag;
		}
		// 복사 생성자
	    public Node(Node node){
	    	this.r = node.r;
	        this.c = node.c;
	        this.d = node.d;
	        this.flag = node.flag;
	    }
		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + ", d=" + d + ", flag=" + flag + "]";
		}
	}
	static String src =

			"";
}

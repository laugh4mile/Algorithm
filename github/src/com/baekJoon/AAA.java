package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AAA {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static List<Integer> list = new ArrayList<Integer>();
	static List<Integer> list2 = new ArrayList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		setList();
//		iterPractice();
		copyList();
		changeCopyList();
		printList();
	}

	private static void setList() {
		for(int i=0; i<5; i++) {
			list.add(i);
		}
	}

	private static void changeCopyList() {
		list2.remove(4);
	}

	private static void copyList() {
		list2.addAll(list);
	}

	private static void iterPractice() {
		for(Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
			Integer num = iter.next();
			if(num == 3) {
				iter.remove();
				list2.add(0,  1);
			}
		}
	}

	private static void printList() {
		System.out.println("원본 list");
		System.out.println(list);
		System.out.println("복사된 list");
		System.out.println(list2);
	}

	static String src =

			"";
}

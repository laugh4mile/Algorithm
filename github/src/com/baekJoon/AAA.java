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
		for(int i=0; i<5; i++) {
			list.add(i);
		}
		for(Iterator<Integer> iter = list.iterator(); iter.hasNext();) {
			Integer tree = iter.next();
			System.out.println(tree);
			if(tree == 3) {
				iter.remove();
				list2.add(0,  1);
			}
		}
		System.out.println(list);
	}

	static String src =

			"";
}

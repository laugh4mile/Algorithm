package com.codingtest.bro.toss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class Q5_과일게임2 {
	static int k =3;
	static int fruitWeights[]= {50, 40, 10, 20, 30};
	// 1<=K<=N
	
	public static void main(String[] args) {
		solution(fruitWeights, k);
	}


	private static int[] solution(int[] fruitWeights, int k) {
		int [] answer;
		int N = fruitWeights.length;
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		List<Integer> list = new ArrayList<>();
		//
		for(int i=0; i<k; i++) {
			list.add(fruitWeights[i]);
		}
		set.add(Collections.max(list));
		for(int i=k; i<N; i++) {
			list.remove(0);
			list.add(fruitWeights[i]);
			set.add(Collections.max(list));
		}
		//
		int size = set.size();
		answer = new int[size];
		int cnt = 0;
		for(Iterator<Integer> iter = set.iterator(); iter.hasNext();) {
			answer[cnt++] = iter.next();
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
}

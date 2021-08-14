package com.codingtest.bro.toss;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class Q5_과일게임 {
	static int k =3;
	static int fruitWeights[]= {30, 40, 10, 20, 30};
	// 1<=K<=N
	
	public static void main(String[] args) {
		solution(fruitWeights, k);
	}


	private static int[] solution(int[] fruitWeights, int k) {
		int [] answer;
		int N = fruitWeights.length;
		TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		for(int i=0; i<=N-k; i++) {
			int max = 0;
			for(int j=0; j<k; j++) {
				if(fruitWeights[i+j] > max) {
					max = fruitWeights[i+j];
				}
			}
			set.add(max);
		}
		int size = set.size();
		answer = new int[size];
		int cnt = 0;
		for(Iterator<Integer> iter = set.iterator(); iter.hasNext();) {
			answer[cnt++] = iter.next();
		}
		return answer;
	}
}

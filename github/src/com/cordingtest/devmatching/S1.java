package com.cordingtest.devmatching;

import java.util.LinkedList;
import java.util.Queue;

public class S1 {
	
//	static int [] lot = {111, 0, 0, 0, 0, 0};
//	static int [] win = {38, 19, 20, 40, 15, 25};
	static int [] lot = {46, 6, 36, 26, 5, 8};
	static int [] win = {20, 9, 3, 45, 4, 35};
//	static int [] lot = {45, 4, 35, 20, 3, 9};
//	static int [] win = {20, 9, 3, 45, 4, 35};
//	static int [] lot = {44, 1, 0, 0, 31, 25};
//	static int [] win = {31, 10, 45, 1, 6, 19};
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeros = 0;
        int min = 0;
        int max = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<lottos.length; i++) {
        	queue.offer(lottos[i]);
        	if(lottos[i] == 0) {
        		zeros++;
        	}
        }
        
        for(int i=0; i< win_nums.length; i++) {
        	for(int j=0; j<queue.size(); j++) {
        		int front = queue.poll();
        		if(win_nums[i] == front) {
        			break;
        		}else {
        			queue.offer(front);
        		}
        	}
        }
        int matching = 6 - queue.size();
        min = matching;
        max = matching + zeros;
        
        int high = 0;
        int row = 0;
        high = rank(max);
        row = rank(min);
        System.out.println(high);
        System.out.println(row);
        
        return answer;
    }
	
	
	
	private static int rank(int count) {
		int re = 0;
		switch (count) {
		case 0:
			re = 6;
			break;
		case 1:
			re = 6;
			break;
		case 2:
			re = 5;
			break;
		case 3:
			re = 4;
			break;
		case 4:
			re = 3;
			break;
		case 5:
			re = 2;
			break;
		case 6:
			re = 1;
			break;
		}
		
	return re;
}



	public static void main(String[] args) {
		solution(lot, win);
	}
}

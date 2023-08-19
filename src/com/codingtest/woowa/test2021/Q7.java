package com.codingtest.woowa.test2021;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q7 {
//	static String[] grid = {"1","234","56789"};
//	static boolean clockwise = true;
	static String[] grid = {"A","MAN","DRINK","WATER11"};
	static boolean clockwise = false;
	public static void main(String[] args) {
		String[] answer = solution(grid, clockwise);
		System.out.println(Arrays.toString(answer));
	}
	
	public static String[] solution(String[] grid, boolean clockwise) {
        String[] answer = {};
        
        answer = getAnswer(grid);
        if(!clockwise) {
        	answer = getAnswer(answer);
        }
        
        
        
        return answer;
    }

	private static String[] getAnswer(String[] grid) {
		Queue<Character> queue[] = new Queue[grid.length*2-1];
		
		for(int i=0; i<queue.length; i++) {
			queue[i] = new LinkedList<>();
		}
		queue[0].add(grid[0].charAt(0));
		int cnt = 1;
		for(int i=1; i<grid.length; i++) {
			for(int j=0; j<grid[i].length(); j++) {
				if(j%2 != 0) { // 홀수번째일 경우 (1,3,5,...)
					queue[cnt].add(grid[i].charAt(j)); 
				}else { // 짝수번째일 경우 (0,2,4,...)
					queue[cnt+1].add(grid[i].charAt(j)); 
				}
			}
			cnt += 2;
		}
		for(int i=0; i<queue.length; i++) {
			System.out.println(queue[i]);
		}
		System.out.println();
		System.out.println();
		String[] answer = new String[grid.length];
		StringBuilder sb[] = new StringBuilder[grid.length];
		for(int i=0; i<sb.length; i++) {
			sb[i] = new StringBuilder();
		}
		
		for(int i=0; i<grid.length; i++) { // 배열의 크기
			int idx = queue.length-1;
			for(int j=0; j<i*2+1; j++) { // 뽑는개수. 1, 3, 5, .. i*2+1
				sb[i].append(queue[idx--].poll());
			}
		}
		
		for(int i=0; i<grid.length; i++) {
			answer[i] = sb[i].toString();
		}
		
		return answer;
	}
}

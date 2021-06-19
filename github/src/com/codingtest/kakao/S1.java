package com.codingtest.kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S1 {
	
	static int[] gift_cards = {5, 4, 5, 4, 3};
	static int[] wants = {1, 2, 3, 5, 4};
	
	public static int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<gift_cards.length; i++) {
        	queue.offer(gift_cards[i]);
        }
        for(int i=0; i<wants.length; i++) {
        	
        	int size = queue.size();
        	for(int j=0; j<size; j++) {
        		int front = queue.poll();
        		if(front == wants[i]) {
        			break;
        		}else {
        			queue.offer(front);
        		}
        	}
        }
        answer = queue.size();
        
        return answer;
    }
	
	public static void main(String[] args) {
		solution(gift_cards, wants);
	}
}

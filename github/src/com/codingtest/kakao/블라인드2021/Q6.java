package com.codingtest.kakao.블라인드2021;

public class Q6 {
	static int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
	static int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
	public static void main(String[] args) {
		int answer = solution(board, skill);
		System.out.println(answer);
	}
	public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        for(int t=0; t<skill.length; t++) {
        	if(skill[t][0] == 1) { // 공격
        		for(int r=skill[t][1]; r<=skill[t][3]; r++) {
        			for(int c=skill[t][2]; c<=skill[t][4]; c++) {
            			board[r][c] -= skill[t][5];
            		}	
        		}
        	}else { // 회복
        		for(int r=skill[t][1]; r<=skill[t][3]; r++) {
        			for(int c=skill[t][2]; c<=skill[t][4]; c++) {
        				board[r][c] += skill[t][5];
        			}	
        		}
        	}
        }
        
        for(int r=0; r<board.length; r++) {
        	for(int c=0; c<board[0].length; c++) {
            	if(board[r][c] > 0) {
            		answer++;
            	}
            }	
        }
        
        return answer;
    }
}

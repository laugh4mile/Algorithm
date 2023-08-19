package com.programmers;

import java.util.*;
class L2_프렌즈4블록_과거의나 {
  public int solution(int m, int n, String[] board) {
      String[][] tmp2;
      int answer = 0;
      int[][] tmp2int;
      int count = 0;

      tmp2 = Board_2D(board);
      tmp2int = Mapping(tmp2);
      tmp2int = DeleteBlock(tmp2int, count);
      answer = Zero(tmp2int);
      return answer;
  }
   public static int Zero(int[][] copy) {
		int m = copy.length;
		int n = copy[0].length;
		int zero = 0;
		
		for(int i=0 ; i < m ; i++) {
			for(int j=0 ; j < n ; j++) {
				if(copy[i][j]==0) {
					zero++;
				}
			}
		}
		return zero;
	}
	
	public static int[][] DeleteBlock(int[][] board, int count){ // 4개 블록이 모일경우 삭제한후 윗블록이 내려온후 뚫린영역에 0을 채움
		int m = board.length;
		int n = board[0].length;
		int[][] copy = new int[m][n];
		
		for(int i=0; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				copy[i][j] = board[i][j];
			}
		}
	
		for(int i=0; i < m-1 ; i++) {
			for(int j = 0 ; j < n-1 ; j++) {
				if(board[i][j] == board[i][j+1] && board[i][j] == board[i+1][j] && board[i][j] == board[i+1][j+1]) {// 4블록이 같다면 전부 0으로
					copy[i][j] = 0;
					copy[i][j+1] = 0;
					copy[i+1][j] = 0;
					copy[i+1][j+1] = 0;
				}
			}
		}
		
		for(int h = 0 ; h < n ; h++) {
			for(int i=m-1; i > 0 ; i--) {
				for(int j = n-1; j>=0 ; j--) {
					if(copy[i][j] == 0) {
						copy[i][j] = copy[i-1][j];
						copy[i-1][j] = 0;
					}
				}
			}			
		}
		count++;
		
		if(count == n/2) {
			return copy;
		}
		else {
			return DeleteBlock(copy, count);
		}
		
		
	}
	
	public static String[][] Board_2D(String[] board){ //board를 2차원 배열에 넣기
		int m = board.length; // m = 행
		int n = board[0].length(); // n = 열
		String[][] board2d = new String[m][n];
		
		for(int i = 0; i<m ; i++) {
			board2d[i] = board[i].split("");
		}
		return board2d;
	}
	
	public static int[][] Mapping(String[][] board){ // 문자 2차원 배열을 숫자로 매핑해주는 함수
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("A",1);
		map.put("B",2);
		map.put("C",3);
		map.put("D",4);
		map.put("E",5);
		map.put("F",6);
		map.put("G",7);
		map.put("H",8);
		map.put("I",9);
		map.put("J",10);
		map.put("K",11);
		map.put("L",12);
		map.put("M",13);
		map.put("N",14);
		map.put("O",15);
		map.put("P",16);
		map.put("Q",17);
		map.put("R",18);
		map.put("S",19);
		map.put("T",20);
		map.put("U",21);
		map.put("V",22);
		map.put("W",23);
		map.put("X",24);
		map.put("Y",25);
		map.put("Z",26);
		
		int m = board.length;
		int n = board[0].length;
		int[][] mapping = new int[m][n];
		
		for(int i=0; i < m ; i++) {
			for(int j = 0 ; j < n ; j++) {
				mapping[i][j] = map.get(board[i][j]);
			}
		}
		return mapping;
	} 
}
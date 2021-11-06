package com.codingtest.woowa.test2021;

import java.util.Arrays;

public class Q5 {
	static int rows = 3;
	static int columns = 4;
	
	public static void main(String[] args) {
		solution(rows, columns);
	}
	static int R,C,answer[][],cnt;
	static boolean isVisited[][];
	public static int[][] solution(int rows, int columns) {
		R = rows;
		C = columns;
        answer = new int [R][C];
        isVisited = new boolean[R][C];
        
        int num = 1;
        
        move(0,0,1);
        
        for(int x[] : answer) {
        	System.out.println(Arrays.toString(x));
        }
        return answer;
    }

	private static void move(int r, int c, int num) {
		if(cnt == R*C) {  // 전부 숫자가 다 채워지면 return
			return;
		}
		if(!isVisited[r][c]) { 
			isVisited[r][c] = true;
			cnt++;
		}
		if(answer[r][c] != 0 && answer[r][c] % 2 == num % 2) { // 무한 루프 돌경우 return
			return;
		}
		answer[r][c] = num;
		
		if(num % 2 == 0) { // 넣은 숫자가 짝수일 경우 오른쪽
			move(setR(r), c, num+1);
		}else { // 홀수면 아래쪽
			move(r, setC(c), num+1);
		}
	}
	
	static int setR(int r) {
		if(r+1 == R) {
			return 0;
		}
		return r+1;
	}
	
	static int setC(int c) {
		if(c+1 == C) {
			return 0;
		}
		return c+1;
	}
}














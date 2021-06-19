package com.codingtest.kakao.채용연계형인턴십;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class 프로그래밍3 {
	static int n = 8, k = 2;
//	static String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
	static String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
	
	static List<Integer> list = new ArrayList<>();
	static Stack<Integer> deletedRows = new Stack<>();
    public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        for(int i=0; i<n; i++) {
        	list.add(i);
        }
        int move = 0;
        int cnt = 0;
        for(int i=0; i<cmd.length; i++) {
        	StringTokenizer tokens = new StringTokenizer(cmd[i]);
        	switch (tokens.nextToken()) {
			case "U":
				move = Integer.parseInt(tokens.nextToken());
				k = k - move;
				break;
			case "D":
				move = Integer.parseInt(tokens.nextToken());
				k = k + move;
				break;
			case "C":
				int length = list.size();
				deletedRows.push(list.get(k));
				list.remove(k);
				if(k == length-1) {
					k--;
				}
				cnt++;
				break;
			case "Z":
				int recentRow =deletedRows.pop();
				if(recentRow > list.size()) {
					list.add(recentRow);
				}else {
					list.add(recentRow, recentRow);
				}
				if(recentRow <= k) {
					k++;
				}
				cnt--;
				break;
        	}
        }
        boolean result[] = new boolean[n];
        for(int i=0; i<list.size(); i++) {
        	result[list.get(i)] = true;
        }
        for(int i=0; i<n; i++) {
        	if(result[i]) {
        		answer = answer+"O";
        	}else {
        		answer = answer+"X";
        	}
        }
        return answer;
    }
	
	
	public static void main(String[] args) {
		solution(n, k, cmd);
	}
}

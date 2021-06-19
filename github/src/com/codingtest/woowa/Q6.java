package com.codingtest.woowa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q6 {
	static String logs[] = {
			"0001 3 95", 
			"0001 5 90", 
			"0001 5 100", 
			"0002 3 95", 
			"0001 7 80", 
			"0001 8 80", 
			"0001 10 90", 
			"0002 10 90", 
			"0002 7 80", 
			"0002 8 80", 
			"0002 5 100", 
			"0003 99 90"
			};
	public static void main(String[] args) {
		int size = logs.length;
		List<Exam> list = new ArrayList<>();
		Stack<Exam> stack = new Stack<>();
		System.out.println(size);
		for(int i=0; i<size; i++) {
			StringTokenizer tokens = new StringTokenizer(logs[i]);
//			String eNum = "";
//			int pNum = 0;
//			int pScore = 0;
			String eNum = tokens.nextToken();
			int pNum = Integer.parseInt(tokens.nextToken());
			int pScore = Integer.parseInt(tokens.nextToken());
			
			stack.add(new Exam(eNum, pNum, pScore));
		}
		
		list.add(stack.pop());
		while(!stack.isEmpty()) {
			for(int i=0; i<list.size(); i++) {
				if(list.get(i).eNum.equals(stack.peek().eNum) && list.get(i).pNum == stack.peek().pNum) {
					stack.pop();
					if(stack.isEmpty())break;
				}else {
					list.add(stack.pop());
					if(stack.isEmpty())break;
				}
				System.out.println(list);
			}
		} // 리스트 중복제거완료
		
		
//		System.out.println(list);
//		System.out.println(list.size());
	}
	static class Check{
		String eNum;
		int[] pNums;
		int[] pScores;
		public Check(String eNum, int[] pNums, int[] pScores) {
			super();
			this.eNum = eNum;
			this.pNums = pNums;
			this.pScores = pScores;
		}
		@Override
		public String toString() {
			return "Check [eNum=" + eNum + ", pNums=" + Arrays.toString(pNums)
					+ ", pScores=" + Arrays.toString(pScores) + "]";
		}
	}
	
	static class Exam{
		String eNum = "";
		int pNum = 0;
		int pScore = 0;
		public Exam(String eNum, int pNum, int pScore) {
			super();
			this.eNum = eNum;
			this.pNum = pNum;
			this.pScore = pScore;
		}
		@Override
		public String toString() {
			return "Exam [eNum=" + eNum + ", pNum=" + pNum + ", pScore=" + pScore + "]";
		}
	}
}

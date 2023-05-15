package com.codingtest.wadiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q2 {
	static String[] code = 
		{
				"a=3", 
				"..a=4", 
				"..b=3", 
				"..print a", 
				".......a=6", 
				".......print a", 
				".......print b", 
				"..print a", 
				"....a=7", 
				"....print a", 
				"print a", 
				"print b", 
				"a=4", 
				"print a", 
				"...print a"
		};
	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] answer = solution(code);
		System.out.println(Arrays.toString(answer));
	}

	private static String[] solution(String[] code) {
		String[] answer = {};
		int curBlock;
		char var;
		int num;
		List<Node> list = new ArrayList<>();
		List<String> result = new ArrayList<>();
		outer : for(int i=0; i<code.length; i++) {
			String cmd = code[i];
			// 현재 몇번 블록인지 확인
			curBlock = 0;
			for(int j=0; j<cmd.length(); j++) {
				if(cmd.charAt(j) == '.') {
					curBlock++;
				}
			}
			
			// list가 비어있을경우
			if(list.isEmpty()) {
				if(cmd.contains("print")) {
					result.add("error");
				}else {
					var = cmd.charAt(curBlock);
					num = Integer.parseInt(cmd.substring(curBlock+2));
					list.add(new Node(curBlock, var, num));
				}
				continue;
			}
			// 이전 블록과 비교해서 지울지 말지 정하기
			
			// 출력인 경우
			if(cmd.contains("print")) {
				for(int j=list.size()-1; j>=0; j--) {
					if(list.get(j).block > curBlock) {
						list.remove(j);
					}else {
						break;
					}
				}
				var = cmd.charAt(cmd.length()-1);
				for(int j=list.size()-1; j>=0; j--) {
					if(list.get(j).var == var) {
						result.add(var+"="+list.get(j).num);
						continue outer;
					}
				}
				result.add("error");
			}else { // 입력일 경우
				var = cmd.charAt(curBlock);
				num = Integer.parseInt(cmd.substring(curBlock+2));
				list.add(new Node(curBlock, var, num));
			}
		}
		answer = new String[result.size()];
		for(int i=0; i<result.size(); i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}
	static class Node{
		int block;
		char var; 
		int num;
		public Node(int block, char var, int num) {
			super();
			this.block = block;
			this.var = var;
			this.num = num;
		}
	}
}

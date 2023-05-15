package com.codingtest.bro.toss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q4_유용한금융정보 {
	static String input = 
			"1 3\r\n"
			+ "SHOW\r\n"
			+ "NEXT\r\n"
			+ "EXIT";
	public static void main(String[] args) throws IOException {
		solution(input);
	}
	private static String solution(String input) throws IOException {
		String answer = "";
		
		BufferedReader br = new BufferedReader(new StringReader(input));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		List<Integer> list = new LinkedList<>();
		int M = Integer.parseInt(tokens.nextToken());
		int N = Integer.parseInt(tokens.nextToken());
		int days = 0;
		boolean isRevealed = true;
		int remainDays = 0;
		int show = 0;
		int sumShow = 0;
		while(true) {
			String command = br.readLine();
			if(command.equals("EXIT")) {
				System.out.println("BYE");
				break;
			}
			if(command.equals("NEGATIVE")) {
				remainDays = M;
				System.out.println(0);
				continue;
			}
			if(command.equals("SHOW")) {
				if(remainDays>0) {
					System.out.println(0);
				}else {
					System.out.println(1);
					show++;
				}
				continue;
			}
			if(command.equals("NEXT")) {
				list.add(show);
				sumShow += show;
				if(list.size() > M) {
					sumShow -= list.get(0);
					list.remove(0);
				}
				show = 0;
				System.out.println("-");
				continue;
			}
		}
		
		return answer;
	}
}

package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G4_2661_좋은수열 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	static StringBuffer sb = new StringBuffer();
	static String result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
//		sb.append(1);
//		System.out.println(sb);
		dfs(0);
	}

	private static void dfs(int depth) {
		if(isDuplicated(sb)) {
			return;
		}
		if(depth == N) {
			result = sb.toString();
			System.out.println(result);
			System.exit(0);
		}
		
		if(sb.length() == 0) {
			sb.append(1);
			dfs(depth+1);
			sb.deleteCharAt(sb.length()-1); // 마지막 인덱스 삭제
			
			sb.append(2);
			dfs(depth+1);
			sb.deleteCharAt(sb.length()-1); // 마지막 인덱스 삭제
			
			sb.append(3);
			dfs(depth+1);
			sb.deleteCharAt(sb.length()-1); // 마지막 인덱스 삭제
		}else if(sb.charAt(sb.length()-1) == '1') {
//			System.out.println("1들어옴 zz");
			sb.append(2);
			dfs(depth+1);
			sb.deleteCharAt(sb.length()-1); // 마지막 인덱스 삭제
			
			sb.append(3);
			dfs(depth+1);
			sb.deleteCharAt(sb.length()-1); // 마지막 인덱스 삭제
		}else if(sb.charAt(sb.length()-1) == '2') {
			sb.append(1);
			dfs(depth+1);
			sb.deleteCharAt(sb.length()-1); // 마지막 인덱스 삭제
			
			sb.append(3);
			dfs(depth+1);
			sb.deleteCharAt(sb.length()-1); // 마지막 인덱스 삭제
		}else { // sb.charAt(sb.length()-1) == '3'
			sb.append(1);
			dfs(depth+1);
			sb.deleteCharAt(sb.length()-1); // 마지막 인덱스 삭제

			sb.append(2);
			dfs(depth+1);
			sb.deleteCharAt(sb.length()-1); // 마지막 인덱스 삭제
		}
	}

	private static boolean isDuplicated(StringBuffer sb) {
		boolean flag = false;
		for(int i=1; i<=sb.length()/2; i++) {
			int aLast = sb.length();
			int aFirst = sb.length() - i;
			int bFirst = aFirst -i;
			int bLast = aFirst;
			if(sb.substring(aFirst, aLast).equals(sb.substring(bFirst, bLast))) {
				flag = true;
				break;
			}
		}
		return flag; // true면 중복 false면 중복x
	}

	static String src =
			"80";
}

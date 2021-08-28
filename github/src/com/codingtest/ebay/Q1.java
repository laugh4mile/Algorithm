package com.codingtest.ebay;

public class Q1 {
	static String s = "1011";
//	static String s = "0110011";
//	static String s = "000111";
	public static void main(String[] args) {
		int answer = solution(s);
		System.out.println(answer);
	}

//	private static int solution(String s) {
//		int answer = 0;
//		
//		boolean flag = true;
//		System.out.println(s);
//		while(flag) {
//			flag = false;
//			for(int i=0; i<s.length()-1; i++) {
//				if(s.charAt(i) != s.charAt(i+1)) {
//					flag = true;
//					s = s.substring(0, i).concat(s.substring(i+2, s.length()));
//					break;
//				}
//			}
//			System.out.println(s);
//		}
//		answer = s.length();
//		return answer;
//	}
	
//	private static int solution(String s) {
//		int answer = 0;
//		
//		boolean flag = true;
//		int start=0;
//		while(flag) {
//			flag = false;
//			for(int i=start; i<s.length()-1; i++) {
//				if(s.charAt(i) != s.charAt(i+1)) {
//					flag = true;
//					s = s.substring(0, i).concat(s.substring(i+2, s.length()));
//					start = i-1;
//					if(start <0) {
//						start = 0;
//					}
//					break;
//				}
//			}
//		}
//		answer = s.length();
//		return answer;
//	}
	private static int solution(String s) {
		
		char[] chars = s.toCharArray();
        int zeroCnt = 0;
        int oneCnt = 0;
        for (char ch : chars) {
            if (ch == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }
        return Math.abs(zeroCnt - oneCnt);
	}
}

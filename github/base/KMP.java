package com.base;

public class KMP {
	static String target = "banana";
	static String pattern ="ana";
	
	
	public static void main(String[] args) {
		kmp();
	}


	private static void kmp() {
		int patternLen = pattern.length();
		int targetLen = target.length();
		int[] pi = getPi();
		
		// begin : 검색 시작 위치, matched: 일치한 문자열의 길이
		int begin =0, matched =0;
		// 범위 내에 있을때 까지
		while(begin + patternLen <= targetLen) {
			// 현재 위치에서의 비교가 일치할 때
			// --> 아직 pattern 과 완정히 일치하지는 않았고 현재 위치에서의 문자가 같다면..
			if(matched < patternLen && pattern.charAt(matched) == target.charAt(matched + begin)) {
				matched++;
				// 이렇게 증가시켰더니.. matched가  patternLen과 같다면??
				if(matched == patternLen) {
					System.out.println("발견 : 시작위치: " +  begin);
				}
			}
			// 현재위치에서의 비교가 실패할 때
			else {
				// 처음부터 하나도 안맞았다면..
				if(matched==0) {
					begin++;
				// 몇개는 맞는 상황이라면..
				}else { 
					begin = begin + matched - pi[matched-1]; // begin++ 이 아니라.. 건너뜀.
					// 실제 비교해볼 위치도 변경한다.
					matched = pi[matched-1];
				}
			}
		}
	}


	static int[] getPi() {
		int patternLen = pattern.length();
		int[] pi = new int[patternLen];
		// begin: 검색 시작 위치, matched: 일치한 문자열 길이
		// 동일한 패턴을 이용해서 비교할꺼니까 begin이 0부터 시작하는건 의미없다.
		int begin = 1, matched = 0;
		// 범위 내에 있을때까지... 그언데 접두/접미부는 전체 문자열을 대상으로 하지 않는다
		while (begin + matched <patternLen-1) {
			// 현재 비교하는게 같다면?
			if(pattern.charAt(matched) == pattern.charAt(begin + matched)) {
				matched++;
				// 증가된 값이 pi 배열의 값이다.
				pi[begin + matched -1] = matched;
			}
			// 다르다면?
			else {
				if(matched==0) {
					begin++;
				// 몇개는 맞는 상황이라면..
				}else { 
					begin = begin + matched - pi[matched-1]; // begin++ 이 아니라.. 건너뜀.
					// 실제 비교해볼 위치도 변경한다.
					matched = pi[matched-1];
				}
			}
		}
		return pi;
	}
}

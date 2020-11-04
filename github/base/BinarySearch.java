package com.base;

import java.util.Arrays;

public class BinarySearch {
	static int[] src = {2,4,7,9,11,19,23};
	static int target = 7;
	public static void main(String[] args) {
		// 이진탐색은 요소가 정렬된 상태에서 사용
		Arrays.sort(src);
		myLoop();
		int result = search(0,src.length-1);
		if(result<0) {
			System.out.println("검색실패");
		}else {
			System.out.println(result + "에서 " + target + "발견");
		}
		
		result = byApi();
		if(result<0) {
			System.out.println("검색실패");
		}else {
			System.out.println(result + "에서 " + target + "발견");
		}
	}

	static int byApi() {
		return Arrays.binarySearch(src, target);
	}
	
	static int search(int from, int to) {
		// 탈출 조건
		if (from > to) {
			return -1;
		}
		else {
			int mid = (from + to) /2;
			if (src[mid] == target) {
				return mid;
			}else{
				if(src[mid]>target) {
					to = mid -1;
				}else {
					from = mid +1;
				}
				int idx = search(from, to);
				if(idx > -1) {
					return idx;
				}
			}
		}
		return -1;
	}
	
	static void myLoop() {
		// 범위
		int from = 0;
		int to = src.length-1;
		int answer = -1;
		
		while(from <= to) {
			int mid = (from + to) / 2; //중간위치의 값
			// 중간값이 답인 경우
			if(src[mid] == target) {
				answer = mid;
				break;
			}
			// 중간값이 더 큰 경우 : 위쪽영역은 신경쓸 필요 x
			else if(src[mid]>target) {
				to = mid-1;
			}
			// 중간값이 더 작은 경우
			else {
				from = mid+1;
			}
		}
		if(answer<0) {
			System.out.println("검색실패");
		}else {
			System.out.println(answer + "에서 " + target + "발견");
		}
	}
}

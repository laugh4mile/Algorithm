package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * @author yhs
 * @date 2020. 8. 2
 * @see https://www.acmicpc.net/problem/3052
 * @mem 12932KB
 * @time 80ms
 * @caution 
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */

public class BJ_B2_3052_나머지 { 

	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int[] nums;
	static boolean[] isExist = new boolean[42];
	static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
//		input = new BufferedReader(new StringReader(src));
		nums = new int[10];
		for(int i=0; i<10; i++) {
			nums[i] = Integer.parseInt(input.readLine())%42;
		}
//		for(int i=0; i<10; i++) {
//			System.out.print(nums[i]+" ");
//		}
		for(int i=0; i<10; i++) {
			for(int j=0; j<42; j++) {
				if(nums[i]==j) {
					isExist[j] = true;
				}
			}
		}
		for(int i=0; i<42; i++) {
			if(isExist[i]) {
				result++;
			}
		}
		System.out.println(result);
	}
//	static String src = "39\r\n" + 
//			"40\r\n" + 
//			"41\r\n" + 
//			"42\r\n" + 
//			"43\r\n" + 
//			"44\r\n" + 
//			"82\r\n" + 
//			"83\r\n" + 
//			"84\r\n" + 
//			"85";

}

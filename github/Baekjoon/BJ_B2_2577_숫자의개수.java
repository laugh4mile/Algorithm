package com.BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

/**
 * @author yhs
 * @date 2020. 8. 2
 * @see https://www.acmicpc.net/problem/2577
 * @mem 12920KB
 * @time 76ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */

public class BJ_B2_2577_숫자의개수 {
	static BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
	static int nums[] = new int[3]; 
	static String gob;
	static char[] ch;
	static int[] zary = new int[10];
	public static void main(String[] args) throws NumberFormatException, IOException {
//		input = new BufferedReader (new StringReader (src));
		for(int i=0; i<3; i++) {
			nums[i] = Integer.parseInt(input.readLine());
		}
		gob = Integer.toString(nums[0]*nums[1]*nums[2]);
//		System.out.println(gob);
		ch = new char[gob.length()];
		
		for(int i=0; i<gob.length(); i++) {
			ch[i] = gob.charAt(i);
		}
//		System.out.println(Arrays.toString(ch));
		for(int i=0; i<ch.length; i++) {
			switch (ch[i]) {
			case '0':
				zary[0]++;
				break;

			case '1':
				zary[1]++;
				break;
				
			case '2':
				zary[2]++;
				break;
				
			case '3':
				zary[3]++;
				break;
				
			case '4':
				zary[4]++;
				break;
				
			case '5':
				zary[5]++;
				break;
				
			case '6':
				zary[6]++;
				break;
				
			case '7':
				zary[7]++;
				break;
				
			case '8':
				zary[8]++;
				break;
				
			case '9':
				zary[9]++;
				break;
				
			default:
				break;
			}
		}
		for(int i=0; i<10; i++) {
			System.out.println(zary[i]);
		}
		
		
	}
//	static String src = "150\r\n" + 
//			"266\r\n" + 
//			"427";

}

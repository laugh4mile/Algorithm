package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_S2_2290_LCDTest {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int s;
	static String num;
	static StringBuffer sb[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		s = Integer.parseInt(tokens.nextToken());
		num = tokens.nextToken();
		sb = new StringBuffer[2*s+3];
		int size = num.length();
		for(int i=0; i<2*s+3; i++) {
			sb[i] = new StringBuffer();
		}
		
		for(int i=0; i<size; i++) {
			switch (num.charAt(i)) {
			case '1':
				sang1();
				jungSang2();
				jung1();
				jungHa2();
				ha1();
				break;
			case '2':
				sang2();
				jungSang2();
				jung2();
				jungHa1();
				ha2();
				break;
			case '3':
				sang2();
				jungSang2();
				jung2();
				jungHa2();
				ha2();
				break;
			case '4':
				sang1();
				jungSang3();
				jung2();
				jungHa2();
				ha1();
				break;
			case '5':
				sang2();
				jungSang1();
				jung2();
				jungHa2();
				ha2();
				break;
			case '6':
				sang2();
				jungSang1();
				jung2();
				jungHa3();
				ha2();
				break;
			case '7':
				sang2();
				jungSang2();
				jung1();
				jungHa2();
				ha1();
				break;
			case '8':
				sang2();
				jungSang3();
				jung2();
				jungHa3();
				ha2();
				break;
			case '9':
				sang2();
				jungSang3();
				jung2();
				jungHa2();
				ha2();
				break;
			case '0':
				sang2();
				jungSang3();
				jung1();
				jungHa3();
				ha2();
				break;
			}
			for(int z=0; z<sb.length; z++) {
				sb[z].append(' ');
			}
		}
		for(int i=0; i<sb.length; i++) {
			System.out.println(sb[i]);
		}
	}
	
	static void sang1(){
		for(int i=0; i<s+2; i++) { // 맨 윗라인 없음
			sb[0].append(' ');
		}
	}
	
	static void sang2(){
		sb[0].append(' '); // 맨 윗라인 있음
		for(int j=0; j<s; j++) {
			sb[0].append('-');
		}
		sb[0].append(' ');
	}
	
	static void jungSang1() { // 중상 라인 왼쪽 
		for(int j=1; j<1+s; j++) { 
			sb[j].append('|');
			for(int k=0; k<s+1; k++) {
				sb[j].append(' ');
			}
		}
	}
	
	static void jungSang2() { // 중상 라인 오른쪽 
		for(int j=1; j<1+s; j++) { 
			for(int k=0; k<s+1; k++) {
				sb[j].append(' ');
			}
			sb[j].append('|');
		}
	}
	
	static void jungSang3() { // 중상 라인 양쪽 
		for(int j=1; j<1+s; j++) { 
			sb[j].append('|');
			for(int k=0; k<s; k++) {
				sb[j].append(' ');
			}
			sb[j].append('|');
		}
	}
	
	static void jung1() {  // 중 라인 없음
		for(int i=0; i<s+2; i++) {
			sb[1+s].append(' ');
		}
	}
	
	
	static void jung2() {  // 중 라인 있음
		sb[1+s].append(' ');
		for(int i=0; i<s; i++) { 
			sb[1+s].append('-');
		}
		sb[1+s].append(' ');
	}
	
	static void jungHa1() { // 중하 라인 왼쪽
		for(int j=2+s; j<2*s+2; j++) {
			sb[j].append('|');
			for(int k=0; k<s+1; k++) {
				sb[j].append(' ');
			}
		}
	}
	
	static void jungHa2() { // 중하 라인 오른쪽
		for(int j=2+s; j<2*s+2; j++) {
			for(int k=0; k<s+1; k++) {
				sb[j].append(' ');
			}
			sb[j].append('|');
		}
	}
	
	static void jungHa3() { // 중하 라인 양쪽
		for(int j=2+s; j<2*s+2; j++) {
			sb[j].append('|');
			for(int k=0; k<s; k++) {
				sb[j].append(' ');
			}
			sb[j].append('|');
		}
	}
	
	static void ha1() {  // 맨 아래 라인 없음
		for(int j=0; j<s+2; j++) {
			sb[2*s+2].append(' ');
		}
	}
	
	static void ha2() {  // 맨 아래 라인 있음
		sb[2+2*s].append(' ');
		for(int j=0; j<s; j++) { 
			sb[2+2*s].append('-');
		}
		sb[2+2*s].append(' ');
	}
	static String src =
			"3 1234567890";
}

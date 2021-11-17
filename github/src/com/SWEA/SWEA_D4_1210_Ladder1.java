package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2020. 7. 28
 * @mem
 * @time 
 * @caution 
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
public class SWEA_D4_1210_Ladder1 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); //입력받는 새기
	static StringBuilder output = new StringBuilder(); //출력값 저장하는 새기
	static int answer;
	static int[][] radder;
	
	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));  // 제출 할 때는 당연히 주석처리. 잠깐 방향을 바꾸는역할
		
		for(int t=1; t<=10; t++) {
			input.readLine(); //첫째줄은 필요없어서 걍 읽고 버림
			radder = new int[100][100];
			StringTokenizer tokens = null;
			for(int r=0; r<100; r++) {
				tokens = new StringTokenizer(input.readLine()," "); //받아온 라인을 " " 단위로 끊어줌
				for(int c=0; c<100; c++) {
					radder[r][c] = Integer.parseInt(tokens.nextToken());
				}
			}
			int realR=0, realC=0;
			for(int r=0; r<100; r++) {
				for(int c=0; c<100; c++) {
					
					if(radder[r][c]==2) {
						realR = r;
						realC = c;
					}
				}
			}
//			System.out.printf("%d, %d\n",realR,realC);

			
//			for(int[] row:radder) {
//				System.out.println(Arrays.toString(row));
//			}
//			while(realR!=0) {
//				System.out.println("와일문 스타트");
//
//				if(realC==0) { //왼쪽 끝 일경우
//					for(int i=realR; i>0 ;realR--) {
//						if(radder[i][realC+1] == 1) {
//							while(radder[i][realC]==1) {
//								realC++;
//								System.out.println("왼끝");
//							}
//							realC--;
//							realR=i;
//							break;
//						}
//						
//					}
//				}
//				else if(realC==99) { //오른쪽 끝 일경우
//					for(int i=realR; i>0 ;realR--) {
//						if(radder[i][realC-1] == 1) {
//							while(radder[i][realC]==1) {
//								realC--;
//								System.out.println("오끝");
//							}
//							realC++;
//							realR=i;
//							break;
//						}
//						
//					}
//				}
//				else{ ////왼쪽 끝, 오른쪽 끝이 아닐경우
//					System.out.println("왼쪽 끝, 오른쪽 끝이 아닐경우");
//					for(int i=realR-1; i>0 ;realR--) {
////						System.out.println("시발");
//						if(radder[i][realC-1] == 1) { //왼쪽
//							System.out.println("왼");
//							while(radder[i][realC]==1) {
//								realC--;
//								System.out.println("왼");
//							}
//							realC++;
//							realR=i;
//							break;
//						}else if(radder[i][realC+1] == 1) { //오른쪽
//							System.out.println("오");
//							while(radder[i][realC]==1) {
//								realC++;
//								System.out.println("오");
//							}
//							realC--;
//							realR=i;
//							break;
//						}
//						
//					}
//				}
//			}
			

			System.out.printf("%d, %d\n",realR,realC);
			
			while(realR!=0) {
//				System.out.println("와일문 스타트");

				if(realC==0) { //왼쪽 끝 일경우
					for(int i=realR; i>0 ;i--) {
						if(radder[i][realC+1] == 1) {
							while(radder[i][realC]==1) {
								realC++;
								System.out.println("왼끝");
							}
							realC--;
							realR=i;
							break;
						}
						
					}
				}
				else if(realC==99) { //오른쪽 끝 일경우
					for(int i=realR; i>0 ;i--) {
						if(radder[i][realC-1] == 1) {
							while(radder[i][realC]==1) {
								realC--;
								System.out.println("오끝");
							}
							realC++;
							realR=i;
							break;
						}
						
					}
				}
				else{ ////왼쪽 끝, 오른쪽 끝이 아닐경우
//					System.out.println("왼쪽 끝, 오른쪽 끝이 아닐경우");
					for(int i=realR; i>0 ;i--) {
//						System.out.printf("[%d, %d]	[%d, %d]\n",i,realC-1,i,realC+1);
//						System.out.println("시발");
						if(radder[i-1][realC-1] == 1) { //왼쪽
//							System.out.println("왼");
							while(radder[i-1][realC]==1) {
								realC--;
//								System.out.println("왼");
							}
							realC++;
							realR=i-1;
							break;
						}else if(radder[i-1][realC+1] == 1) { //오른쪽
//							System.out.println("오");
							while(radder[i-1][realC]==1) {
								realC++;
//								System.out.println("오");
							}
							realC--;
							realR=i-1;
							break;
						}
						
					}
				}
			}
			System.out.printf("[%d, %d]\n",realR,realC);
			
//			for(int[] row:radder) {
//				System.out.println(Arrays.toString(row));
//			}
			
		}
		
	}
	

	static String src = "1\r\n" +
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 0 1 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1\r\n" + 
		"1 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 1 1 1 1 1 0 0 0 1 0 0 0 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 1 1 1 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 1 1 1 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 1 1 1 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 1 1 1 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 1 1 1 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 1 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 1 1 1 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 1 1 1 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 1 0 1 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1\r\n" + 
		"1 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 1 0 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 1 0 0 0 0 0 0 0 0 0 0 2 0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 1";
}

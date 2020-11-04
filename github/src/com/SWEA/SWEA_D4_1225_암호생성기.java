package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2020. 7. 30
 * @see https://swexpertacademy.com/main/talk/solvingClub/problemView.do?contestProbId=AV14uWl6AF0CFAYD&solveclubId=AXOJsQN67-MDFAXS&problemBoxTitle=0730&problemBoxCnt=2&probBoxId=AXOdvjZKHiwDFAXS+
 * @mem 22,484 kb
 * @time 151 ms
 * @caution #큐
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
public class SWEA_D4_1225_암호생성기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int testCase;
	static String line;
	
	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<Integer>();
//		input = new BufferedReader(new StringReader(src));
		line = null;
		while((line = input.readLine()) != null){
			int[] code = new int[8];
			String line2 = input.readLine();
			StringTokenizer tokens = new StringTokenizer(line2," ");
			for(int i=0; i<code.length; i++) {
				code[i] = Integer.parseInt(tokens.nextToken());
				queue.offer(code[i]);
			} //큐에 입력값 넣기 완료
			int temp=0;
			
			outer : while(true) {
				for(int i=1; i<=5; i++) {
					temp = queue.poll()-i;
					if(temp<=0) {
						temp=0;
						queue.offer(temp);
						break outer;
					}else {
						queue.offer(temp);
					}
					
				}
			}
				
			System.out.printf("#%d ",Integer.parseInt(line));
			for(int i=0; i<8;i++) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
			queue.clear();
		}
	}
//	static String src = "1\r\n" + 
//			"9550 9556 9550 9553 9558 9551 9551 9551 \r\n" + 
//			"2\r\n" + 
//			"2419 2418 2423 2415 2422 2419 2420 2415 \r\n" + 
//			"3\r\n" + 
//			"7834 7840 7840 7835 7841 7835 7835 7838 \r\n" + 
//			"4\r\n" + 
//			"4088 4087 4090 4089 4093 4085 4090 4084 \r\n" + 
//			"5\r\n" + 
//			"2945 2946 2950 2948 2942 2943 2948 2947 \r\n" + 
//			"6\r\n" + 
//			"670 667 669 671 670 670 668 671 \r\n" + 
//			"7\r\n" + 
//			"8869 8869 8873 8875 8870 8872 8871 8873 \r\n" + 
//			"8\r\n" + 
//			"1709 1707 1712 1712 1714 1710 1706 1712 \r\n" + 
//			"9\r\n" + 
//			"10239 10248 10242 10240 10242 10242 10245 10235 \r\n" + 
//			"10\r\n" + 
//			"6580 6579 6574 6580 6583 6580 6577 6581 \r\n" + 
//			"";

}

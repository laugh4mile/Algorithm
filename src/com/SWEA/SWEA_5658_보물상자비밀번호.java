package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author yhs
 * @date 2020. 12. 2
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 1) N/4-1 만큼 lock을 이어붙여줘야함.
 * [입력사항]
 * [출력사항]
 */

public class SWEA_5658_보물상자비밀번호 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,K;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			K = Integer.parseInt(tokens.nextToken());
			char arr[] = new char[N];
			char lock[] = new char[N+N/4-1];
			String temp = input.readLine();
			arr = temp.toCharArray();
			for(int i=0; i<N; i++) {
				lock[i] = arr[i];
			}
			for(int i=0; i<N/4-1; i++) {
				lock[N+i] = lock[i];
			}
//			System.out.println(Arrays.toString(lock));
			
			Set<String> set = new HashSet<>();
			for(int i=0; i<N; i++) {
				String num = "";
				for(int j=0; j<N/4; j++) {
					num = num.concat(Character.toString(lock[i+j]));
				}
//				System.out.println(num);
				set.add(num);
			}
//			System.out.println(set);
			List<String> list = new ArrayList<>(set);
			Collections.sort(list, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					int n1 = Integer.parseInt(o1,16);
					int n2 = Integer.parseInt(o2,16);
					return Integer.compare(n2, n1);
				}
			});
//			System.out.println(list);
			int result = Integer.parseInt(list.get(K-1),16);
			System.out.println("#"+t+" "+result);
		}
	}

	 

	static String src =
			"5\r\n" + 
			"12 10\r\n" + 
			"1B3B3B81F75E\r\n" + 
			"16 2\r\n" + 
			"F53586D76286B2D8\r\n" + 
			"20 14\r\n" + 
			"88F611AE414A751A767B\r\n" + 
			"24 16\r\n" + 
			"044D3EBA6A647B2567A91D0E\r\n" + 
			"28 11\r\n" + 
			"8E0B7DD258D4122317E3ADBFEA99";
}

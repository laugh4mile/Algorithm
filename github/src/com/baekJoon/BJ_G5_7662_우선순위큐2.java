package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BJ_G5_7662_우선순위큐2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		
		for (int t = 0; t < T; t++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			K = Integer.parseInt(input.readLine());
			for (int k = 0; k < K; k++) {
				tokens = new StringTokenizer(input.readLine());
				char cmd = tokens.nextToken().charAt(0);
				int num = Integer.parseInt(tokens.nextToken());
				if (cmd == 'I') {
					map.put(num, num);
				}
				if (cmd == 'D') {
					if(num==-1) {
						if(map.size()>0) {
							map.remove(map.firstKey());
						}
					}else {
						if(map.size()>0) {
							map.remove(map.lastKey());
						}

					}
				}
			}
			if(map.size()<=0) {
				System.out.println("EMPTY");
			}else {
				
				System.out.println(map.get(map.lastKey())+" "+map.firstKey());
			}
		}
	}

	static String src = "2\r\n" + "7\r\n" + "I 16\r\n" + "I -5643\r\n" + "D -1\r\n" + "D 1\r\n" + "D 1\r\n"
			+ "I 123\r\n" + "D -1\r\n" + "9\r\n" + "I -45\r\n" + "I 653\r\n" + "D 1\r\n" + "I -642\r\n" + "I 45\r\n"
			+ "I 97\r\n" + "D 1\r\n" + "D -1\r\n" + "I 333";
}

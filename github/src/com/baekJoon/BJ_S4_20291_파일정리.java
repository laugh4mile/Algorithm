package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.Map;
import java.util.TreeMap;

public class BJ_S4_20291_파일정리 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		Map<String, Integer> map = new TreeMap<>();
		
		for(int n=0; n<N; n++) {
			String line = input.readLine();
			for(int i=0; i<line.length(); i++) {
				if(line.charAt(i) == '.') {
					String key = line.substring(i+1);
					if(map.get(key) == null) {
						map.put(key, 1);
					}else {
						map.put(key, map.get(key)+1);
					}
				}
			}
		}
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			output.append(entry.getKey()+" "+entry.getValue()+"\n");
		}
		output.close();
	}

	static String src =
			"8\r\n" + 
			"sbrus.txt\r\n" + 
			"spc.spc\r\n" + 
			"acm.icpc\r\n" + 
			"korea.icpc\r\n" + 
			"sample.txt\r\n" + 
			"hello.world\r\n" + 
			"sogang.spc\r\n" + 
			"example.txt";
}

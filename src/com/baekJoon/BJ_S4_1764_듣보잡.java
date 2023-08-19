package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S4_1764_듣보잡 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter  output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int N,M;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		tokens = new StringTokenizer(input.readLine());
		N = Integer.parseInt(tokens.nextToken());
		M = Integer.parseInt(tokens.nextToken());
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		
		for(int n=0; n<N; n++) {
			String temp = input.readLine();
			map.put(temp, 1);
		}
		for(int m=0; m<M; m++) {
			String temp = input.readLine();
			if(map.get(temp) != null) {
				list.add(temp);
			}
		}
		Collections.sort(list);
		output.append(list.size()+"\n");
		for(int i=0; i<list.size(); i++) {
			output.append(list.get(i)+"\n");
		}
		
		output.close(); 
	}

	static String src =
			"3 4\r\n" + 
			"ohhenrie\r\n" + 
			"charlie\r\n" + 
			"baesangwook\r\n" + 
			"obama\r\n" + 
			"baesangwook\r\n" + 
			"ohhenrie\r\n" + 
			"clinton";
}

package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BJ_S5_7785_회사에있는사람 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		int N = Integer.parseInt(input.readLine());
		List<String> list = new ArrayList<>();
		Map<String, Boolean> map = new HashMap<>();
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			String employee = tokens.nextToken();
			String state = tokens.nextToken();
			if(map.get(employee) == null) {
				map.put(employee, true);
			}else {
				map.remove(employee);
			}
		}
		for(Entry<String, Boolean> entry : map.entrySet()) {
			list.add(entry.getKey()); 
		}
		
		Collections.sort(list, Comparator.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for(String x : list) {
			sb.append(x+"\n");
		}
		System.out.println(sb);
	}

	static String src =
			"4\r\n"
			+ "Baha enter\r\n"
			+ "Askar enter\r\n"
			+ "Baha leave\r\n"
			+ "Artem enter";
}

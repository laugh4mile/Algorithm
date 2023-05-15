package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;

public class BJ_S5_1343_폴리오미노 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		String S = input.readLine();
		boolean flag = false;
		for(int i=0; i<S.length(); i++) {
			if(i+3 < S.length() && S.substring(i,i+4).equals("XXXX")) {
				output.append("AAAA");
				i = i+3;
			}else if(i+1 < S.length() && S.substring(i, i+2).equals("XX")) {
				output.append("BB");
				i = i+1;
			}else if(S.charAt(i) != 'X'){
				output.append(S.charAt(i));
			}else {
				flag = true;
			}
		}
		if(flag) {
			System.out.println(-1);
		}else {
			output.close();
		}
	}

	static String src =
			"XXXXXX";
}

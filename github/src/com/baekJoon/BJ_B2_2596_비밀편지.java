package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_B2_2596_비밀편지 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int N, flag;
	static String word[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		word = new String[N];
		String line = input.readLine();
		for(int i=0; i<N; i++) {
			word[i] = line.substring(i*6, i*6+6);
		}
		solve();
		if(flag != 0) {
			System.out.println(flag);
		}else {
			output.close();
		}
	}

	private static void solve() throws IOException {
		outer : for(int i=0; i<N; i++) {
			switch (word[i]) {
			case "000000":
				output.append('A');
				break;
			case "100000":
				output.append('A');
				break;
			case "010000":
				output.append('A');
				break;
			case "001000":
				output.append('A');
				break;
			case "000100":
				output.append('A');
				break;
			case "000010":
				output.append('A');
				break;
			case "000001":
				output.append('A');
				break;
			case "001111":
				output.append('B');
				break;
			case "101111":
				output.append('B');
				break;
			case "011111":
				output.append('B');
				break;
			case "000111":
				output.append('B');
				break;
			case "001011":
				output.append('B');
				break;
			case "001101":
				output.append('B');
				break;
			case "001110":
				output.append('B');
				break;
			case "010011":
				output.append('C');
				break;
			case "110011":
				output.append('C');
				break;
			case "000011":
				output.append('C');
				break;
			case "011011":
				output.append('C');
				break;
			case "010111":
				output.append('C');
				break;
			case "010001":
				output.append('C');
				break;
			case "010010":
				output.append('C');
				break;
			case "011100":
				output.append('D');
				break;
			case "111100":
				output.append('D');
				break;
			case "001100":
				output.append('D');
				break;
			case "010100":
				output.append('D');
				break;
			case "011000":
				output.append('D');
				break;
			case "011110":
				output.append('D');
				break;
			case "011101":
				output.append('D');
				break;
			case "100110":
				output.append('E');
				break;
			case "000110":
				output.append('E');
				break;
			case "110110":
				output.append('E');
				break;
			case "101110":
				output.append('E');
				break;
			case "100010":
				output.append('E');
				break;
			case "100100":
				output.append('E');
				break;
			case "100111":
				output.append('E');
				break;
			case "101001":
				output.append('F');
				break;
			case "001001":
				output.append('F');
				break;
			case "111001":
				output.append('F');
				break;
			case "100001":
				output.append('F');
				break;
			case "101101":
				output.append('F');
				break;
			case "101011":
				output.append('F');
				break;
			case "101000":
				output.append('F');
				break;
			case "110101":
				output.append('G');
				break;
			case "010101":
				output.append('G');
				break;
			case "100101":
				output.append('G');
				break;
			case "111101":
				output.append('G');
				break;
			case "110001":
				output.append('G');
				break;
			case "110111":
				output.append('G');
				break;
			case "110100":
				output.append('G');
				break;
			case "111010":
				output.append('H');
				break;
			case "011010":
				output.append('H');
				break;
			case "101010":
				output.append('H');
				break;
			case "110010":
				output.append('H');
				break;
			case "111110":
				output.append('H');
				break;
			case "111000":
				output.append('H');
				break;
			case "111011":
				output.append('H');
				break;
			default:
				flag = i+1;
				break outer;
			
			}
		}
	}

	static String src =
			"3\r\n" + 
			"001111000000011100";
}

package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_D4_3234_준환이의양팔저울 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T, N, scale[], result[], sum, cnt;
	static boolean isSelected[];

	public static void main(String[] args) throws IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(input.readLine());
			scale = new int[N];
			result = new int[N];
			isSelected = new boolean[N];
			tokens = new StringTokenizer(input.readLine());
			for (int n = 0; n < N; n++) {
				scale[n] = Integer.parseInt(tokens.nextToken());
			}
//			System.out.println(Arrays.toString(scale));
			per(0);
			System.out.printf("#%d %d\n",t,cnt);
			cnt = 0;
		}
	}

	private static void per(int cnt) {
		if (cnt == N) {
//			System.out.println(Arrays.toString(result));
			cal(0, 0, 0);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			result[cnt] = scale[i];
			isSelected[i] = true;
			per(cnt + 1);
			isSelected[i] = false;
		}
	}

	static void cal(int index, int left, int right) {
		if (index == N) {
			cnt++;
			return;
		}
		sum = left + result[index];
		cal(index + 1, sum, right);
		sum = right + result[index];
		if (sum <= left) {
			cal(index + 1, left, sum);
		}
	}

	static String src = "2\r\n" + "3\r\n" + "1 2 4\r\n" + "3\r\n" + "1 2 3\r\n"
//			+ 
//			"9\r\n" + 
//			"1 2 3 5 6 4 7 8 9"
	;
}

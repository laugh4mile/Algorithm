package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_S5_2811_상범이의우울 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		int arr[] = new int[N];
		boolean isChecked[] = new boolean[N];
		tokens = new StringTokenizer(input.readLine());
		int max = 0; 
		boolean isDepressed = false;
		List<Feel> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
			if(arr[i] < 0) { // 우울해요..
				if(isDepressed) { // 이미 우울한 상태이면
					list.get(list.size()-1).days++;
					if(list.get(list.size()-1).days > max) {
						max = list.get(list.size()-1).days;
					}
				}else { // 처음 우울한 날이라면
					// 인덱스와 연속되는 우울한날의 수를 저장한다.
					list.add(new Feel(i, 1));
					if(1 > max) {
						max = 1;
					}
				}
				isDepressed = true;
			}else {
				isDepressed = false;
			}
		}
		for(int i=0; i<list.size(); i++) {
			int idx = list.get(i).idx;
			int days = list.get(i).days;
			for(int j=idx-1; j>=idx-days*2; j--) {
				if(isIn(j)) {
					isChecked[j] = true;
				}
			}
		}
		int cnt = 0;
		int max2 = 0;
		for(int i=0; i<list.size(); i++) {
			int idx = list.get(i).idx;
			int days = list.get(i).days;
			if(days == max) {
				cnt = 0;
				for(int j=idx-1-max*2; j>=idx-3*max; j--) {
//					System.out.print(j+" ");
					if(isIn(j) && !isChecked[j]) {
						cnt++;
					}
				}
//				System.out.println();
			}
			if(cnt > max2) {
				max2 = cnt;
			}
		}
		int answer = max2;
		for(int i=0; i<N; i++) {
			if(isChecked[i]) {
				answer++;
			}
		}
//		System.out.println(Arrays.toString(isChecked));
		System.out.println(answer);
	}
	
	static boolean isIn(int n) {
		return (n>=0 && n<N);
	}
	static class Feel{
		int idx;
		int days;
		public Feel(int idx, int days) {
			super();
			this.idx = idx;
			this.days = days;
		}
		@Override
		public String toString() {
			return "Feel [idx=" + idx + ", days=" + days + "]";
		}
		
	}

	static String src =
			"8\r\n"
			+ "1 -1 4 3 8 -2 3 -3";
}

package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_G4_17281_야구 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, inning[][], num[] = new int [8], max, answer;
	static boolean isSelected[] = new boolean [8];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		inning = new int[N][9];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<9; c++) {
				inning[r][c] = Integer.parseInt(tokens.nextToken());
			}	
		}
		
		max = 0;
		permutation(0);
		System.out.println(max);
	}

	private static void permutation(int cnt) { // 순열을 돌리자
		if(cnt == 8) {
			makeCopy(num); // 1~8까지 순열이 만들어짐. 0은 [3]번 인덱스에 고정으로 넣을거임
			return;
		}
		for(int i=0; i<8; i++) {
			if(isSelected[i]) continue;
			num[cnt] = i+1;
			
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

	private static void makeCopy(int[] num) {
		int copy[][] = new int[N][9];
		for(int r=0; r<N; r++) {
			for(int c=0; c<9; c++) { // 8 로 해서 조금더 단축 가능하긴 함
				if(c<3) {
					copy[r][c] = num[c];
				}
				else if(c==3) { // 4 번 타자는 고정임
					copy[r][c] = 0;
				}else{
					copy[r][c] = num[c-1];
				}
			}	
		}
		int map[][] = new int[N][9];
		for(int r=0; r<N; r++) {
			for(int c=0; c<9; c++) {
				map[r][c] = inning[r][copy[r][c]];
			}
		}
		
		
//		for(int x[]: map) {
//			System.out.println(Arrays.toString(x));
//		} 
//		System.out.println();
		cal(map);
	}

	private static void cal(int[][] map) {
		Map<Integer, Integer> base = new HashMap<>(); //
		base.put(1, 0); // 1루 주자
		base.put(2, 0); // 2루 주자
		base.put(3, 0); // 3루 주자
		int score = 0; // 총점
		int outCnt = 0; // 아웃
		
		int r = 0;
		outer : while(r<N) {
			for(int c=0; c<9; c++) {
				if (r==N) {
					break outer;
				}
				switch (map[r][c]) {
				case 4: // 홈런 : 쌓인 주자수+1 만큼 점수 추가
					score += 1+base.get(1)+base.get(2)+base.get(3); // 1,2,3루 주자 + 타자 홈인
					base.put(1, 0);
					base.put(2, 0);
					base.put(3, 0);
					break;
				case 3: // 3루타
					score += base.get(1)+base.get(2)+base.get(3); // 1,2,3루 주자 홈인
					base.put(1, 0);
					base.put(2, 0);
					base.put(3, 1); // 타자는 3루수에 
					break;
				case 2: // 2루타
					score += base.get(2)+base.get(3); // 2,3루 주자 홈인
					base.put(3, base.get(1)); // 1루 주자가 3루 주자로 옴  
					base.put(1, 0);
					base.put(2, 1);
					break;
				case 1: // 안타
					score += base.get(3); // 3루 주자 홈인
					base.put(3, base.get(2)); // 2루 주자가 3루 주자로 옴
					base.put(2, base.get(1)); // 1루 주자가 2루 주자로 옴
					base.put(1, 1); // 타자는 1루
					break;
				case 0:
					outCnt++;
					if(outCnt == 3) {
						r++;
						outCnt = 0;
						base.put(1, 0); 	
						base.put(2, 0); 	
						base.put(3, 0); 	
					}
					break;
				}
			}	
		}
		if(score > max) {
			max = score;
		}
	}

	static String src =
			"9\r\n" + 
			"1 2 4 3 0 2 1 0 3\r\n" + 
			"1 2 1 2 0 0 0 0 1\r\n" + 
			"3 4 2 3 1 2 3 4 0\r\n" + 
			"0 1 2 3 4 2 1 0 0\r\n" + 
			"0 0 0 0 0 0 1 4 4\r\n" + 
			"0 4 0 4 0 4 0 4 0\r\n" + 
			"0 4 2 2 2 2 2 2 2\r\n" + 
			"1 1 1 1 1 1 1 1 0\r\n" + 
			"0 2 0 3 0 1 0 2 0"; 
}

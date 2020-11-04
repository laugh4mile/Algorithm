package com.baekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 멀티버스 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader에 System.in 넣기 
	static StringTokenizer tokens; // 입력이 공백포함 문자열이라서 씀
	static int M,N,map[][],map2[][],map3[],arr1[],arr2[]; // 입력값 + 사용할 변수
	public static void main(String[] args) throws IOException { // 메인문. IOException은 던져버림
		input = new BufferedReader(new StringReader(src)); // 입력방향 바꾸기. 제출시 주석처리
		tokens = new StringTokenizer(input.readLine()); // 토큰화
		M = Integer.parseInt(tokens.nextToken());  // 입력
		N = Integer.parseInt(tokens.nextToken());  // 입력
		map = new int[M][N]; // 2차원 배열 만들기
		map2 = new int[M][N]; // map의 순서대로 배열을 만듬
		map3 = new int[M]; // map2의값을 그냥 보기좋게 1차원배열로 만듬 map2[0] = {1,0,2} 이면 map3[0] = 102
		arr1 = new int[N]; // map의 라인별로 끊어줄 1차원 배열
		arr2 = new int[N]; // arr1을 정렬할 1차원배열
		for(int m=0; m<M; m++) { 
			tokens = new StringTokenizer(input.readLine());
			for(int n=0; n<N; n++) {
				map[m][n] = Integer.parseInt(tokens.nextToken());
			}
		} // 여기까지 입력
		
		for(int m=0; m<M; m++) {
			arr1 = map[m]; // map의 m번째 라인을 arr1에 담고
			arr2 = arr1.clone(); // arr1을 arr2에 복사하고
			Arrays.sort(arr2); // arr2를 정렬함
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr1[i] == arr2[j]) { // map2에 순서를 저장하기 위한 if문
						map2[m][i] = j; 
					}
				}
			}
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				map3[i] += map2[i][j]*Math.pow(10, (N-j-1)); // map2의값을 그냥 보기좋게 1차원배열로 만듬 map2[0] = {1,0,2} 이면 map3[0] = 102. 위에서 그냥 map3로 정의하면되겠지만 시간문제상... 
			}
		}
		
		Set<Integer> s = new HashSet<Integer>(); // 중복체크하기 편하게 set씀
		
		for(int i=0; i<M; i++) {
			for(int j=i+1; j<M; j++) {
				if(map3[i]==map3[j]) { // 탐색을하면서 겹치는게 나오면
					s.add(map3[i]); // set에 추가함
				}
			}
		}
		System.out.println(s.size()); // set의 사이즈를 출력하면 끝
	}
	
	
	static String src = 
			"4 3\r\n" + 
			"1 2 3\r\n" + 
			"3 5 6\r\n" +
			"7 8 9\r\n" +
			"10 11 12";
}
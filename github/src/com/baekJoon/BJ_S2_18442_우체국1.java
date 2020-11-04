package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_S2_18442_우체국1 { // 클래스명
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in)); // 입력처리
	static StringTokenizer tokens; // 입력값을 공백단위로 끊어줄 토큰나이저
	static int T, V, P, city[], police[],dist,arr[]; // 변수및 배열 선언
	static long L,result=Long.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException { // 메인문
		input = new BufferedReader(new StringReader(src)); // 예제입력을 적용시키기위해 input을 바꿈. 제출시에는 주석처리해야함
		T = Integer.parseInt(input.readLine()); // 라인단위로 가져온 String을 int형으로 형변환하여 T에 저장
		for(int t=1; t<=T; t++) { // T(테스트 케이스) 만큼 반복 
			tokens = new StringTokenizer(input.readLine()); // 한 라인에 입력값이 2개 이상인경우 토큰나이저 이용
			V = Integer.parseInt(tokens.nextToken()); // 첫번째 토큰을 V로
			P = Integer.parseInt(tokens.nextToken()); // 두번째 토큰을 P로
			L = Long.parseLong(tokens.nextToken()); // 마지막 토큰을 L로
			city = new int[V]; // 도시의 위치를 저장할 배열
			police = new int[P]; // 경찰서의 위치을 저장할 배열
			arr = new int[P]; 
			
			tokens = new StringTokenizer(input.readLine()); // 한 라인에 입력값이 2개 이상인경우 토큰나이저 이용
			for(int v=0; v<V; v++) { // V개만큼 반복
				city[v] = Integer.parseInt(tokens.nextToken()); // city배열에 입력값 할당 
			}
//			System.out.println(V+" "+P+" "+L); // 잘입력되었는지 확인
//			System.out.println(Arrays.toString(city));  // 잘입력되었는지 확인
			combi(0,0); // 조합 ㄱㄱ 
//			System.out.println("#"+t+" "+result); // 출력
			System.out.println(result); // 출력
			result=Long.MAX_VALUE; // case하나가 끝났을 시 result는 다시 초기화함
			for(int i=0; i<P; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}
	private static void combi(int start, int cnt) { // 조합 메서드
		if(cnt == P) { // cnt가 P이면. 즉 P개를 골랐을때까지
//			System.out.println(Arrays.toString(police)); // 조합이 성공했는지 확인
			getDist(); // 이제 최단거리의 합을 구할거임
			
			if(result > dist) { // getDist로 구한 dist가 result보다 작을경우 
				result = dist; // result를 dist로 갱신함
				arr = police.clone();
			}
			
			return; // 리턴
		}
		for(int i=start; i<V; i++) { // 조합을위한 반복
			police[cnt] = city[i]; // 경찰서를 설치할 곳을 고름
			combi(i+1, cnt+1); // 재귀호출
		}
	}
	private static void getDist() { // 최단거리의 합을 구할 메소드
		dist = 0; // dist는 누적되므로 계속 초기화해서 사용해야함
		long minDist = 0; // 최소거리를 담을 변수
		for(int i=0; i<V; i++) { // city의 개수(V)만큼 반복함
			minDist = Long.MAX_VALUE; // 최소값을 구해야하므로 초기값은 MAXVALUE
			for(int j=0; j<P; j++) { // police의 개수(P)만큼 반복함
				if(city[i] == police[j]) { // 만약 고른 도시가 경찰서가 있는 도시라면
					minDist = 0; // 더할 거리가 없다.
					break; // 뒤의 내용을 볼 필요도 없다. 0보다 작은거리는 없으므로
				}else { // 경찰서가 없는 도시를 고를경우
					long d = Math.min(L-Math.abs(city[i]-police[j]), Math.abs(city[i]-police[j])); // 앞쪽과 뒤쪽중에 최소값을 구해서
					if(minDist > d) // minDist보다 작으면
					minDist = d; // 갱신한다
				}
			}
			dist += minDist; // 최종적으로 dist에 minDist를 더해서 메소드에서 탈출한다. 이 dist로 result를 계속 갱신할것이다.
		}
	}
	static String src = // 예제 입력
			"2\r\n" + 
			"10 5 200\r\n" + 
			"1 2 3 6 7 9 11 22 44 50\r\n" + 
			"10 5 51\r\n" + 
			"1 2 3 6 7 9 11 22 44 50";
}

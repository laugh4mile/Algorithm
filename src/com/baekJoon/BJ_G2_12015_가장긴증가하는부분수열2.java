package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G2_12015_가장긴증가하는부분수열2 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N, arr[];
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		N = Integer.parseInt(input.readLine());
		arr = new int[N];
		tokens = new StringTokenizer(input.readLine());
		
		list.add(0);
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
			if(arr[i] > list.get(list.size()-1)) {
				list.add(arr[i]);
			}else {
				int start = 0;
				int end = list.size()-1;
				int mid = 0;
				while(end - start >0){  //start 가 end 와 같지 않고, 넘지 않을 때
			        mid = (start+end)/2;    //중앙 index
			 
			        if(list.get(mid)<arr[i]){ //key 값이 중앙 값보다 크면
			            start = mid + 1;//mid 보다 오른쪽으로
			        }else{  //key 값이 중앙값보다 작거나 같으면
			            end = mid;  //mid 포함 왼쪽 (포함하는 이유는 key값과 같은게 없을 때 큰수중 가장 작은값을 위해)
			        }
			    }
				list.set(end, arr[i]); 
			}
		}
		System.out.println(list.size()-1);
		
		
		

	}
	static String src =
			"6\r\n" + 
			"10 20 10 30 20 50";
}

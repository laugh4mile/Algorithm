package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_B2_2798_블랙잭 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int N,M; // 카드의 개수, 카드의 합
    static String line;
    static int[] card;
    static int max;
    public static void main(String[] args) throws IOException {
//	input = new BufferedReader(new StringReader(src));
	StringTokenizer tokens = new StringTokenizer(input.readLine()," ");
	N = Integer.parseInt(tokens.nextToken());
	M = Integer.parseInt(tokens.nextToken());
//	line = input.readLine();
	card = new int[N];
	tokens = new StringTokenizer(input.readLine()," ");
	for(int i=0; i<N	; i++) {
	    card[i] = Integer.parseInt(tokens.nextToken());
	}
//	System.out.println(closeNum(M, card));
	makeCombination(3, 0, new int[3]);
        System.out.println(max);
//	for(int i=0; i<N; i++) {
//	    System.out.printf("%2d",card[i]);
//	}
	
    }
    
    static void makeCombination(int r, int start, int[] temp) {
        if (r == 0) {
//            System.out.println(Arrays.toString(temp));
            if(max<sumOfArray(temp) && sumOfArray(temp)<=M) {
        	max = sumOfArray(temp);
            }
            
//            System.out.println(sumOfArray(temp));

//            System.out.println(max);
            return;

        }
        for (int i = start; i < card.length; i++) {
            temp[r - 1] = card[i];
            makeCombination(r - 1, i + 1, temp);
        }    
    }
    
    
    static int sumOfArray(int[] arr) {
	int sum=0;
	for(int i=0; i<arr.length; i++) {
	    sum+=arr[i];
	}
	return sum;
    }
    
    static int closeNum(int num, int[] arr) {
	int cNum = Math.abs(num - arr[0]);
	int answer=0;
	for(int i=1; i<arr.length; i++) {
	    if(Math.abs(arr[i]-num)<cNum && arr[i]<=num) {
		answer = arr[i];
		cNum = Math.abs(arr[i]-num);
			
	    }
	}
	return answer;
    }
    
    static String src = "5 21\r\n" + 
    	"5 6 7 8 9";
}

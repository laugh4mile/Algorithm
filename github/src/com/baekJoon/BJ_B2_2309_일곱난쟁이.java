package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

public class BJ_B2_2309_일곱난쟁이 {
    
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int N=9;
    static int[] dwarf = new int[N];
    
    public static void main(String[] args) throws NumberFormatException, IOException {
//	input = new BufferedReader(new StringReader(src));
	for(int i=0; i<N; i++) {
	    dwarf[i] = Integer.parseInt(input.readLine());
	}
        makeCombination(7, 0, new int[7]);
        Arrays.sort(result);
	for(int i=0; i<7; i++) {
	    System.out.println(result[i]);
	}
	
    }
    static int[] result;
    static void makeCombination(int r, int start, int[] temp) {
        if (r == 0) {
            if(sumOfArray(temp) == 100) {
        	result = temp.clone();
//        	Arrays.sort(temp);
//        	System.out.println(Arrays.toString(temp));
            }
            return;
        }
        for (int i = start; i < N; i++) {
            temp[r - 1] = dwarf[i];
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
    
//    static String src = "20\r\n" + 
//    	"7\r\n" + 
//    	"23\r\n" + 
//    	"19\r\n" + 
//    	"10\r\n" + 
//    	"15\r\n" + 
//    	"25\r\n" + 
//    	"8\r\n" + 
//    	"13";
}

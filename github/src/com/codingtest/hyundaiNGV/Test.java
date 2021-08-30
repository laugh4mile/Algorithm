package com.codingtest.hyundaiNGV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Test {
	public static void main(String args[]) throws Exception
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = input.readLine();
        output.append(str.charAt(0));
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == '-'){
                output.append(str.charAt(i+1));
            }
        }
        output.close();
    }
}

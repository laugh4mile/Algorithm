package com.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA_D3_5607_조합 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,R;
	static int p = 1234567891;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			
			System.out.println("#"+t+" "+nCr(N, R, p));
			
		}
	}
	
	static long nCr(int n, int r, int p) {
		if (r==0) {
			return 1L;
		}
		long[] fac = new long[n+1];
		fac[0] = 1;
		
		for(int i=1; i<=n; i++) {
			fac[i] = fac[i-1] * i % p;
		}
		
		return (fac[n] * power(fac[r], p-2, p)
				% p * power(fac[n-r], p-2, p)
				% p) % p;
		
	}
	
	static long power(long x, int y, int p) {
		long res = 1L;
		x = x % p;
		
		while (y>0) {
			if(y%2 == 1) {
				res = (res*x) % p;
			}
			y = y>>1;
		x = (x * x) % p;
		}
		return res;
	}

	static String src = 
			"2\r\n" +
			"4 2\r\n" +
			"10 2";

}

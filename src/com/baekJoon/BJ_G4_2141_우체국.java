package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ_G4_2141_우체국 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());

        long gyeSoo = 0, sangSoo = 0;
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            long x = Long.parseLong(tokens.nextToken());
            long a = Long.parseLong(tokens.nextToken());
            gyeSoo += a;
            sangSoo += x*a;
        }
        long min = Math.min(Math.abs(gyeSoo), Math.abs(sangSoo));
        long max = Math.max(Math.abs(gyeSoo), Math.abs(sangSoo));
        long gdc = getGDC(min, max);
        System.out.println(gdc);

    }

    private static long getGDC(long a, long b) {
        if(a == 0){
            return b;
        }else{
            return getGDC(Math.min(a, b-a), Math.max(a, b-a));
        }
    }

    static String src =
            "3\n" +
                    "1 3\n" +
                    "2 5\n" +
                    "3 3";
}

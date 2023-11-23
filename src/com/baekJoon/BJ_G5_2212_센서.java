package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G5_2212_센서 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        int K = Integer.parseInt(input.readLine());
        int[] arr = new int[N];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        Arrays.sort(arr);
        PriorityQueue<Integer> gap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=1; i<N; i++){
            gap.offer(arr[i] - arr[i-1]);
        }

        while(K > 1){
            if(gap.isEmpty()) break;
            gap.poll();
            K--;
        }

        int answer = 0;
        while (!gap.isEmpty()){
            answer += gap.poll();
        }
        System.out.println(answer);
    }

    static String src =
            "6\n" +
                    "2\n" +
                    "1 6 9 3 6 7";
}

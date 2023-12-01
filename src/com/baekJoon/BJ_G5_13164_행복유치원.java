package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_G5_13164_행복유치원 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());

        tokens = new StringTokenizer(input.readLine());
        int arr[] = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(tokens.nextToken());
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=1; i<N; i++){
            pq.offer(arr[i]- arr[i-1]);
        }

        for(int i=0; i<K-1; i++){
            pq.poll();
        }

        int answer = 0;
        while (!pq.isEmpty()){
            answer += pq.poll();
        }

        System.out.println(answer);
    }

    static String src =
            "5 3\n" +
                    "1 3 5 6 10";
}

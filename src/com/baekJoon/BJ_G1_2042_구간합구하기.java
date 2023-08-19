package com.baekJoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G1_2042_구간합구하기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());

        long arr[] = new long[N+1];
        long sum[] = new long[N+1];
        for(int i=1; i<N+1; i++){
            arr[i] += Long.parseLong(input.readLine());
        }
        sum[1] = arr[1];
        for(int i=2; i<N+1; i++){
            sum[i] = sum[i-1] + arr[i];
        }

        List<Node> list = new ArrayList<>();
        for(int i=0; i<K+M; i++){
            tokens = new StringTokenizer(input.readLine());
            long a = Long.parseLong(tokens.nextToken());
            long b = Long.parseLong(tokens.nextToken());
            long c = Long.parseLong(tokens.nextToken());

            if(a == 1){
                list.add(new Node((int)b, c - arr[(int)b]));
                arr[(int)b] = c;
            }else{
                long temp = 0;
                for(int j=0; j<list.size(); j++){
                    if(list.get(j).idx >= b && list.get(j).idx <=c){
                        temp += list.get(j).num;
                    }
                }
                output.append(sum[(int)c] - sum[(int)b-1] + temp +"\n");
            }
        }
        output.close();
    }

    static class Node {
        int idx;
        long num;

        public Node(int idx, long num) {
            this.idx = idx;
            this.num = num;
        }
    }

    static String src =
            "5 2 2\n" +
                "1\n" +
                "2\n" +
                "3\n" +
                "4\n" +
                "5\n" +
                "1 3 6\n" +
                "2 2 5\n" +
                "1 5 2\n" +
                "2 3 5";
}
package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_G4_2258_정육점 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());

        List<Node> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            tokens = new StringTokenizer(input.readLine());
            int weight = Integer.parseInt(tokens.nextToken());
            int price = Integer.parseInt(tokens.nextToken());
            list.add(new Node(weight, price));
        }

        Collections.sort(list);
        int sum = 0;
        int answer = 0;
        int joongbok = 1;
        int idx = 0;
        for(int i=0; i<N; i++){
            sum += list.get(i).weight;
            if(i>0 && list.get(i).price == list.get(i-1).price){
                joongbok++;
            }else{
                joongbok = 1;
            }
            if(sum >= M){
                answer = list.get(i).price;
                idx = i;
                break;
            }
        }

        if(answer == 0){
            System.out.println(-1);
        }else{
            answer = answer * joongbok;
            for(int i=idx+1; i<N; i++){
                if(list.get(i).price != list.get(idx).price && answer > list.get(i).price){
                    answer = list.get(i).price;
                    break;
                }
            }
            System.out.println(answer);
        }
    }

    static class Node implements Comparable<Node>{
        int weight;
        int price;

        public Node(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Node o){
            if(this.price == o.price){
                return Integer.compare(o.weight, this.weight);
            }
            return Integer.compare(this.price, o.price);
        }
    }

    static String src =
            "4 9\n" +
                    "1 2\n" +
                    "2 4\n" +
                    "3 6\n" +
                    "4 8";
}

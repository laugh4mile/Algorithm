package com.baekJoon;

import java.io.*;
import java.util.*;

public class BJ_G1_10838_트리_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static List<Node> graph[];
//    static int parent[];
    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int K = Integer.parseInt(tokens.nextToken());
//        parent = new int[N];
//        parent[0] = -1; // 0은 부모가 없음 ㅜㅜ

        graph = new List[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            graph[i].add(new Node(0, 0));
        }

        for(int i=0; i<K; i++){
            tokens = new StringTokenizer(input.readLine());
            int r = Integer.parseInt(tokens.nextToken());
            int a = Integer.parseInt(tokens.nextToken());
            int b = Integer.parseInt(tokens.nextToken());
            int c = 0;
            if(r == 1){ // paint
                c = Integer.parseInt(tokens.nextToken());
                int commonParent = getCommonParent(a,b);
                while (a != commonParent){
                    graph[a].get(0).color = c;
                    a = graph[a].get(0).parent;
                }
                while (b != commonParent){
                    graph[b].get(0).color = c;
                    b = graph[b].get(0).parent;
                }
            }else if(r == 2){ // move
//                parent[a] = b;
                graph[a].add(new Node(b, graph[a].get(0).color));
                graph[a].remove(0);
            }else{ // count
                int commonParent = getCommonParent(a,b);
                Set<Integer> set = new HashSet<>();
                while (a != commonParent){
                    set.add(graph[a].get(0).color);
                    a = graph[a].get(0).parent;
                }
                while (b != commonParent){
                    set.add(graph[b].get(0).color);
                    b = graph[b].get(0).parent;
                }
                output.append(set.size()+"\n");
            }
        }
        output.close();

    }
    static int getCommonParent(int a, int b){
        if(a == 0 || b == 0){
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        set.add(a);
        while (a != 0){
//            a = parent[a];
            a = graph[a].get(0).parent;
            set.add(a);
        }
        while (b != 0){
            if(set.contains(b)){
                return b;
            }
            set.add(b);
//            b = parent[b];
            b = graph[b].get(0).parent;
        }
        return 0;
    }
    static class Node{
        int parent;
        int color;

        public Node(int parent, int color) {
            this.parent = parent;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Node{" +
                    ", parent=" + parent +
                    ", color=" + color +
                    '}';
        }
    }


    static String src =
            "7 15\n" +
            "2 3 2\n" +
            "2 4 3\n" +
            "2 5 3\n" +
            "2 6 2\n" +
            "3 1 6\n" +
            "1 3 3 2\n" +
            "1 1 6 5\n" +
            "1 4 2 3\n" +
            "1 2 5 4\n" +
            "1 2 0 7\n" +
            "3 4 6\n" +
            "3 4 1\n" +
            "2 3 2\n" +
            "3 2 2\n" +
            "3 5 6";
}

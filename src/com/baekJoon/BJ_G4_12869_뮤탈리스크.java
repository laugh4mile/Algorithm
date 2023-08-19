package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G4_12869_뮤탈리스크 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int scvs[], size, attack[][] = {
            {1,3,9},
            {1,9,3},
            {3,1,9},
            {3,9,1},
            {9,1,3},
            {9,3,1}
    };
    static boolean isVisited[][][];

    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        int N = Integer.parseInt(input.readLine());
        scvs = new int[3];
        tokens = new StringTokenizer(input.readLine());
        for(int i=0; i<N; i++){
            scvs[i] = Integer.parseInt(tokens.nextToken());
        }
        size = 61;
        isVisited = new boolean[size][size][size];

        System.out.println(bfs(scvs[0], scvs[1], scvs[2]));
    }

    private static int bfs(int scv1, int scv2, int scv3) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(scv1, scv2, scv3, 0));
        visit(scv1, scv2, scv3);


        while(!queue.isEmpty()){
            Node front = queue.poll();
//            System.out.println(front);
            if(front.scv1 <= 0 && front.scv2 <= 0 && front.scv3 <= 0){
                return front.cnt;
            }
            for(int i=0; i<6; i++){
                int n1 = Math.max(front.scv1 - attack[i][0], 0);
                int n2 = Math.max(front.scv2 - attack[i][1], 0);
                int n3 = Math.max(front.scv3 - attack[i][2], 0);

                if(!isVisited[n1][n2][n3]){
                    visit(n1,n2,n3);
                    queue.offer(new Node(n1,n2,n3,front.cnt+1));
                }
            }
        }

        return 0;
    }

    private static void visit(int scv1, int scv2, int scv3) {
        isVisited[scv1][scv2][scv3] = true;
        isVisited[scv1][scv3][scv2] = true;
        isVisited[scv2][scv1][scv3] = true;
        isVisited[scv2][scv3][scv1] = true;
        isVisited[scv3][scv1][scv2] = true;
        isVisited[scv3][scv2][scv1] = true;
    }

    private static class Node {

        int scv1;
        int scv2;
        int scv3;
        int cnt;
        public Node(int scv1, int scv2, int scv3, int cnt) {
            this.scv1 = scv1;
            this.scv2 = scv2;
            this.scv3 = scv3;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "scv1=" + scv1 +
                    ", scv2=" + scv2 +
                    ", scv3=" + scv3 +
                    ", cnt=" + cnt +
                    '}';
        }

    }
    static String src =
            "3\n" +
                    "12 10 4";
}

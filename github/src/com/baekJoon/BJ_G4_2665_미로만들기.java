package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.PriorityQueue;

public class BJ_G4_2665_미로만들기 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static int N, map[][], distance[][];
    static boolean isVisited[][];
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        N = Integer.parseInt(input.readLine());
        map = new int[N][N];
        distance = new int[N][N];
        isVisited = new boolean[N][N];
        for(int r=0; r<N; r++){
            String line = input.readLine();
            for(int c=0; c<N; c++){
                map[r][c] = line.charAt(c) - '0';
                distance[r][c] = Integer.MAX_VALUE;
            }
        }

        dijkstra();
//        for (int x[] : distance){
//            System.out.println(Arrays.toString(x));
//        }
        System.out.println(distance[N-1][N-1]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        distance[0][0] = 0;
        pq.offer(new Node(0,0,0));

        while (!pq.isEmpty()) {
            Node front = pq.poll();
            if(front.r == N-1 && front.c == N-1){
                break;
            }
            if(!isVisited[front.r][front.c]){
                isVisited[front.r][front.c] = true;
                for(int d=0; d<4; d++){
                    int nr = front.r + dr[d];
                    int nc = front.c + dc[d];

                    if(isIn(nr,nc)){
                        if(map[nr][nc] == 0){
                            if(distance[nr][nc] > distance[front.r][front.c] + 1){
                                distance[nr][nc] = distance[front.r][front.c] + 1;
                                pq.offer(new Node(nr,nc, distance[nr][nc]));
                            }
                        }else{
                            distance[nr][nc] = distance[front.r][front.c];
                            pq.offer(new Node(nr,nc,distance[nr][nc]));
                        }
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int r;
        int c;
        int v;

        public Node(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.v, o.v);
        }
    }

    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};

    static boolean isIn(int r, int c){
        return(r>=0 && c>=0 && r<N && c<N);
    }

    static String src =
            "8\n" +
                    "11100110\n" +
                    "11010010\n" +
                    "10011010\n" +
                    "11101100\n" +
                    "01000111\n" +
                    "00110001\n" +
                    "11011000\n" +
                    "11000111";
}

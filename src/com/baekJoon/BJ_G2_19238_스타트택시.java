package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class BJ_G2_19238_스타트택시 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int N, map[][], distanceMap[][];
    static boolean isVisited[][];
    static List<Passenger> passengers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        int fuel = Integer.parseInt(tokens.nextToken());

        map = new int[N][N];
        distanceMap = new int[N][N];

        for(int r=0; r<N; r++){
            tokens = new StringTokenizer(input.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }
        tokens = new StringTokenizer(input.readLine());
        int tr = Integer.parseInt(tokens.nextToken())-1;
        int tc = Integer.parseInt(tokens.nextToken())-1;


        for(int i=0; i<M; i++){
            tokens = new StringTokenizer(input.readLine());
            int sr = Integer.parseInt(tokens.nextToken())-1;
            int sc = Integer.parseInt(tokens.nextToken())-1;
            int er = Integer.parseInt(tokens.nextToken())-1;
            int ec = Integer.parseInt(tokens.nextToken())-1;
            int distanceFromDestination = getDistance(sr,sc,er,ec);
            if(distanceFromDestination == -1){
                System.out.println(-1);
                return;
            }
            passengers.add(new Passenger(sr,sc,er,ec, 0, distanceFromDestination));
        }

        while(fuel > 0 && passengers.size()> 0){
            setDistanceMap(tr, tc);
            for(int i=0; i<passengers.size(); i++){
                passengers.get(i).distanceFromTaxi = distanceMap[passengers.get(i).sr][passengers.get(i).sc];
                if(passengers.get(i).distanceFromTaxi == -1){
                    System.out.println(-1);
                    return;
                }
            }
            Collections.sort(passengers);

            if(fuel>=passengers.get(0).distanceFromTaxi + passengers.get(0).distanceFromDestination){
                fuel = fuel - passengers.get(0).distanceFromTaxi + passengers.get(0).distanceFromDestination;
                tr = passengers.get(0).er;
                tc = passengers.get(0).ec;
                passengers.remove(0);
            }else{
                System.out.println(-1);
                return;
            }
        }
        System.out.println(fuel);
    }

    private static void setDistanceMap(int sr, int sc) {
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                distanceMap[r][c] = -1;
            }
        }
        isVisited = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sr,sc,0));
        isVisited[sr][sc] = true;

        while (!queue.isEmpty()){
            Node front = queue.poll();
            distanceMap[front.r][front.c] = front.d;
            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr,nc) && !isVisited[nr][nc] && map[nr][nc] == 0){
                    isVisited[nr][nc] = true;
                    queue.offer(new Node(nr, nc, front.d+1));
                }
            }
        }

    }

    private static int getDistance(int sr, int sc, int er, int ec) {
        isVisited = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(sr, sc, 0));
        isVisited[sr][sc] = true;

        while (!queue.isEmpty()){
            Node front = queue.poll();
            if(front.r == er && front.c == ec){
                return front.d;
            }
            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];

                if(isIn(nr,nc) && !isVisited[nr][nc] && map[nr][nc] == 0){
                    queue.offer(new Node(nr,nc, front.d+1));
                    isVisited[nr][nc] = true;
                }
            }
        }
        return -1; // 벽에 막혔나벼
    }


    static int dr[] = {0,0,-1,1};
    static int dc[] = {-1,1,0,0};
    
    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<N && c<N);
    }
    
    static class Node{
        int r;
        int c;
        int d;

        public Node(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static class Passenger implements Comparable<Passenger>{
        int sr;
        int sc;
        int er;
        int ec;
        int distanceFromTaxi;
        int distanceFromDestination;

        public Passenger(int sr, int sc, int er, int ec, int distanceFromTaxi, int distanceFromDestination) {
            this.sr = sr;
            this.sc = sc;
            this.er = er;
            this.ec = ec;
            this.distanceFromTaxi = distanceFromTaxi;
            this.distanceFromDestination = distanceFromDestination;
        }

        @Override
        public int compareTo(Passenger o) {
            if(this.distanceFromTaxi == o.distanceFromTaxi){
                if(this.sr == o.sr){
                    return Integer.compare(this.sc, o.sc);
                }
                return Integer.compare(this.sr, o.sr);
            }
            return Integer.compare(this.distanceFromTaxi, o.distanceFromTaxi);
        }

    }

    static String src =
            "6 3 100\n" +
                    "0 0 1 0 0 0\n" +
                    "0 0 1 0 0 0\n" +
                    "0 0 0 1 0 0\n" +
                    "0 0 0 1 0 0\n" +
                    "0 0 0 0 1 0\n" +
                    "0 0 0 1 0 0\n" +
                    "6 5\n" +
                    "2 2 5 6\n" +
                    "5 4 1 6\n" +
                    "4 2 3 5";
}

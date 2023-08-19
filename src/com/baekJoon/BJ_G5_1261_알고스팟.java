package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.PriorityBlockingQueue;

public class BJ_G5_1261_알고스팟 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int R, C;
    static char[][] map;
    static int MIN = Integer.MAX_VALUE;
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine(), " ");
        C = Integer.parseInt(tokens.nextToken());
        R = Integer.parseInt(tokens.nextToken());
        map = new char[R][C];

        for (int r = 0; r < R; r++) {
            map[r] = input.readLine().toCharArray();
        }
        /*        // 입력 확인
        for(char [] row: map) {
            System.out.println(Arrays.toString(row));
        }*/
        bfs(0, 0);
        System.out.println(MIN);
    }

    static void bfs(int r, int c) {
        boolean[][] visited = new boolean[R][C];

        Point start = new Point(0, 0, 0);

        PriorityQueue<Point> queue = new PriorityQueue<>();// 우선순위로 자료 관리
        //Queue<Point> queue = new LinkedList<>();// 입력순으로 자료 관리
        
        queue.offer(start);
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Point front = queue.poll();
            // 지금 지점이 솔루션???
            if (front.r == R - 1 && front.c == C - 1) {
                MIN = Math.min(MIN, front.cost);
            }

            // 사방 탐색
            for (int d = 0; d < dirs.length; d++) {
                int nr = front.r + dirs[d][0];
                int nc = front.c + dirs[d][1];
                if(isIn(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc]=true;
                    // 내가 가는 지점이 벽? 공백?
                    if(map[nr][nc]=='1') {
                        queue.offer(new Point(nr, nc, front.cost + 1));
                    }else {
                        queue.offer(new Point(nr, nc, front.cost));
                    }
                }
            }
            // 이 상황에서 필요한 것은???? 노드들을 정렬!! - cost 기준
        }
    }

    static boolean isIn(int r, int c) {
        return 0 <= r && r < R && 0 <= c && c < C;
    }

    static class Point implements Comparable<Point>{
        int r;
        int c;
        int cost;

        public Point(int r, int c, int cost) {
            super();
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "[(" + r + "," + c + "), cost=" + cost + "]";
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static String src = "4 2\r\n" + 
            "0001\r\n" + 
            "1000";
}

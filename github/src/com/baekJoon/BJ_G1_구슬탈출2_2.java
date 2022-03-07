package com.baekJoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 구슬이 움직이는 순서가 중요할듯? (ex.왼쪽으로 기울일 때, 왼쪽에 있는 구슬을 먼저 이동)
 * 이동한 결과가 중복되서 나오면 안될듯? // 가지치기단계
 * 최소 횟수이므로 결국 bfs 쪽일듯? // 아닌듯
 * 빨간 구슬이 들어가도 파란구슬이 들어가면 나가리임
 * 10회 초과로 움직이면 안댐.
 *
 * 1. 입력
 * 2. 초기위치에서 bfs(4방 탐색) //장애물에 막혀 움직일 수 없을 때까지
 * 3. 파란구슬 빠지면 빠꾸
 */

public class BJ_G1_구슬탈출2_2 {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokens;
    static int R, C, rr, rc, br, bc, or, oc, cnt = -1;
    static boolean isVisited[][][][];
    static char map[][];
    public static void main(String[] args) throws Exception{
        input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        map = new char[R][C];
        isVisited = new boolean[R][C][R][C];
        for(int r=0; r<R; r++){
            String line = input.readLine();
            for(int c=0; c<C; c++){
                map[r][c] = line.charAt(c);
                if(map[r][c] == 'R'){
                    rr = r;
                    rc = c;
                    map[r][c] = '.';
                }
                if(map[r][c] == 'B'){
                    br = r;
                    bc = c;
                    map[r][c] = '.';
                }
                if(map[r][c] == 'O'){
                    or = r;
                    oc = c;
                    map[r][c] = '.';
                }
            }
        }


        Node redBall = new Node(rr, rc);
        Node blueBall = new Node(br, bc);
        for(int d=0; d<4; d++){ // 4방향으로 전부 기울여 보자
            moveBoard(redBall, blueBall);
        }
        System.out.println(cnt);
    }

    private static void moveBoard(Node redBall, Node blueBall) {
        Queue<Balls> queue = new LinkedList<>();
        queue.offer(new Balls(redBall, blueBall, 0));

        while (!queue.isEmpty()){
            Balls front = queue.poll();

            if(front.blue.r == 0 && front.blue.c == 0){
                continue;
            }
            if(front.red.r == 0 && front.red.c == 0){
                cnt = front.cnt;
                break;
            }
            if(front.cnt > 10){
                break;
            }

            if(!isVisited[front.red.r][front.red.c][front.blue.r][front.blue.c]){
                isVisited[front.red.r][front.red.c][front.blue.r][front.blue.c] = true;
                for(int d=0; d<4; d++){
                    queue.offer(getNextBalls(front, d));
                }
            }
        }
    }

    private static Balls getNextBalls(Balls balls, int dir) {
        Node redBall = balls.red;
        Node blueBall = balls.blue;
        if(dir == 0){
            if(redBall.r < blueBall.r){
                redBall = moveBall(redBall, blueBall, dir);
                blueBall = moveBall(blueBall, redBall, dir);
            }else{
                blueBall = moveBall(blueBall, redBall, dir);
                redBall = moveBall(redBall, blueBall, dir);
            }
        }else if(dir == 1){
            if(redBall.r < blueBall.r){
                blueBall = moveBall(blueBall, redBall, dir);
                redBall = moveBall(redBall, blueBall, dir);
            }else{
                redBall = moveBall(redBall, blueBall, dir);
                blueBall = moveBall(blueBall, redBall, dir);
            }
        }else if(dir == 2){
            if(redBall.c < blueBall.c){
                redBall = moveBall(redBall, blueBall, dir);
                blueBall = moveBall(blueBall, redBall, dir);
            }else{
                blueBall = moveBall(blueBall, redBall, dir);
                redBall = moveBall(redBall, blueBall, dir);
            }
        }else {
            if(redBall.c < blueBall.c){
                blueBall = moveBall(blueBall, redBall, dir);
                redBall = moveBall(redBall, blueBall, dir);
            }else{
                redBall = moveBall(redBall, blueBall, dir);
                blueBall = moveBall(blueBall, redBall, dir);
            }
        }
        return new Balls(redBall, blueBall, balls.cnt+1);
    }

    private static Node moveBall(Node moveBall, Node fixBall, int dir){ // 공 움직이는 함수.
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(moveBall.r, moveBall.c));

        while(!queue.isEmpty()){
            Node front = queue.poll();
            if(front.r == or && front.c == oc){ // 구멍에 빠질 경우
                return new Node(0,0);
            }

            int nr = front.r + dr[dir];
            int nc = front.c + dc[dir];
            if(nr == fixBall.r && nc == fixBall.c){ // 구슬에 막힐 경우
                return front;
            }
            if(isIn(nr, nc) && map[nr][nc] == '#'){ // 다음칸이 벽일 경우
                return front;
            }
            if(isIn(nr,nc) && map[nr][nc] != '#'){ // 다음칸이 벽이 아닐경우
                queue.offer(new Node(nr,nc));
            }
        }
        return null;
    }
    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<R && c<C);
    }
    static int dr[] = {-1,1,0,0}; // 상하좌우
    static int dc[] = {0,0,-1,1};

    static class Balls{
        Node red;
        Node blue;
        int cnt;

        public Balls(Node red, Node blue, int cnt) {
            this.red = red;
            this.blue = blue;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Balls{" +
                    "red=" + red +
                    ", blue=" + blue +
                    ", cnt=" + cnt +
                    '}';
        }
    }
    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }
    }

    static String src =
            "5 5\n" +
                    "#####\n" +
                    "#..B#\n" +
                    "#.#.#\n" +
                    "#RO.#\n" +
                    "#####";
}

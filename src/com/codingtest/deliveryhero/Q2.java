package com.codingtest.deliveryhero;

import java.util.LinkedList;
import java.util.Queue;

public class Q2 {
	int R, C;
    boolean isVisited[][];
    char map[][];
    public int[] solution(String[] B) {
        // write your code in Java SE 8
        int[] answer = new int[3]; // P, S, D
        R = B.length;
        C = B[0].length();
        isVisited = new boolean[R][C];
        map = new char[R][C];
        
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                map[r][c] = B[r].charAt(c);
            }
        }
        // for(char x[] : map){
        //     System.out.println(Arrays.toString(x));
        // }
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(!isVisited[r][c] && map[r][c] == '#'){
                    int ship = bfs(r,c);
                    if(ship == 1){
                        answer[0]++;
                    }else if(ship == 2){
                        answer[1]++;
                    }else{
                        answer[2]++;
                    }
                }
            }
        }
        return answer;
    }
    public int bfs(int r, int c){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(r,c));
        isVisited[r][c] = true;
        int cnt = 0;

        while(!queue.isEmpty()){
            Node front = queue.poll();
            cnt++;
            for(int d=0; d<4; d++){
                int nr = front.r + dr[d];
                int nc = front.c + dc[d];
                if(isIn(nr,nc) && !isVisited[nr][nc] && map[nr][nc] == '#'){
                    queue.offer(new Node(nr, nc));
                    isVisited[nr][nc] = true;
                }

            }
        }
        return cnt;
    }

    public class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public int dr[] = {0,0,1,-1};
    public int dc[] = {1,-1,0,0};

    public boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<R && c<C);
    }
}

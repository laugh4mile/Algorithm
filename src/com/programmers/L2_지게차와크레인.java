package com.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L2_지게차와크레인 {
    public static int solution(String[] storage, String[] requests) {
        int answer = 0;
        int R = storage.length+2;
        int C = storage[0].length()+2;
        char [][] map = new char[R][C];

        for(int r=0; r<R; r++){
            Arrays.fill(map[r], '0');
        }

        for(int r=0; r<storage.length; r++){
            String line = storage[r];
            for(int c=0; c<storage[r].length(); c++){
                map[r+1][c+1] = line.charAt(c);
            }
        }

//        for(char[] x: map){
//            System.out.println(Arrays.toString(x));
//        }

        for(int i=0; i<requests.length; i++){
            if(requests[i].length() == 1){
                isVisited = new boolean[R][C];
                map = bfs(map, requests[i].charAt(0));
            }else{
                char container = requests[i].charAt(0);
                for(int r=1; r<R-1; r++){
                    for(int c=1; c<C-1; c++){
                        if(map[r][c] == container){
                            map[r][c] = '0';
                        }
                    }
                }
            }
//            System.out.println();
//            for(char[] x: map){
//                System.out.println(Arrays.toString(x));
//            }
        }

        for(int r=1; r<R-1; r++){
            for(int c=1; c<C-1; c++){
                if(map[r][c] != '0'){
                    answer ++;
                }
            }
        }
        return answer;
    }

    private static char[][] bfs(char[][] map , char container) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        isVisited[0][0] = true;
        ArrayList<int[]> list = new ArrayList<>();

        while(!queue.isEmpty()){
            int[] front = queue.poll();

            if(map[front[0]][front[1]] == container){
                list.add(new int[]{front[0], front[1]});
                continue;
            }

            for(int d=0; d<4; d++){
                int nr = front[0] + dr[d];
                int nc = front[1] + dc[d];

                if(isIn(nr, nc, map.length, map[0].length) && !isVisited[nr][nc] && (map[nr][nc] == '0' || map[nr][nc] == container) ){
                    queue.offer(new int[]{nr, nc});
                    isVisited[nr][nc] = true;
                }
            }
        }

//        System.out.println(list);

        for(int i=0; i<list.size(); i++){
            map[list.get(i)[0]][list.get(i)[1]] = '0';
        }
        return map;
    }

    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean isVisited[][];
    static boolean isIn(int r, int c, int R, int C){
        return (r>=0 && c>=0 && r<R && c<C);
    }



    public static void main(String[] args) {
        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = {"A", "BB", "A"};

        System.out.println(solution(storage, requests));
    }
}

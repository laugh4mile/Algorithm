package com.programmers;
import java.util.*;

public class L2_충돌위험찾기 {

    static Map<String, Integer> map = new HashMap<>();

    public static int solution(int[][] points, int[][] routes) {
        int answer = 0;

        for(int i=0; i<routes.length; i++){
            int time = 0;

            for(int j=1; j<routes[i].length; j++){
                int startPoint = routes[i][j-1] -1;
                int endPoint   = routes[i][j] -1;

                int sr = points[startPoint][0];
                int sc = points[startPoint][1];

                int er = points[endPoint][0];
                int ec = points[endPoint][1];

                if(time == 0){
                    String key = sr+" "+sc+" "+time;
                    if(map.get(key) == null){
                        map.put(key, 1);
                    }else{
                        map.put(key, map.get(key)+1);
                    }
                }

                time = move(sr, sc, er, ec, time);
            }
        }

        System.out.println(map);

        for(String key : map.keySet()){
            if(map.get(key) > 1){
                answer++;
            }
        }
        return answer;
    }

    private static int move(int sr, int sc, int er, int ec, int t) {
        int r = sr;
        int c = sc;

        int dirR = 1;
        int dirC = 1;

        if(sr > er){
            dirR = -1;
        }
        if(sc > ec){
            dirC = -1;
        }

        while(r != er){
            r += dirR;
            t++;
            String key = r+" "+c+" "+t;
            if(map.get(key) == null){
                map.put(key, 1);
            }else{
                map.put(key, map.get(key)+1);
            }
        }

        while(c != ec){
            c += dirC;
            t++;
            String key = r+" "+c+" "+t;
            if(map.get(key) == null){
                map.put(key, 1);
            }else{
                map.put(key, map.get(key)+1);
            }
        }

        return t;
    }

    public static void main(String[] args) {
        int A[][] = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int B[][] = {{4, 2}, {1, 3}, {2, 4}};

        solution(A, B);
    }
}
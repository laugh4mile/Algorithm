package com.codingtest.line.fintechIntern;

public class Q4 {
    static int[][] needs = {{ 1, 0, 0 }, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1},{0,1,0}};
    static int r = 2;
    public static void main(String[] args) {
        System.out.println(solution(needs,r));
    }

    public static int solution(int[][] needs, int r) {
        map = needs.clone();
        result = new int[r]; // 2개의 로봇이 처리할 수 있는 부품
        combi(0,0);
        return max;
    }
    static int result[], map[][], max, R;
    private static void combi(int start, int cnt) {
        if(cnt == R){ // 로봇 2개 다 고름
            getMax(result);
            return;
        }
        for(int i=start; i<map[0].length; i++){
            result[cnt] = i;
            combi(i+1, cnt+1);
        }
    }

    private static void getMax(int[] result) {
        int cnt = 0;
        outer: for(int r=0; r<map.length; r++){
            for(int c=0; c<map[0].length; c++){
                if(map[r][c] == 1 && (result[0] == c || result[1] == c) == false){
                    continue outer;
                }
            }
            cnt++;
        }
        max = Math.max(max, cnt);
    }
}

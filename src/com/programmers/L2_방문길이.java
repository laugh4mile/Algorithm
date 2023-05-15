package com.programmers;

class L2_방문길이 {
    static int R = 11, C = 11;

    public static int solution(String dirs) {
        int answer = 0;
        boolean isVisited[][][][] = new boolean[R][C][R][C];
        int r = 5;
        int c = 5;
        int nr = r;
        int nc = c;
        for(int i=0; i<dirs.length(); i++){
            char command = dirs.charAt(i);
            if(command == 'U'){
                nr = r-1;
                nc = c;
            }else if(command == 'D'){
                nr = r+1;
                nc = c;
            }else if(command == 'L'){
                nr = r;
                nc = c-1;
            }else{
                nr = r;
                nc = c+1;
            }
            if(isIn(nr, nc)){
                if(!isVisited[r][c][nr][nc]){
                    isVisited[r][c][nr][nc] = true;
                    isVisited[nr][nc][r][c] = true;
                    answer++;
                }
                r = nr;
                c = nc;
            }
            System.out.println(r+" "+c);
        }
        return answer;
    }

    public static void main(String[] args) {
        String dirs = "RURRRRRRU";
//        String dirs = "ULDRULDRULDRULDR";
        System.out.println(solution(dirs));
    }

    static boolean isIn(int r, int c){
        return (r>=0 && c>=0 && r<R && c<C);
    }
}
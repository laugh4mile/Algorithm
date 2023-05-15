package com.codingtest.kakao.블라인드2021;

public class Q7 {
	static int[][] board = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
	static int[] aloc = {1,0};
	static int[] bloc = {1,2};
	public static void main(String[] args) {
		solution(board, aloc, bloc);
	}
	
	public static int solution(int[][] board, int[] aloc, int[] bloc) {
        int answer = -1;
        dfs(board, aloc[0], aloc[1], bloc[0], bloc[1], 0, 0);
        System.out.println(max);
        answer = max;
        return answer;
    }
	static int max;
	private static void dfs(int[][] board, int ar, int ac, int br, int bc, int aMove, int bMove) {
		System.out.println(ar+" "+ac+" : "+br+" "+bc);
		if(max < aMove+bMove) {
			max = aMove+bMove;
		}
		for(int ad=0; ad<4; ad++) {
			int nAr = ar + dr[ad];  
			int nAc = ac + dc[ad];
			if(isIn(nAr, nAc, board.length, board[0].length) && board[nAr][nAc] == 1) {
				for(int bd=0; bd<4; bd++) {
					int nBr = br + dr[bd];  
					int nBc = bc + dc[bd];

					if(isIn(nBr, nBc, board.length, board[0].length) && board[nBr][nBc] == 1) {
//						board[ar][ac] = 0;
//						board[br][bc] = 0;
//						dfs(board, nAr, nAc, nBr, nBc, aMove+1, bMove+1);
//						board[ar][ac] = 1;
//						board[br][bc] = 1;
						board[nAr][nAc] = 0;
						board[nBr][nBc] = 0;
						dfs(board, nAr, nAc, nBr, nBc, aMove+1, bMove+1);
						board[nAr][nAc] = 1;
						board[nBr][nBc] = 1;
					}else {
						if(max < aMove+bMove) {
							max = aMove+bMove;
						}
					}
				}
			}else {
				if(max < aMove+bMove) {
					max = aMove+bMove;
				}
			}
		}
	}
	
	static int dr[] = {1,-1,0,0};
	static int dc[] = {0,0,1,-1};
	
	static boolean isIn(int r, int c, int N, int M) {
		return (r>=0 && c>=0 && r<N && c<M);
	}
}

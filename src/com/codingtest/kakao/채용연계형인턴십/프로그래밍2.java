package com.codingtest.kakao.채용연계형인턴십;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 프로그래밍2 {
	static String[][] places = {
			{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
			{"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, 
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
			{"POPOO", "OXOOO", "OOOOO", "OOOOO", "OOOOO"}
//			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
			};
	
	static boolean isVisited[][];
	static char map[][];
	static int N = 5;
	static int dist[][];
	
	public static int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};
//        N = places.length;
        for(int t=0; t<places.length; t++) {
//        	System.out.println(t+1+"번째 대기실");
        	map = new char[N][N];
        	
        	for(int r=0; r<N; r++) {
        		String line = places[t][r];
        		for(int c=0; c<N; c++) {
        			map[r][c] = line.charAt(c);
        		}
        	}
        	
        	outer : for(int r=0; r<N; r++) {
        		for(int c=0; c<N; c++) {
            		if(map[r][c] == 'P') {
            			dist = new int[N][N];
            			isVisited = new boolean[N][N];
            			if(!bfs(r,c)) {
//            				System.out.println((t+1)+"번째 대기실 에서, (r,c)은 "+r+","+c+" 일때 오류");
            				answer[t] = 0;
            				break outer;
            			}
            		}
            	}
        	}
        }
//        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
	
	private static boolean bfs(int r, int c) {
		boolean flag = true;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		isVisited[r][c] = true;
		
		while(!queue.isEmpty()) {
			Node front = queue.poll();
			if(dist[front.r][front.c] > 2) {
				break;
			}
			boolean isStart = false;
			if(front.r == r && front.c == c) {
				isStart = true;
			}
			if(!isStart && map[front.r][front.c] == 'P') {
				flag = false;
				break;
			}
			for(int d=0; d<4; d++) {
				int nr = front.r + dr[d];
				int nc = front.c + dc[d];
				
				if(isIn(nr, nc) && !isVisited[nr][nc] && map[nr][nc] != 'X') {
					queue.offer(new Node(nr, nc));
					isVisited[nr][nc] = true;
					dist[nr][nc] = dist[front.r][front.c] + 1;
				}
			}
		}
		
		return flag;
	}
	
	static class Node{
		int r;
		int c;
		public Node(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int dr[] = {0,0,-1,1};
	static int dc[] = {-1,1,0,0};

	static boolean isIn(int r, int c) {
		return (r>=0 && r<N && c>=0 && c<N);
	}
	
	public static void main(String[] args) {
		solution(places);
	}
}

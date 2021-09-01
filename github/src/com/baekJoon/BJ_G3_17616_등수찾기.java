package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_G3_17616_등수찾기 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;

	public static void main(String args[]) throws Exception{
		input = new BufferedReader(new StringReader(src));
        tokens = new StringTokenizer(input.readLine());
        int N = Integer.parseInt(tokens.nextToken());
        int M = Integer.parseInt(tokens.nextToken());
        int X = Integer.parseInt(tokens.nextToken());

        List<Integer> list1[] = new List[N+1];
        List<Integer> list2[] = new List[N+1];
        for(int i=0; i<N+1; i++){
            list1[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }
        for(int m=0; m<M; m++){
            tokens = new StringTokenizer(input.readLine());
            int A = Integer.parseInt(tokens.nextToken());
            int B = Integer.parseInt(tokens.nextToken());
            // System.out.println(A+" "+B);
            list1[A].add(B);
            list2[B].add(A);
        }
//        for(int i=1; i<N+1;i++) {
//        	System.out.println(list1[i]);
//        }
//        System.out.println();
        int max = bfs(list2, X, N, 2);
        int min = bfs(list1, X, N, 1);
        System.out.println(max+" "+min);
        
    }
	public static int bfs(List[] list, int X, int N, int kind){
        int max = 0;
        boolean isVisited[] = new boolean[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(X);
        isVisited[X] = true;
        int cnt = 0;
        while(!queue.isEmpty()){
            int front = queue.poll();
            if(cnt > max){
                max = cnt;
            }
            List<Integer> childs = list[front];
            for(int i=0; i<childs.size(); i++){
                int child = childs.get(i);
                
                if(!isVisited[child]){
                    queue.offer(child);
                    isVisited[child] = true;
                    cnt++;
                }
            }
        }
        if(kind == 1){ // list1 인 경우
            return N-max;
        }else{
            return max+1;
        }
    }

	static String src =
			"5 4 1\r\n" + 
			"1 2\r\n" + 
			"2 3\r\n" + 
			"3 4\r\n" + 
			"4 5";
}

package com.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author yhs
 * @date 2021. 4. 30
 * @see
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 노드의 개수 n은 2 이상 20,000 이하입니다.
 * 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
 * vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
 * [입력사항]
 * 노드의 개수 n, 
 * 간선에 대한 정보가 담긴 2차원 배열 edge
 * [출력사항]
 */

public class 프로그래머스_L3_가장먼노드 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static int n = 6;
	static int [][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
	
	
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        return answer;
    }
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		solution(n, edge);
	}
}

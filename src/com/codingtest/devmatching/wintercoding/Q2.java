package com.codingtest.devmatching.wintercoding;

public class Q2 {
//	static int time = 100;
//	static int gold = 200;
//	static int upgrade[][] = {{0, 5}, {1500, 3}, {3000, 1}};
	static int time = 11;
	static int gold = 1000;
	static int upgrade[][] = {{0, 5}, {100, 4}, {200, 3}};
	public static void main(String[] args) {
		System.out.println(solution(time, gold, upgrade));
	}
	public static int solution(int time, int gold, int[][] upgrade) {
		int answer = -1;
        int level = 0;
        int sum = 0;
        int work = 0;
        int c_time = time; 
        while(c_time >0) {
        	if(level < upgrade.length && sum >= upgrade[level][0]) {
        		sum -= upgrade[level][0];
        		work = upgrade[level][1];
        		level++;
        	}
        	if(answer < sum + c_time/work * gold) {
        		answer = sum + c_time/work * gold;
        	}
        	c_time-=work;
        	sum += gold;
        }
//        System.out.println(answer);
        return answer;
    }
}

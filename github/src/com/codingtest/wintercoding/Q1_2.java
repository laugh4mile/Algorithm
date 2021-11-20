package com.codingtest.wintercoding;

import java.util.StringTokenizer;

public class Q1_2 {
	static String character = "10 5 2"; // [체력, 공격력, 방어력]
	static String[] monsters = {"Knight 3 10 10 3","Wizard 5 10 15 1","Beginner 1 1 15 1"}; //[이름, 경험치, 체력, 공격력, 방어력]
	public static void main(String[] args) {
		System.out.println(solution(character, monsters));
	}
	public static String solution(String character, String[] monsters) {
        String answer = "";
        StringTokenizer tokens = new StringTokenizer(character);
        int hp = Integer.parseInt(tokens.nextToken());
        int atc = Integer.parseInt(tokens.nextToken());
        int def = Integer.parseInt(tokens.nextToken());
        double max = 0;
        
        outer: for(int i=0; i<monsters.length; i++) {
        	tokens = new StringTokenizer(monsters[i]);
        	String monster = tokens.nextToken();
        	int exp = Integer.parseInt(tokens.nextToken());
        	int m_hp = Integer.parseInt(tokens.nextToken());
        	int m_atc = Integer.parseInt(tokens.nextToken());
        	int m_def = Integer.parseInt(tokens.nextToken());
        	if(atc <= m_def) continue;
    		int cnt = (int) Math.floor(m_hp / atc-m_def);
    		double expPerSec = (double)exp/cnt;
        	
        	if(max < expPerSec) {
        		max = expPerSec;
        		answer = monster;
        	}
        }
        return answer;
    }
}

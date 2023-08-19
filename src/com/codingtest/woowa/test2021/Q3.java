package com.codingtest.woowa.test2021;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q3 {
//	static String[] ings = {"r 10", "a 23", "t 124", "k 9"};
//	static String[] menu = {"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"};
//	static String[] sell = {"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"};
	static String[] ings = {"x 25", "y 20", "z 1000"};
	static String[] menu = {"AAAA xyxy 15", "TTT yy 30", "BBBB xx 30"};
	static String[] sell = {"BBBB 3", "TTT 2"};
	
	public static void main(String[] args) {
		int answer = solution(ings, menu, sell);
		System.out.println(answer);
	}
	
	public static int solution(String[] ings, String[] menu, String[] sell) {
        int answer = 0;
        int ingredient[] = new int[26];
        StringTokenizer tokens;
        for(int i=0; i<ings.length; i++) {
        	tokens = new StringTokenizer(ings[i]);
        	char ingName = tokens.nextToken().charAt(0);
        	int ingPrice = Integer.parseInt(tokens.nextToken());
        	ingredient[ingName-'a'] = ingPrice; // 알파벳 순서의 인덱스에 가격을 저장함.
        }
        
        Map<String, Integer> menuMap = new HashMap<>(); // 메뉴와 수익
        for(int i=0; i<menu.length; i++) {
        	tokens = new StringTokenizer(menu[i]);
        	String menuName = tokens.nextToken();
        	String menuIngs = tokens.nextToken();
        	int menuPrice = Integer.parseInt(tokens.nextToken());
        	int ingsCost = 0;
        	for(int j=0; j<menuIngs.length(); j++) {
        		ingsCost += ingredient[menuIngs.charAt(j) - 'a'];
        	}
        	menuMap.put(menuName, menuPrice-ingsCost);
        }
        
        for(int i=0; i<sell.length; i++) {
        	tokens = new StringTokenizer(sell[i]);
        	String menuName = tokens.nextToken();
        	int salesVolume = Integer.parseInt(tokens.nextToken());
        	answer += (menuMap.get(menuName) * salesVolume);
        }
        
        return answer;
    }
}

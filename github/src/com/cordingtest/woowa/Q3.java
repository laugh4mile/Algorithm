package com.cordingtest.woowa;

public class Q3 {
	public static void main(String[] args) {
		int money = 1000;
		String[] expected = {"H", "T", "H", "T", "H", "T", "H"}; 
		String[] actual = {"T", "T", "H", "H", "T", "T", "H"};
		//result 는 1400
		int answer = -1;
		
		int size = expected.length;
//		System.out.println(size);
		
		int bettingMoney = 100;
		
		for(int i=0; i<size; i++) {
			if(money <= 0) {
				break;
			}
			
			if(expected[i].equals(actual[i])) {
				money += bettingMoney;
				bettingMoney = 100;
			}else {
				money -= bettingMoney;
				bettingMoney *= 2;
				if(bettingMoney > money) {
					bettingMoney = money;
				}
			}
		}
		System.out.println(money);
		
	}
	
	class Solution {
	    public int solution(int money, String[] expected, String[] actual) {
	        int answer = -1;
	        return answer;
	    }
	}
}

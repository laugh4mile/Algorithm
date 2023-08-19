package com.codingtest.kakao.블라인드2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;


public class Q3 {
	static int[] fees = {180, 5000, 10, 600};
	static String[] records = {
			"05:34 5961 IN", 
			"06:00 0000 IN", 
			"06:34 0000 OUT", 
			"07:59 5961 OUT", 
			"07:59 0148 IN", 
			"18:59 0000 IN", 
			"19:09 0148 OUT", 
			"22:59 5961 IN", 
			"23:00 5961 OUT"
			}; 
			
	public static void main(String[] args) {
		int[] answer = solution(fees, records);
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        Map<String, String> carMap = new HashMap<>();
        Map<String, Integer> answerMap = new HashMap<>();
        StringTokenizer tokens;
        for(int i=0; i<records.length; i++) {
        	tokens = new StringTokenizer(records[i]);
        	String time = tokens.nextToken(); 
        	String carNum = tokens.nextToken();
        	String state = tokens.nextToken();
        	if(answerMap.get(carNum) == null) {
        		answerMap.put(carNum, 0);
        	}
        	
        	if(state.equals("IN")) {
    			carMap.put(carNum, time); // 이미 있는 경우는 없다.
        	}else {
        		int tt = Integer.parseInt(time.substring(0, 2)) - Integer.parseInt(carMap.get(carNum).substring(0,2));
        		int mm = Integer.parseInt(time.substring(3, 5)) - Integer.parseInt(carMap.get(carNum).substring(3,5));
        		int sum = tt*60+mm;
        		answerMap.replace(carNum, answerMap.get(carNum) + sum);
        		carMap.remove(carNum);
        	}
        }
        for(Entry<String, String> en : carMap.entrySet()) {
        	String carNum = en.getKey();
        	String time = en.getValue();
        	int tt = 23 - Integer.parseInt(time.substring(0, 2));
        	int mm = 59 - Integer.parseInt(time.substring(3,5));
        	int sum = tt*60+mm;
        	if(answerMap.get(carNum) == null) {
        		answerMap.put(carNum, sum);
        	}else {
        		answerMap.replace(carNum, answerMap.get(carNum) + sum);
        	}
        }
        List<Car> list = new ArrayList<>();
        for(Entry<String, Integer> en : answerMap.entrySet()) {
        	list.add(new Car(en.getKey(), en.getValue()));
        }
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
        	answer[i] = getFee(fees, list.get(i).fee);
        }
        return answer;
    }

	public static int getFee(int[] fees, int mm) {
		if(mm < fees[0]) {
			return fees[1];
		}
		mm -= fees[0];
		double temp = (double)mm/fees[2];
		int num = (int) temp;
		if(temp > num) {
			num++;
		}
		return fees[1] + num * fees[3];
	}
	
	public static class Car implements Comparable<Car>{
		String car;
		int fee;
		
		public Car(String car, int fee) {
			super();
			this.car = car;
			this.fee = fee;
		}
		
		
		@Override
		public String toString() {
			return "Car [car=" + car + ", fee=" + fee + "]";
		}


		@Override
		public int compareTo(Car o) {
			return this.car.compareTo(o.car);
		}
	}
	
}












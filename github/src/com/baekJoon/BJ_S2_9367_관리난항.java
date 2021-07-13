package com.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S2_9367_관리난항 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int T,N,M;
	static Map<String, Car> cars = new HashMap<>();
	static Map<String, Agent> agents = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			for(int n=0; n<N; n++) {
				tokens = new StringTokenizer(input.readLine());
				String cName = tokens.nextToken();
				int cost = Integer.parseInt(tokens.nextToken());
				int rent = Integer.parseInt(tokens.nextToken());
				int perSec = Integer.parseInt(tokens.nextToken());
				cars.put(cName, new Car(cName, cost, rent, perSec));
			}
			for(int m=0; m<M; m++) {
				tokens = new StringTokenizer(input.readLine());
				int time = Integer.parseInt(tokens.nextToken());
				String aName = tokens.nextToken();
				char event = tokens.nextToken().charAt(0);
				String detail = tokens.nextToken();
				
				/* 
				 * 1 event = p 일경우와 p가 아닐경우
				 * 1-1 p이면 기존에 cars.get(aName)가 null 일경우와 아닐 경우로 나눔
				 * 1-1-1 null 일경우 agent.put(aName, new Agent(aName, time, -1, detail))
				 * 1-1-2 null 이 아닐경우 INCONSISTENT
				 * 1-2 p가 아닐경우
				 * 1-2-1 r 일 경우
				 * 1-2-1-1 agent.get(aName).cName이 null 일경우 INCONSISTENT
				 * 1-2-1-2 null 이 아닐경우 agent.get(aName).price +=  Integer.parseInt(detail) * cars.get(agent.get(aName).cName).perSec; 그담에 agent(aName) 초기화
				 * 1-2-2 a 일 경우
				 * 1-2-2-1 agent.get(aName).cName이 null 일경우 INCONSISTENT
				 * 1-2-2-2 null 이 아닐경우 agent.get(aName).price +=  Math.ceil(cars.get(agent.get(aName).cName).cost * Integer.parseInt(detail) / 100);
				*/
				if(event == 'p') {
					if(agents.get(aName) == null) {
						agents.put(aName, new Agent(aName, detail, cars.get(detail).rent));
					}else {
						if(agents.get(aName).cName == null) { // 차를 반납한 첩보원
							
						}else { // 차를 반납하지 않은 상태에서 차를 또 빌리려는 염치없는 새기
//							agents.
						}
					}
				}
			}
			
		}
	}
	static class Car implements Comparable<Car>{
		String cName;
		int cost;
		int rent;
		int perSec;
		
		public Car(String cName, int cost, int rent, int perSec) {
			super();
			this.cName = cName;
			this.cost = cost;
			this.rent = rent;
			this.perSec = perSec;
		}
		@Override
		public int compareTo(Car o) {
			return this.cName.compareTo(o.cName);
		}
	}
	static class Agent{
		String aName;
		String cName;
		int price;
		
		public Agent(String aName, String cName, int price) {
			super();
			this.aName = aName;
			this.cName = cName;
			this.price = price;
		}
	}
	static String src =
			"1\r\n"
			+ "2 8\r\n"
			+ "bmw 5000 150 10\r\n"
			+ "jaguar 7000 200 25\r\n"
			+ "10 mallory p bmw\r\n"
			+ "15 jb p jaguar\r\n"
			+ "20 jb r 500\r\n"
			+ "35 badluckbrian a 100\r\n"
			+ "50 mallory a 10\r\n"
			+ "55 silva p jaguar\r\n"
			+ "60 mallory r 100\r\n"
			+ "110 silva a 30";
}

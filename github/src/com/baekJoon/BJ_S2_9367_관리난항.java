package com.baekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_S2_9367_관리난항 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tokens;
	static int T,N,M;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		input = new BufferedReader(new StringReader(src));
		T = Integer.parseInt(input.readLine());
		for(int t=0; t<T; t++) {
			Map<String, Car> cars = new HashMap<>();
			Map<String, Agent> agents = new HashMap<>();
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
				 * 차를 반납하면 cName = null로 초기화 하자.
				*/
				if(event == 'p') {
					if(agents.get(aName) == null) { // 처음 보는 새기가 빌리는 경우
						agents.put(aName, new Agent(aName, detail, cars.get(detail).rent, false)); // detail=차종
					}else { // 처음 보지 않는 새기가 빌리는 경우
						if(!agents.get(aName).isInconsistent && agents.get(aName).cName == null) { // 부적합이 아니면서 차를 반납한 첩보원, 새로 빌릴 수 있다.
							agents.replace(aName, new Agent(aName, detail, agents.get(aName).price + cars.get(detail).rent, false));
						}else { // 차를 반납하지 않은 상태에서 차를 또 빌리려는 염치없는 새기
							agents.get(aName).isInconsistent = true;
						}
					}
				}else if(event == 'r') {
					if(agents.get(aName) == null) { // 처음 보는데 반납한다고 하는새기
						agents.put(aName, new Agent(aName, null, 0, true)); // 바로 부적합 때려 버리기~
					}else if(agents.get(aName).cName == null){ // 처음은 아니지만 대여도 안했는데 반납한다는 새기
						agents.get(aName).isInconsistent = true;
					}else { // 드디어 정상인 새기
						agents.get(aName).price += cars.get(agents.get(aName).cName).perSec * Integer.parseInt(detail); // detail=주행거리
						agents.get(aName).cName = null; // 반납하면 null로 초기화
					}
				}else if(event == 'a') {
					if(agents.get(aName) == null) { // 처음 보는데 사고났다는 새기
						agents.put(aName, new Agent(aName, null, 0, true)); // 바로 부적합 때려 버리기~
					}else if(agents.get(aName).cName == null){ // 대여도 안했는데 사고났다고 하는 새기
						agents.get(aName).isInconsistent = true;
					}else{ // 정상적으로 사고난 새기
						agents.get(aName).price += Math.ceil((double)cars.get(agents.get(aName).cName).cost * Integer.parseInt(detail) / 100); // doubleㅅㅂ
					}
				}
			}
			List<Agent> result = new ArrayList<>(agents.values());
			Collections.sort(result);
			for(int i=0; i<result.size(); i++) {
				if(result.get(i).cName != null || result.get(i).isInconsistent) {
					output.append(result.get(i).aName + " INCONSISTENT\n");
				}else {
					output.append(result.get(i).aName + " " + result.get(i).price+"\n");
				}
			}
		}
		output.close();
	}
	static class Car {
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
	}
	
	static class Agent implements Comparable<Agent>{
		String aName;
		String cName;
		int price;
		boolean isInconsistent;
		public Agent(String aName, String cName, int price, boolean isInconsistent) {
			super();
			this.aName = aName;
			this.cName = cName;
			this.price = price;
			this.isInconsistent = isInconsistent;
		}
		@Override
		public String toString() {
			return "Agent [aName=" + aName + ", cName=" + cName + ", price=" + price + ", isInconsistent="
					+ isInconsistent + "]";
		}
		@Override
		public int compareTo(Agent o) {
			return this.aName.compareTo(o.aName);
		}
	}
	static String src =
			"1\r\n" + 
			"2 8\r\n" + 
			"bmw 5000 150 10\r\n" + 
			"jaguar 7000 200 25\r\n" + 
			"10 mallory p bmw\r\n" + 
			"15 jb p jaguar\r\n" + 
			"20 jb r 500\r\n" + 
			"35 badluckbrian a 100\r\n" + 
			"50 mallory a 10\r\n" + 
			"55 silva p jaguar\r\n" + 
			"60 mallory r 100\r\n" + 
			"110 silva a 30";
}

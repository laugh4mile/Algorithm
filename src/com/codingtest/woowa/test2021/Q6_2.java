package com.codingtest.woowa.test2021;

public class Q6_2 {
	static double time = 13;
	static String[][] plans = {{"홍콩", "9AM", "19AM"}, {"엘에이", "3PM", "2PM"}, {"뉴요크", "11PM", "9AM"}};
	public static void main(String[] args) {
        System.out.println(solution(time, plans));
    }

    private static String solution(double time, String[][] plans) {
    	String answer = "호치민";
    	double monStartWork = 13;
    	double monEndWork = 18;
    	double priStartWork = 9.5;
    	double priEndWork = 18;
    	
    	for(int i=0; i<plans.length; i++) {
    		String contry = plans[i][0];
    		String startTrip = plans[i][1];
    		String endTrip = plans[i][2];
    		
    		double sT = Integer.parseInt(startTrip.substring(0,startTrip.length()-2));
    		double eT = Integer.parseInt(endTrip.substring(0,endTrip.length()-2));
    		
    		if(startTrip.substring(startTrip.length()-2).equals("PM")) {
    			sT += 12;
    		}
    		
    		if(endTrip.substring(endTrip.length()-2).equals("PM")) {
    			eT += 12;
    		}
    		if(priEndWork > sT) { // 금요일 퇴근시간보다 출발시간이 빠르면 그 만큼 (priEndWork-sT)휴가를 써야한다.
    			if(priStartWork > sT){ // 만약 금요일 출근 시간보다 출발시간이 빠르면 priEndWork-priStartWork 만큼만 휴가 써도 된다.
    				time -= (priEndWork-priStartWork);
    			}else {
    				time -= (priEndWork-sT);
    			}
    		}
    		if(monStartWork < eT) { // 월요일 출근시간보다 도착시간이 늦으면 그 만큼 (eT-monStartWork) 휴가를 써야한다.
    			if(monEndWork < eT) { // 만약 월요일 퇴근 시간보다 도착 시간이 늦으면면 monEndWork-monStartWork 만큼만 휴가 써도 된다.
    				time -= (monEndWork-monStartWork);
    			}else {
    				time -= (eT-monStartWork);
    			}
    		}
    		if(time < 0) { // 휴가시간이 초과되면 종료.
    			break;
    		}
    		answer = contry;
    	}
    	
    	
        return answer;
    }
}

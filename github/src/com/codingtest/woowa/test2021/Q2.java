package com.codingtest.woowa.test2021;

import java.util.StringTokenizer;

public class Q2 {
//	static String[] log = {"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"};
	static String[] log = {"01:00", "08:00", "15:00", "15:04", "23:00", "23:59"};
	
	public static void main(String[] args) {
		String answer = solution(log);
		System.out.println(answer);
	}
	
	public static String solution(String[] log) {
        String answer = "";
        
        int n = log.length;
        StringTokenizer tokens;
        
        int sum = 0;
        for(int i=0; i<n; i+=2) {
        	tokens = new StringTokenizer(log[i],":");
        	int startHH = Integer.parseInt(tokens.nextToken());
        	int startMM = Integer.parseInt(tokens.nextToken());
        	
        	tokens = new StringTokenizer(log[i+1],":");
        	int endHH = Integer.parseInt(tokens.nextToken());
        	int endMM = Integer.parseInt(tokens.nextToken());
        	
        	int start = 60*startHH + startMM;
        	int end = 60*endHH + endMM;
        	int studyTime = end - start; // 분 단위
        	
        	if(studyTime < 5) {
        		continue;
        	}else if(studyTime >= 105) {
        		sum += 105;
        	}else {
        		sum += studyTime;
        	}
        }
        
        int answerHH = sum / 60;
        int answerMM = sum % 60;
        
        StringBuilder sb = new StringBuilder();
        if(answerHH < 10) {
        	sb.append("0"+answerHH);
        }else {
        	sb.append(answerHH);
        }
        sb.append(":");
        if(answerMM < 10) {
        	sb.append("0"+answerMM);
        }else {
        	sb.append(answerMM);
        }
        answer = sb.toString();
        
        return answer;
    }
}

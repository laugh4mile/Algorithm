package com.programmers;

import java.util.HashMap;
import java.util.Map;

public class L1_완주하지못한선수 {
	 public String solution(String[] participant, String[] completion) {
	        String answer = "";
	        
	        Map<String, Integer> map = new HashMap<>();
	        
	        for(int i=0; i<participant.length; i++){
	            if(map.get(participant[i]) == null){
	                map.put(participant[i], 1);
	            }else{
	                map.replace(participant[i], map.get(participant[i])+1);
	            }
	        }
	        
	        for(int i=0; i<completion.length; i++){
	            if(map.get(completion[i]) != null){
	                map.replace(completion[i], map.get(completion[i])-1);
	            }
	        }
	        
	        for(Map.Entry<String, Integer> entry : map.entrySet()){
	            if(entry.getValue() == 1){
	                answer = entry.getKey();
	                break;
	            }
	        }
	        
	        
	        return answer;
	    }
}

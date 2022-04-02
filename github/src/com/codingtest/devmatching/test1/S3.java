package com.codingtest.devmatching.test1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class S3 {
	static String [] enr = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
	static String [] ref = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
	static String [] sel= {"young", "john", "tod", "emily", "mary"};
	static int [] amo = {12, 4, 2, 5, 10};
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int size = enroll.length;
        int[] answer = new int [size];
        enr = enroll;
        ref = referral;
        sel = seller;
        amo = amount;
        
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> master = new HashMap<>();
        for(int i=0; i< referral.length; i++) {
        	master.put(enr[i], ref[i]);
        }
        
        for(int i=0; i< enr.length; i++) {
        	map.put(enr[i], 0);
        }
        for(int i=0; i< sel.length; i++) {
        	int don = amo[i] * 100;
//        	map.replace(sel[i], don);
//        	int theirs = total/10;
//        	int mine = total - theirs;
        	String present = sel[i];
        	while(true) {
        		int soosooryo = don/10;
        		if(map.get(present) == 0) { // 처음 번 돈이다?
        			map.replace(present, don - soosooryo); // 돈 - 수수료를 넣는다
        		}else {
        			map.replace(present, map.get(present) + don - soosooryo);
        		}
        		
        		don = soosooryo;
        		present = master.get(present);
        		if(master.get(present) == null) break;
        	}
        }
        
        for(int i=0; i<size; i++) {
        	answer[i] = map.get(enroll[i]);
        }
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }
	
	public static void main(String[] args) {
		solution(enr, ref, sel, amo);
	}
}

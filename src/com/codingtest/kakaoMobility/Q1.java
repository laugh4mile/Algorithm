package com.codingtest.kakaoMobility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1 {

    static String[] A = {"pim", "pom"};
    static String[] B = {"99", "799" };
    static String P = "88999";
    public static void main(String[] args) throws Exception{
        System.out.println(solution(A,B,P));
    }
    public static String solution(String[] A, String[] B, String P) {
        String answer = "";
        List<String> list = new ArrayList<>();

        for(int i=0; i<B.length; i++){
            if(B[i].contains(P)){
                list.add(A[i]);
            }
        }
        Collections.sort(list);

        if(list.size() == 0){
            answer = "NO CONTACT";
        }else{
            answer = list.get(0);
        }

        return answer;
    }

    static String src =
            "";
}

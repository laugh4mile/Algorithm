package com.programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class L3_이중우선순위큐 {
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        for(int i=0; i<operations.length; i++){
            StringTokenizer tokens = new StringTokenizer(operations[i]);
            String command = tokens.nextToken();
            int num = Integer.parseInt(tokens.nextToken());
            if(command.equals("I")){
                if(treeMap.get(num) == null){
                    treeMap.put(num,1);
                }else{
                    treeMap.put(num,treeMap.get(num)+1);
                }
            }else{
                if(treeMap.size()>0){
                    if(num == 1){
                        treeMap.replace(treeMap.lastKey(), treeMap.get(treeMap.lastKey())-1);
                        if(treeMap.get(treeMap.lastKey()) == 0){
                            treeMap.remove(treeMap.lastKey());
                        }
                    }else{
                        treeMap.replace(treeMap.firstKey(), treeMap.get(treeMap.firstKey())-1);
                        if(treeMap.get(treeMap.firstKey()) == 0){
                            treeMap.remove(treeMap.firstKey());
                        }
                    }
                }
            }
        }

        if(treeMap.size()>0){
            answer[0] = treeMap.lastKey();
            answer[1] = treeMap.firstKey();
        }

        return answer;
    }

    public static void main(String[] args) {
//        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        System.out.println(Arrays.toString(solution(operations)));
    }

}
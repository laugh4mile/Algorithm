package com.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L2_문자열압축 {
    public static int solution(String s) {
        int answer = 1000;
        int N = s.length();
        if(s.length() == 1){
            return 1;
        }
        for(int unit=1; unit<=N/2; unit++){
            int moks = N/unit;
            int namozi = N%unit;
            List<Node> list = new ArrayList<>();
            int i=0;
            for(i=0; i<=N-unit; i=i+unit){
                String word = s.substring(i,i+unit);
                int size = list.size();
                if(list.isEmpty()){
                    list.add(new Node(word,1));
                }else{
                    if(list.get(size-1).word.equals(word)){
                        list.get((size-1)).cnt++;
                    }else{
                        list.add(new Node(word, 1));
                    }
                }
            }
            if(namozi != 0){
                list.add(new Node(s.substring(i),1));
            }
            StringBuilder sb = new StringBuilder();
            for(i=0; i<list.size(); i++){
                Node node = list.get(i);
                if(node.cnt == 1){
                    sb.append(node.word);
                }else{
                    sb.append(node.cnt+node.word);
                }
            }
            answer = Integer.min(sb.length(), answer);
        }
        return answer;
    }

    static class Node{
        String word;
        int cnt;

        public Node(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "word='" + word + '\'' +
                    ", cnt=" + cnt +
                    '}';
        }
    }

    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.println(solution(s));
    }
}

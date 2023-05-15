package com.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class L3_단어변환 {
    static List<Node> list[];
    static boolean isVisited[];
    static int answer;
    static String startStr, endStr;
    public static int solution(String begin, String target, String[] words) {
        boolean flag = false;
        startStr = begin;
        endStr = target;
        for(int i=0; i<words.length; i++){
            if(words[i].equals(target)){
                flag = true;
                break;
            }
        }
        if(!flag) return answer;

        String curStr = begin;
        list = new List[words.length+1];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<>();
        }
        isVisited = new boolean[list.length];

        for(int i=0; i<words.length; i++){
            for(int j=i; j<words.length; j++){
                int cnt = 0;
                for(int k=0; k<curStr.length(); k++){
                    if(curStr.charAt(k) != words[j].charAt(k)){
                        cnt++;
                        if(cnt > 1){
                            break;
                        }
                    }
                }
                if(cnt == 1){
                    list[i].add(new Node(j+1, words[j], 0));
                    list[j+1].add(new Node(i, curStr, 0));
                }
            }
            curStr = words[i];
        }

        bfs(0);

        return answer;
    }

    private static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        isVisited[start] = true;
        queue.offer(new Node(start, startStr, 0));

        while(!queue.isEmpty()){
            Node front = queue.poll();
            List<Node> childs = list[front.index];
            if(front.word.equals(endStr)){
                answer = front.cnt;
            }
            for(int i=0; i<childs.size(); i++){
                Node child = childs.get(i);
                if(!isVisited[child.index]){
                    isVisited[child.index] = true;
                    queue.offer(new Node(child.index, child.word, front.cnt+1));
                }
            }
        }

    }
    static class Node{
        int index;
        String word;
        int cnt;

        public Node(int index, String word, int cnt) {
            this.index = index;
            this.word = word;
            this.cnt = cnt;
        }
    }


    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution(begin, target, words));
    }
}
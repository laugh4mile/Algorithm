package com.programmers;

import java.util.Stack;
import java.util.StringTokenizer;

public class L3_표편집 {
    public static String solution(int n, int k, String[] cmd) {

        Node[] nodes = new Node[n+1];

        nodes[0] = new Node();
        for(int i=1; i<n; i++){
            nodes[i] = new Node();
            nodes[i].prev = nodes[i-1];
            nodes[i-1].next = nodes[i];
        }

        Node cur = nodes[k];
        Stack<Node> stack = new Stack<>();
        StringTokenizer tokens;

        for(int i=0; i<cmd.length; i++){
            tokens = new StringTokenizer(cmd[i]);
            String c = tokens.nextToken();
            if(c.equals("U")){
                int v = Integer.parseInt(tokens.nextToken());
                for(int j=0; j<v; j++){
                    cur = cur.prev;
                }
            }else if(c.equals("D")){
                int v = Integer.parseInt(tokens.nextToken());
                for(int j=0; j<v; j++){
                    cur = cur.next;
                }
            }else if(c.equals("C")){
                cur.isDeleted = true;
                stack.push(cur);
                if(cur.prev != null){
                    cur.prev.next = cur.next;
                }
                if(cur.next != null){
                    cur.next.prev = cur.prev;
                    cur = cur.next;
                }else{
                    cur = cur.prev;
                }
            }else{
                Node node = stack.pop();
                if(node.next != null){
                    node.next.prev = node;
                }
                if(node.prev != null){
                    node.prev.next = node;

                }
                node.isDeleted = false;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(nodes[i].isDeleted){
                sb.append("X");
            }else{
                sb.append("O");
            }
        }
        return sb.toString();
    }

    static class Node{
        Node prev;
        Node next;
        boolean isDeleted;
    }

    public static void main(String[] args) {
        System.out.println(solution(8,2,new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"}));
    }
}

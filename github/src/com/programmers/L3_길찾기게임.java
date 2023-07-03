package com.programmers;

import java.util.*;

public class L3_길찾기게임 {
    static List<Tree> tree = new ArrayList<>();
    static List<Integer> answer1 = new ArrayList<>();
    static List<Integer> answer2 = new ArrayList<>();
    public static int[][] solution(int[][] nodeinfo) {
        int rootNode = 0;
        int rootY = 0;
        int N = nodeinfo.length;
        int[][] answer = new int[2][N];
        List<Node> listX = new ArrayList<>();

        for(int i=0; i<nodeinfo.length; i++){
            listX.add(new Node(i+1, nodeinfo[i][0],nodeinfo[i][1]));
            if(nodeinfo[i][1] >= rootY){
                rootY = nodeinfo[i][1];
                rootNode = i+1;
            }
        }
        System.out.println(listX);
        Collections.sort(listX, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.x, o2.x);
            }
        });

        for(int i=0; i<N; i++){
            tree.add(new Tree(i+1, null, null));
        }
        for(int i=0; i<listX.size(); i++){
            if(listX.get(i).node == rootNode) continue;
            int left = i;
            int right = i;
            for(int j=i; j>=0; j--){
                if(listX.get(j).y > listX.get(i).y){
                    left = j;
                    break;
                }
            }
            for(int j=i; j<N ;j++){
                if(listX.get(j).y > listX.get(i).y){
                    right = j;
                    break;
                }
            }
            int parent = 0;
            if(left == i){
                parent = listX.get(right).node;
                tree.get(parent-1).left = listX.get(i).node;
            }else if(right == i){
                parent = listX.get(left).node;
                tree.get(parent-1).right = listX.get(i).node;
            }else if(listX.get(left).y < listX.get(right).y){
                parent = listX.get(left).node;
                tree.get(parent-1).right = listX.get(i).node;
            }else{
                parent = listX.get(right).node;
                tree.get(parent-1).left = listX.get(i).node;
            }
        }

        preOrder(rootNode);
        postOrder(rootNode);

        for(int i=0; i<N; i++){
            answer[0][i] = answer1.get(i);
            answer[1][i] = answer2.get(i);
        }
        return answer;
    }

    private static void preOrder(int node) {
        answer1.add(node);
        if(tree.get(node-1).left != null){
            preOrder(tree.get(node-1).left);
        }
        if(tree.get(node-1).right != null){
            preOrder(tree.get(node-1).right);
        }
    }
    private static void postOrder(int node) {
        if(tree.get(node-1).left != null){
            postOrder(tree.get(node-1).left);
        }
        if(tree.get(node-1).right != null){
            postOrder(tree.get(node-1).right);
        }
        answer2.add(node);
    }

    static class Tree{
        int node;
        Integer left;
        Integer right;

        public Tree(int node, Integer left, Integer right){
            this.node = node;
            this.left = left;
            this.right = right;
        }
    }
    static class Node{
        int node;
        Integer x;
        Integer y;
        public Node(int node, Integer x, Integer y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        for(int x[] : solution(new int[][]{{0,0}})){
            System.out.println(Arrays.toString(x));
        }
        for(int x[] : solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}})){
            System.out.println(Arrays.toString(x));
        }
    }
}

package com.programmers;

import java.util.*;

public class L3_여행경로 {
    static List<Node> graph[];
    static List<String> answerList;
    static int N;
    static boolean isOver;
    static int isVisited[][];
    public static String[] solution(String[][] tickets) {
        answerList = new ArrayList<>();
        N = tickets.length+1;
        Map<String, Integer> map = new HashMap();
        int cnt = 0;
        int startIdx = 0;
        for(int i=0; i<tickets.length; i++){
            for(int j=0; j<tickets[0].length; j++){
                if(map.get(tickets[i][j]) == null){
                    map.put(tickets[i][j],cnt);
                    if(tickets[i][j].equals("ICN")){
                        startIdx = cnt;
                    }
                    cnt++;
                }
            }
        }
        graph = new List[map.size()];
        isVisited = new int[map.size()][map.size()];
        for(int i=0;i <graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<tickets.length; i++){
            isVisited[map.get(tickets[i][0])][map.get(tickets[i][1])]++;
            graph[map.get(tickets[i][0])].add(new Node(map.get(tickets[i][1]), tickets[i][1]));
        }

        for(int i=0; i<graph.length; i++){
            Collections.sort(graph[i]);
        }
        answerList.add("ICN");
        dfs(startIdx, 0);

        String answer[] = answerList.toArray(new String[0]);
        return answer;
    }

    private static void dfs(int cur, int cnt) {
        if(cnt == N-1){
            isOver = true;
            return;
        }
        List<Node> childs = graph[cur];
        for(int i=0; i<childs.size(); i++){
            Node child = childs.get(i);
            if(isVisited[cur][child.no] > 0){
                isVisited[cur][child.no]--;
                answerList.add(child.airport);
                dfs(child.no, cnt+1);
                if(isOver){
                    return;
                }
                isVisited[cur][child.no]++;
                answerList.remove(answerList.size()-1);
            }
        }
    }

    static class Node implements Comparable<Node>{
        int no;
        String airport;

        public Node(int no, String airport){
            this.no = no;
            this.airport = airport;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", airport='" + airport + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return this.airport.compareTo(o.airport);
        }
    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"},{  "HND", "IAD"},{"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "JJJ"},{"JJJ", "ICN"},{"JJJ", "KKK"},{"KKK", "JJJ"}};
        String[][] tickets3 = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},{"ATL", "ICN"},{"ATL","SFO"}};
//        System.out.println(Arrays.toString(solution(tickets)));
//        System.out.println(Arrays.toString(solution(tickets2)));
        System.out.println(Arrays.toString(solution(tickets3)));
    }
}

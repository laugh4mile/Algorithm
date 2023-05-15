package com.programmers;

import java.util.*;

class L3_베스트앨범 {
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> map = new HashMap<>(); // 해당 장르의 재생 수
        List<Node> list = new ArrayList<>();
        Map<String, List<Node>> map2 = new HashMap<>(); // 해당 장르의 노래목록

        for(int i=0; i<genres.length; i++){
            if(map.get(genres[i]) == null){
                map.put(genres[i],plays[i]);
            }else{
                map.replace(genres[i],map.get(genres[i])+plays[i]);
            }
            list.add(new Node(i, genres[i], plays[i]));
        }
        List<Genre> sequence = new ArrayList<>();
        for (String s : map.keySet()) {
            sequence.add(new Genre(s, map.get(s)));
        }
        Collections.sort(sequence);

        for(int i=0; i<list.size(); i++){
            if(map2.get(list.get(i).genre) == null){
                List<Node> temp = new ArrayList<>();
                map2.put(list.get(i).genre, temp);
                map2.get(list.get(i).genre).add(list.get(i));
            }else{
                map2.get(list.get(i).genre).add(list.get(i));
            }
        }

        for (String s : map2.keySet()) {
            Collections.sort(map2.get(s));
            System.out.println(s+" "+map2.get(s));
        }
        List<Integer> answerList = new ArrayList<>();
        for(int i=0; i<map2.size(); i++){
            answerList.add(map2.get(sequence.get(i).genre).get(0).no);
            if(map2.get(sequence.get(i).genre).size() > 1){
                answerList.add(map2.get(sequence.get(i).genre).get(1).no);
            }
        }
        answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    static class Genre implements Comparable<Genre>{
        String genre;
        Integer cnt;

        public Genre(String genre, Integer cnt) {
            this.genre = genre;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Genre o) {
            return Integer.compare(o.cnt, this.cnt);
        }

        @Override
        public String toString() {
            return "Genre{" +
                    "genre='" + genre + '\'' +
                    ", cnt=" + cnt +
                    '}';
        }
    }
    static class Node implements Comparable<Node>{
        int no;
        String genre;
        int plays;

        public Node(int no, String genre, int plays) {
            this.no = no;
            this.genre = genre;
            this.plays = plays;
        }

        @Override
        public int compareTo(Node o){
            if(this.plays == o.plays){
                return Integer.compare(this.no,o.no);
            }
            return Integer.compare(o.plays,this.plays);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no=" + no +
                    ", genre='" + genre + '\'' +
                    ", plays=" + plays +
                    '}';
        }
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(solution(genres,plays)));
    }
}
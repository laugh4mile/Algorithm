package com.codingtest.bro;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q_0812_1 {
	
//	static int K = 3;
	static int K = 2;
//	static String[] user_scores = {"alex111 100","cheries2 200","coco 150","luna 100","alex111 120","coco 300","cheries2 100"};
//	static String[] user_scores = {"alex111 100","cheries2 200","alex111 200","cheries2 150","coco 50","coco 200"};
	static String[] user_scores = {"cheries2 200","alex111 100","coco 150","puyo 120"};
	static StringTokenizer tokens;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println(solution(K, user_scores));
	}

	private static int solution(int K, String[] user_scores) {
		int answer = 0;
		//
		List<Rank> list = new ArrayList<>();
		List<String> page = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		
		int next = 0;
		for(int i=0; i<user_scores.length; i++) { // 일단 1페이지를 먼저 채운다.
			next++;
			if(list.size() >= K) break;
			tokens = new StringTokenizer(user_scores[i]);
			String nickName = tokens.nextToken();
			int score = Integer.parseInt(tokens.nextToken());
			if(!temp.contains(nickName)) {
				list.add(new Rank(nickName, score));
				answer++;
				temp.add(nickName);
			}else {
				for(int j=0; j<list.size(); j++) {
					if(list.get(j).nickName == nickName && list.get(j).score < score) {
						list.get(j).score = score;
						break;
					}
				}
			}
		}
		Collections.sort(list); // 점수순으로 정렬
		for(int j=0; j<list.size(); j++) { // 1페이지 랭킹 저장
			page.add(list.get(j).nickName);
		}
		
		for(int i=next; i<user_scores.length; i++) { // 남은애들 랭크 먹이기
			temp.clear();
			tokens = new StringTokenizer(user_scores[i]);
			String nickName = tokens.nextToken();
			int score = Integer.parseInt(tokens.nextToken());
			list.add(new Rank(nickName, score)); // 걍 무지성으로 더함
			Collections.sort(list); // 점수순으로 정렬
			list.remove(list.size()-1); // 마지막 인덱스 없애기.
			for(int j=0; j<list.size(); j++) { // temp 에 최신 랭크 저장
				temp.add(list.get(j).nickName);
			}
			for(int j=0; j<temp.size(); j++) { // 최신 랭크 temp와 기존 랭킹 page가 다르면 갱신되는거임
				if(!temp.get(j).equals(page.get(j))) {
					page.clear();
					page.addAll(temp);
					answer++;
					break;
				}
			}
			
		}
		
		return answer;
	}
	
	static class Rank implements Comparable<Rank>{
		String nickName;
		int score;
		public Rank(String nickName, int score) {
			super();
			this.nickName = nickName;
			this.score = score;
		}
		@Override
		public int compareTo(Rank o) {
			return Integer.compare(o.score, this.score);
		}
		@Override
		public String toString() {
			return "Rank [nickName=" + nickName + ", score=" + score + "]";
		}
		
	}
}

package com.base;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	// char를 관리하는 완전 이진 트리를 구성해 보자
	char []nodes;
	// 현재 데이터의 위치
	int lastIndex;
	// 관리할 데이터의 크기
	final int size; //트리는 배열의 1번 부터 사용할 계획
	// final : 클래스 - 상속 불가, 메서드 - override 불가, 변수 - 더이상 값 변경 불가!!
	
	public CompleteBinaryTree(int size) {
		this.size = size; // blank final은 생성자에서 단 1회 변경 가능
		nodes = new char[size+1];// 배열의 1번 부터 사용할 계획
	}
	
	// 트리의 상태에 대해 보고할 수 있는 메서드
	//public boolean isEmpty() {
	//	return lastIndex==0;
	//}
	public boolean isFull() {
		return lastIndex == size;
	}
	
	// 데이터 추가
	public void add(char data) {
		if(isFull()) {
			System.out.println("꽉참..");
			return;
		}else {
			nodes[++lastIndex] = data;
		}
	}
	
	// 다양한 트리의 탐색
	// 1. BFS - 너비 우선 탐색
	public void bfs() {
		StringBuilder output = new StringBuilder();
		// 노드들의 인덱스 관리
		Queue<Integer> queue = new LinkedList<>();
		// 탐색의 출발점을 Queue에 삽입
		queue.offer(1);
		
		int front; // Integer
		while(!queue.isEmpty()) {
			// Queue 의 맨 앞 자료를 가져오고
			front = queue.poll();
			// 사용한다.
			output.append(nodes[front]).append(" ");
			// 자식들을 탐색한다. - 자식이 있다면 다시 큐에 삽입 : 여기서 자식은 부모 노드의 인덱스 기준으로 *2, *2+1
			if(front * 2 <= lastIndex) {
				queue.offer(front * 2);
			}
			if(front * 2 + 1 <= lastIndex) {
				queue.offer(front * 2 + 1);
			}
		}
		System.out.println(output);
	}
	
	// 2. BFS2 - 레벨별 탐색
	public void bfs2() {
		StringBuilder output = new StringBuilder();
		// 노드들의 인덱스 관리
		Queue<Integer> queue = new LinkedList<>();
		// 탐색의 출발점을 Queue에 삽입
		queue.offer(1);
		
		Integer front; // Integer
		int level =0, size; // queue의 사이즈 - 현재 level 노드의 개수
		while(!queue.isEmpty()) {
			size = queue.size();
			output.append("현재 레벨은: "+level++ +"\n");
			
			while(--size >=0){
				// Queue 의 맨 앞 자료를 가져오고
				front = queue.poll();
				// 사용한다.
				output.append(nodes[front]).append(" ");
				// 자식들을 탐색한다. - 자식이 있다면 다시 큐에 삽입 : 여기서 자식은 부모 노드의 인덱스 기준으로 *2, *2+1
				if(front * 2 <= lastIndex) {
					queue.offer(front * 2);
				}
				if(front * 2 + 1 <= lastIndex) {
					queue.offer(front * 2 + 1);
				}
			}
			output.append("\n");
		}
		System.out.println(output);
	}
	
	
	// DFS
	private void preOrder(int idx) {
		if(idx <= lastIndex) {
			// 사용 가능하다.
			System.out.print(nodes[idx]);
			// 그리고 자식을 탐색한다.
			preOrder(idx *2);
			preOrder(idx *2+1);
		}
	}
	
	public void printPreOrder() {
		System.out.println("preOrder");
		preOrder(1);
		System.out.println();
	}
	
	private void postOrder(int idx) {
		if(idx <= lastIndex) {
			// 자식을 탐색한다.
			preOrder(idx *2);
			preOrder(idx *2+1);
			//사용 가능하다
			System.out.println(nodes[idx]+" ");
		}
	}
	
	private void inOrder(int idx) {
		if(idx <= lastIndex) {
			// 자식을 탐색한다.
			inOrder(idx *2);
			//사용 가능하다
			System.out.println(nodes[idx]+" ");
			inOrder(idx *2+1);
		}
	}
	
}

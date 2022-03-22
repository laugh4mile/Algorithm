package com.codingtest.sk.second;

import java.util.*;

public class Q2 {

//    static String[] arr = {"1","2","4","3","3","4","1","5"};
//    static String[] processes = {"read 1 3 1 2","read 2 6 4 7","write 4 3 3 5 2","read 5 2 2 5","write 6 1 3 3 9", "read 9 1 0 7"};
    static String[] arr = {"1","1","1","1","1","1","1"};
    static String[] processes = {"write 1 12 1 5 8","read 2 3 0 2","read 5 5 1 2","read 7 5 2 5","write 13 4 0 1 3","write 19 3 3 5 5","read 30 4 0 6","read 32 3 1 5"};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(arr, processes)));
    }

    public static String[] solution(String[] arr, String[] processes) {
        Queue<Node> queue = new LinkedList<>(); // 모든 프로세스
        for(int i=0; i<processes.length; i++){
            StringTokenizer tokens = new StringTokenizer(processes[i]);
            String status = tokens.nextToken();
            int t1 = Integer.parseInt(tokens.nextToken());
            int t2 = Integer.parseInt(tokens.nextToken());
            int A = Integer.parseInt(tokens.nextToken());
            int B = Integer.parseInt(tokens.nextToken());
            int C = 0;
            if(status.equals("write")){
                C = Integer.parseInt(tokens.nextToken());
            }
            queue.offer(new Node(i, status, t1, t2, A, B, C));
        }
        Queue<Node> queueR = new LinkedList<>(); // 대기열에 쌓인 read
        Queue<Node> queueW = new LinkedList<>(); // 대기열에 쌓인 write
        List<Node> working = new ArrayList<>(); // 현재 작업중인 프로세스
        List<Answer> answerList = new ArrayList<>();

        int usedTime = 0; // 배열이 프로세스에 의해 사용된 시간.
        for(int t=0; t<100001; t++){ // 시간은 1초씩 무조건 흘러간다. 최대 100000 이다.
            if(!queue.isEmpty()){
                if(t == queue.peek().t1){
                    if(queue.peek().status.equals("read")){ // read 작업이 들어올경우
                        queueR.offer(queue.poll()); // queueR 대기열에 적재
                    }else{ // write일 경우
                        queueW.offer(queue.poll()); // queueW 대기열에 적재
                    }
                }
            }
            if(working.isEmpty()){ // 현재 작업중인 프로세스가 없을경우
                if(!queueW.isEmpty()){ // write가 대기중일 경우 우선순위를 가진다.
                    working.add(queueW.poll());
                }else{ // write가 대기중이지 않을 경우.
                    while(!queueR.isEmpty()){ // read가 대기중일 경우
                        working.add(queueR.poll()); // 모든 읽기작업 ㄱㄱ
                    }
                }
            }else{ // 작업중인 프로세스가 있을 경우
                if(working.get(0).status.equals("read")){ // 해당 작업이 읽기 작업일 경우
                    if(queueW.isEmpty()){ // 쓰기 대기열이 비어있을 경우
                        while (!queueR.isEmpty()){
                            working.add(queueR.poll()); // 대기중인 모든 읽기작업 다 ㄱㄱ
                        }
                    }
                }
            }
//            System.out.println(t+"   " +working);
            if(!working.isEmpty()){
                usedTime++;
            }
            for(int j=0; j<working.size(); j++) { // 남은 작업 시간을 1초 깎는다.
                working.get(j).t2--;
                if(working.get(j).t2 == 0){ // 시간을 다쓴다 = 작업을 끝마쳤다.
                    if(working.get(j).status.equals("write")){ // 쓰기 작업일 경우
                        for(int k=working.get(j).A; k<=working.get(j).B; k++){
                            arr[k] = Integer.toString(working.get(j).C);
                        }
                    }else{ // 읽기작업일 경우
                        StringBuilder sb = new StringBuilder();
                        for(int k=working.get(j).A; k<=working.get(j).B; k++){
                            sb.append(arr[k]);
                        }
                        answerList.add(new Answer(working.get(j).no,sb.toString()));
                    }
                    working.remove(j--);
                }
            }

            if(queue.isEmpty() && queueR.isEmpty() && queueW.isEmpty() && working.isEmpty()){ // 모든 작업을 완료했을경우 현재시각을 나타내고 탈출.
//                System.out.println(t);
                answerList.add(new Answer(Integer.MAX_VALUE,Integer.toString(usedTime)));
                break;
            }
        }
//        System.out.println(answerList);
        Collections.sort(answerList);
//        System.out.println(answerList);
        String[] answer = new String[answerList.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = answerList.get(i).str;
        }
        return answer;
    }
    static class Answer implements Comparable<Answer>{
        int no;
        String str;

        public Answer(int no, String str) {
            this.no = no;
            this.str = str;
        }

        @Override
        public int compareTo(Answer o) {
            return Integer.compare(this.no, o.no);
        }
    }
    static class Node{
        int no;
        String status;
        int t1;
        int t2;
        int A;
        int B;
        int C;

        public Node(int no, String status, int t1, int t2, int a, int b, int c) {
            this.no = no;
            this.status = status;
            this.t1 = t1;
            this.t2 = t2;
            A = a;
            B = b;
            C = c;
        }

    }
}

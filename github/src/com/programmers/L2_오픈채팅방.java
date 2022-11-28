package com.programmers;

import java.util.*;

class L2_오픈채팅방 {
    public static String[] solution(String[] record) {
        String[] answer = {};
        Map<String,String> map = new HashMap();
        List<Node> list = new ArrayList<>();
        StringTokenizer tokens;
        for(int i=0; i<record.length; i++){
            tokens = new StringTokenizer(record[i]);
            String state = tokens.nextToken();
            String userId = tokens.nextToken();
            if(state.equals("Leave")){
                list.add(new Node(userId, state));
                continue;
            }
            String nickName = tokens.nextToken();
            if(state.equals("Enter")){
                if(map.get(userId)==null){
                    map.put(userId, nickName);
                }else{
                    map.replace(userId, nickName);
                }
                list.add(new Node(userId, state));
            }else{
                map.replace(userId, nickName);
            }
        }
        answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            if(list.get(i).state.equals("Enter")){
                answer[i] = map.get(list.get(i).userId)+"님이 들어왔습니다.";
            }else{
                answer[i] = map.get(list.get(i).userId)+"님이 나갔습니다.";
            }
        }
        return answer;
    }

    static class Node{
        String userId;
        String state;

        public Node(String userId, String state) {
            this.userId = userId;
            this.state = state;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "userId='" + userId + '\'' +
                    ", state='" + state + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }
}
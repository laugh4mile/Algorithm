package com.programmers;

import java.util.*;

class L3_불량사용자 {
    static Set<String> set = new HashSet<>();
    static Set<String> resultSet = new HashSet<>();
    public static int solution(String[] user_id, String[] banned_id) {
        List<String> list[] = new List[banned_id.length];
        for(int i=0; i<banned_id.length; i++){
            list[i] = new ArrayList<>();
            banned_id[i] = banned_id[i].replace('*','.');
            for(int j=0; j<user_id.length; j++){
                if(user_id[j].matches(banned_id[i])){
                    list[i].add(user_id[j]);
                }
            }
        }

        getAnswer(list, 0);
        int answer = resultSet.size();
        return answer;
    }

    private static void getAnswer(List<String>[] list, int cnt) {
        if(cnt == list.length){
            List<String> resultList = new ArrayList<>(set);
            Collections.sort(resultList);
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<resultList.size(); i++){
                sb.append(resultList.get(i));
            }
            resultSet.add(sb.toString());
            return;
        }
        for(int i=0; i<list[cnt].size(); i++){
            if(!set.contains(list[cnt].get(i))){
                set.add(list[cnt].get(i));
                getAnswer(list, cnt+1);
                set.remove(list[cnt].get(i));
            }
        }
    }

    public static void main(String[] args) {
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"*rodo", "*rodo", "******"};
        System.out.println(solution(user_id,banned_id));
    }
}
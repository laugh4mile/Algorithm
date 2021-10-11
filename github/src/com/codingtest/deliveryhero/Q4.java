package com.codingtest.deliveryhero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q4 {
	List<Integer> list[];
    boolean isVisited[];
    int N, end;
    public boolean solution(int[] A, int[] B) {
        // write your code in Java SE 8
        N = A.length;
     
        list = new List[N+1];
        for(int i=1; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        isVisited = new boolean[N+1];
        Map<String, Boolean> map = new HashMap<>();

        for(int i=0; i<N; i++){
            if(map.get(A[i]+" "+B[i]) == null){
                list[A[i]].add(B[i]);
            }
        }
        
        for(int i=0; i<N; i++){
            if(list[A[i]].isEmpty()){
                return false;
            }
        }

        boolean flag = dfs(A[0]);
        if(!flag){
            return false;
        }
        for(int i=1; i<N+1; i++){
            if(!isVisited[i]){
                return false;
            }
        }
        for(int i=0; i<list[end].size(); i++){
            if(list[end].get(i) == A[0]){
                return true;
            }
        }
        return false;
    }

    public boolean dfs(int cur){
        isVisited[cur] = true;
        List<Integer> childs = list[cur];
        end = cur;
        if(childs.size()>1){
            return false;
        }
        for(int i=0; i<childs.size(); i++){
            int child = childs.get(i);
            if(!isVisited[child]){
                isVisited[child] = true;
                dfs(child);
            }
        }
        return true;
    }
}

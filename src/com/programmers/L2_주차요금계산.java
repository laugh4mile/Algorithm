package com.programmers;

import java.util.*;

class L2_주차요금계산 {
    public static int[] solution(int[] fees, String[] records) {
        StringTokenizer tokens;
        List<Node> list = new ArrayList<>();
        Map<Integer, Integer> timeMap = new HashMap<>();
        Map<Integer, Integer> acumTimeMap = new HashMap<>();
        for(int i=0; i<records.length; i++){
            tokens = new StringTokenizer(records[i]);
            String time = tokens.nextToken();
            int hh = Integer.parseInt(time.substring(0,2));
            int mm = Integer.parseInt(time.substring(3,5));
            int carNo = Integer.parseInt(tokens.nextToken());
            String state = tokens.nextToken();

            if(state.equals("IN")){
                timeMap.put(carNo, hh*60+mm);
            }else{
                int interval = hh*60+mm - timeMap.get(carNo);
                if(acumTimeMap.get(carNo) == null){
                    acumTimeMap.put(carNo,interval);
                }else{
                    acumTimeMap.replace(carNo,acumTimeMap.get(carNo)+interval);
                }
                timeMap.remove(carNo);
            }
        }
        for (int carNo : timeMap.keySet()) {
            int interval = 23*60+59 - timeMap.get(carNo);
            if(acumTimeMap.get(carNo) == null){
                acumTimeMap.put(carNo,interval);
            }else{
                acumTimeMap.replace(carNo,acumTimeMap.get(carNo)+interval);
            }
        }

        for (int carNo : acumTimeMap.keySet()) {
            int acumTime = acumTimeMap.get(carNo);
            int price = fees[1];
            if(acumTime > fees[0]){
                price += (int) Math.ceil((double) (acumTime-fees[0]) / fees[2]) * fees[3];
            }
            list.add(new Node(carNo, price));
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).price;
        }
        return answer;
    }
    static class Node implements Comparable<Node> {
        int carNo;
        int price;

        public Node(int carNo, int price){
            this.carNo = carNo;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.carNo, o.carNo);
        }
    }

    public static void main(String[] args) {
        int fees[] = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(solution(fees, records)));
    }
}
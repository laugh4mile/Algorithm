package com.codingtest.sk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1 {
//    static int money = 4578;
//    static int[] costs = {1, 4, 99, 35, 50, 1000};
    static int money = 1999;
    static int[] costs = {2, 11, 20, 100, 200, 600};
    public static void main(String[] args) {
        System.out.println(solution(money, costs));
    }

    public static int solution(int money, int[] costs) {
        int answer = 0;
        List<Coin> coins = new ArrayList<>();
        coins.add(new Coin(1, costs[0]));
        coins.add(new Coin(5, costs[1]));
        coins.add(new Coin(10, costs[2]));
        coins.add(new Coin(50, costs[3]));
        coins.add(new Coin(100, costs[4]));
        coins.add(new Coin(500, costs[5]));

        Collections.sort(coins);

        for(int i=0; i<coins.size(); i++){
            if(money > 0 && money >= coins.get(i).unit){
                int cnt = money / coins.get(i).unit;
                money = money - coins.get(i).unit * cnt;
                answer += coins.get(i).cost * cnt;
            }
        }

        return answer;
    }

    static class Coin implements Comparable<Coin>{
        int unit;
        double cost;

        public Coin(int unit, double cost) {
            this.unit = unit;
            this.cost = cost;
        }

        @Override
        public int compareTo(Coin o) {
            return Double.compare(o.unit/o.cost, this.unit/this.cost);
        }
    }
}

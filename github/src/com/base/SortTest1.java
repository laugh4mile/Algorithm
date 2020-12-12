package com.base;

import java.security.cert.CollectionCertStoreParameters;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 정렬?
// 크기 순으로 배치하는 것

// 정렬 되려면 필요한 것?
// implements Comparable
// 대표적인 Comparable들..: String, Integer, Long, Double... 등 wrapper
// 사용자 정의 클래스.... --> 정렬 기준이 없다.

// 정렬 불가능한 녀석들을 정렬 시키려면 필요한 것?


public class SortTest1 {
    // 간선: aNode --> bNode로 가는데 cost 만큼의 비용이 든다.
    // static inner class

    // MST를 만들려면 어떤 식으로 정렬? 간선의 비용에 대한 오름차순
    static class Edge implements Comparable<Edge> {
        int aNode;
        int bNode;
        int cost;

        public Edge(int aNode, int bNode, int cost) {
            super();
            this.aNode = aNode;
            this.bNode = bNode;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "[" + aNode + "->" + bNode + ", c=" + cost + "]";
        }

        @Override
        // 간선의 비용에 대한 오름차순 만약 비용이 같으면 첫번째 노드를 기준으로 내림차순
        public int compareTo(Edge o) {
            // return this.cost - o.cost; Integer.MAX_VALUE - (-1)
            if (this.cost == o.cost) {
                return Integer.compare(this.aNode, o.aNode) * -1;
            } else {
                return Integer.compare(this.cost, o.cost);
            }
        }
    }


    public static void main(String[] args) {
        List<Edge> edges = Arrays.asList(new Edge(1, 2, 3), new Edge(3, 4, 3), new Edge(1, 3, 5),
                new Edge(2, 3, 2));

        // Collection의 정렬
        Collections.sort(edges);
        System.out.println(edges);

        // 어.. 정렬 기준을 바꿔보고 싶은데???
        // static inner class 사용
        Collections.sort(edges, new MyComp());
        System.out.println(edges);

        // 간선 노드의 합으로 정렬?
        // anonymous inner class
        Collections.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                int sum1 = o1.aNode + o1.bNode;
                int sum2 = o2.aNode + o2.bNode;
                return Integer.compare(sum1, sum2);
            }
        });

        // JDK 1.8 lambda 식
        Collections.sort(edges, (Edge o1, Edge o2) -> {
            int sum1 = o1.aNode + o1.bNode;
            int sum2 = o2.aNode + o2.bNode;
            return Integer.compare(sum1, sum2);
        });

    }

    static class MyComp implements Comparator<Edge> {
        // 간선 비용에 대해 내림차순으로 정렬하고 싶어..
        @Override
        public int compare(Edge o1, Edge o2) {
            return Integer.compare(o1.cost, o2.cost) * -1;
        }
    }


}

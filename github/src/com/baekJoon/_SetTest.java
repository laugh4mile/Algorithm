package com.baekJoon;

import java.util.HashSet;
import java.util.Set;

public class _SetTest {
    public static void main(String[] args) {
        Set<Node> set = new HashSet<>();

        set.add(new Node(1,1,1));
        set.add(new Node(1,1,1));
        set.add(new Node(1,1,1));
        System.out.println(set);
        int a = 0;
        int b = 1;
        System.out.println(a^1);
        System.out.println(b^1);
    }

    static class Node{
        int r;
        int c;
        int v;

        public Node(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", v=" + v +
                    '}';
        }
    }
}

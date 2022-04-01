package com.baekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_G1_1208_부분수열의합2_학일 {

	static int n, s;
	static ArrayList<Integer> pos, neg;
	static HashMap<Integer, Integer>[][] pMap, nMap;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		pos = new ArrayList<>();
		neg = new ArrayList<>();
		pMap = new HashMap[n][2];
		nMap = new HashMap[n][2];

		st = new StringTokenizer(br.readLine());
		boolean flag = true;
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());

			if (flag) neg.add(num);
			else pos.add(num);

			flag = !flag;
		}

		if (pos.size() > 0) {
			makeSub(pos, pMap, 0, 0);
			makeSub(pos, pMap, 0, 1);
		}
		if (neg.size() > 0) {
			makeSub(neg, nMap, 0, 0);
			makeSub(neg, nMap, 0, 1);
		}

		HashMap<Integer, Integer> map1 = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		joinMap(map1, pMap[0][0], pMap[0][1]);
		joinMap(map2, nMap[0][0], nMap[0][1]);

		ArrayList<Integer> list1 = new ArrayList<>(map1.keySet());
		Collections.sort(list1);
		ArrayList<Integer> list2 = new ArrayList<>(map2.keySet());
		Collections.sort(list2, Collections.reverseOrder());

		int i = 0, j = 0;
		long ans = 0;

		while (i < list1.size() && j < list2.size()) {
			int num1 = list1.get(i);
			int num2 = list2.get(j);

			if (num1 + num2 < s) {
				i ++;
			} else if (num1 + num2 > s) {
				j ++;
			} else {
				long a = map1.get(num1);
				long b = map2.get(num2);
				ans += a*b;
				i ++;
				j ++;
			}
		}

		ans += map1.getOrDefault(s, 0);
		ans += map2.getOrDefault(s, 0);

		System.out.print(ans);
	}

	static void makeSub(ArrayList<Integer> list, HashMap<Integer, Integer>[][] dp, int idx, int used) {

		if (idx == list.size()-1) {
			dp[idx][used] = new HashMap<>();
			if (used == 1) dp[idx][used].put(list.get(idx), 1);
			return;
		}

		if (dp[idx][used] != null) return;

		makeSub(list, dp, idx+1, 0);
		makeSub(list, dp, idx+1, 1);

		HashMap<Integer, Integer> tmp = new HashMap<>();

		joinMap(tmp, dp[idx+1][0], dp[idx+1][1]);

		if (used == 1) {
			HashMap<Integer, Integer> map = new HashMap<>();
			map.put(list.get(idx), 1);
			for (Map.Entry<Integer, Integer> entry: tmp.entrySet()) {
				map.put(entry.getKey() + list.get(idx), map.getOrDefault(entry.getKey() + list.get(idx), 0) + entry.getValue());
			}
			tmp = map;
		}

		dp[idx][used] = tmp;
	}

	static void joinMap(HashMap<Integer, Integer> tmp, HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {

		if (map1 != null) {
			for (Map.Entry<Integer, Integer> entry: map1.entrySet()) {
				tmp.put(entry.getKey(), tmp.getOrDefault(entry.getKey(), 0) + entry.getValue());
			}
		}
		if (map2 != null) {
			for (Map.Entry<Integer, Integer> entry: map2.entrySet()) {
				tmp.put(entry.getKey(), tmp.getOrDefault(entry.getKey(), 0) + entry.getValue());
			}
		}
	}
}
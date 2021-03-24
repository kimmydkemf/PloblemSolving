package 프로그래머스LEVEL2;

import java.util.*;

public class 메뉴리뉴얼 {
	class Solution {
		public ArrayList<String> combination;

		public String[] solution(String[] orders, int[] course) {
			String[] answer = {};
			combination = new ArrayList<>();
			for (String s : orders) { // 나올 수 있는 모든 조합 찾아서 course에 만족하는거는 저장하기.
				char[] c = s.toCharArray();
				Arrays.sort(c);
				for (int i = 0; i < c.length; i++) {
					for (int j = 0; j < course.length; j++) {
						dfs(c, i, 1, course[j], c[i] + "");
					}
				}
			}
			HashMap<String, Integer> map = new HashMap<>();
			for (String str : combination) { // course에 몇번 참여했는지 카운트하기.
				map.put(str, map.getOrDefault(str, 0) + 1);
			}
			PriorityQueue<String> pq = new PriorityQueue<>();
			List<String> keySetList = new ArrayList<>(map.keySet());
			Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
			// 참여율이 높은순서대로 정렬.

			List<String> ansList = new ArrayList<>();
			for (int i = 0; i < course.length; i++) {
				int max_value = 0;

				for (String key : keySetList) {
					if (map.get(key) >= 2 && key.length() == course[i]) {
						if (map.get(key) >= max_value) {
							ansList.add(key);
							max_value = map.get(key);
						}
					}
				}
			}
			Collections.sort(ansList); // 알파벳 순으로 재정렬.
			answer = new String[ansList.size()];
			ansList.toArray(answer); // anslist를 answer에 array형식으로 넣기.
			return answer;
		}

		public void dfs(char[] c, int idx, int length, int course, String str) {
			if (length == course) {
				combination.add(str);
				return;
			}
			for (int i = idx + 1; i < c.length; i++) {
				dfs(c, i, length + 1, course, str + c[i]);
			}
		}
	}
}

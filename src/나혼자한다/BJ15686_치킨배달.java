package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ15686_치킨배달 {

	static int min_result;
	static Point chicken_point[];
	static Point house_point[];
	static int N, M, chicken, house;
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// map 생성
		int map[][] = new int[N][N];
		chicken = 0;
		house = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int now = Integer.parseInt(st.nextToken());
				if (now == 1)
					house++;
				if (now == 2)
					chicken++;
				map[i][j] = now;
			}
		}
		chicken_point = new Point[chicken];
		house_point = new Point[house];
		chicken = 0;
		house = 0;

		// chicken 과 house 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					house_point[house++] = new Point(i, j);
				} else if (map[i][j] == 2) {
					chicken_point[chicken++] = new Point(i, j);
				}
			}
		}
		min_result = Integer.MAX_VALUE;
		// 순열 현재위치, 선택된 개수
		arr = new int[M];
		Permutation(0, 0);
		System.out.println(min_result);
	}

	private static void Permutation(int i, int choice) {
		// 내려왔는데, 치킨집 다 골랐다.
		if (choice == M) {
			int cnt = 0;
			for (int h = 0; h < house; h++) {
				int min=Integer.MAX_VALUE;
				for(int c=0;c<choice;c++) {
					min = Math.min(min,(Math.abs(house_point[h].x - chicken_point[arr[c]].x)
							+ Math.abs(house_point[h].y - chicken_point[arr[c]].y)));
				}
				cnt+=min;
			}
			min_result = Math.min(min_result, cnt);
			return;
		}
		// 남은 치킨집이 없다.
		if (i >= chicken)
			return;
		// 남은 치킨집이 있는데, 지금 치킨집을 고를꺼다.
		arr[choice] = i;
		Permutation(i + 1, choice + 1);
		// 안고르고 걍 갈거다.
		Permutation(i + 1, choice);
	}

	static class Point {
		int x, y;

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
}

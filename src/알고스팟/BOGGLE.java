package 알고스팟;

import java.util.*;
import java.io.*;

public class BOGGLE {
	static char map[][];
	static int di[] = { -1, -1, -1, 1, 1, 1, 0, 0 };
	static int dj[] = { -1, 0, 1, -1, 0, 1, -1, 1 };
	static boolean dp[][][];
	static String temp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = Integer.parseInt(sc.nextLine());
		for (int tc = 1; tc <= TC; tc++) {
			map = new char[5][5];
			for (int i = 0; i < 5; i++) {
				temp = sc.nextLine();
				for (int j = 0; j < 5; j++) {
					map[i][j] = temp.charAt(j);
				}
			}
			int N = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < N; i++) {
				temp = sc.nextLine();
				dp = new boolean[5][5][temp.length()];
				if (go())
					System.out.println(temp + " YES");
				else
					System.out.println(temp + " NO");
			}
		}
	}

	static boolean go() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (check(i, j, 0))
					return true;
			}
		}
		return false;
	}

	static boolean check(int x, int y, int cnt) {

		dp[x][y][cnt] = true;

		if (map[x][y] != temp.charAt(cnt))
			return false;

		if (cnt == temp.length() - 1)
			return true;

		for (int i = 0; i < 8; i++) {
			int nx = x + di[i];
			int ny = y + dj[i];
			if (isIn(nx, ny)) {
				if (dp[nx][ny][cnt + 1])
					continue;
				if (check(nx, ny, cnt + 1))
					return true;
			}
		}
		return false;
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < 5 && y < 5;
	}
}

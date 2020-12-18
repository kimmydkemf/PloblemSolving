package 지나가다가;

import java.util.*;
import java.io.*;

public class BJ1417_국회의원선거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int mine = Integer.parseInt(br.readLine());
		int cnt = 0;
		int[] arr = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		if (N != 1) {
			Arrays.sort(arr);
			int idx = N - 2;
			while (true) {
				if (mine > arr[idx])
					break;
				mine++;
				cnt++;
				arr[idx]--;
				if (idx!=0&&arr[idx] < arr[idx - 1])
					Arrays.sort(arr);
			}
		}
		System.out.println(cnt);
	}
}

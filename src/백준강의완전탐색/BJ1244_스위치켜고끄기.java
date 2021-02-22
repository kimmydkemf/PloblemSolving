package 백준강의완전탐색;

import java.util.*;
import java.io.*;

public class BJ1244_스위치켜고끄기 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int FM = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			switch (FM) {
			case 1:
				male(num);
				break;
			case 2:
				female(num);
				break;
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=1;i<=N;i++) {
			sb.append(arr[i]+" ");
			if(i%20==0)
				sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static void female(int num) {
		int idx = 0;
		while (num - idx > 0 && num + idx <= N) {
			if (arr[num + idx] == arr[num - idx]) {
				int temp = arr[num - idx] == 0 ? 1 : 0;
				arr[num - idx] = temp;
				arr[num + idx] = temp;
			}else {
				break;
			}
			idx++;
		}
	}

	static void male(int num) {
		for (int i = 1; i * num <= N; i++) {
			arr[num * i] = arr[num * i] == 0 ? 1 : 0;
		}
	}
}

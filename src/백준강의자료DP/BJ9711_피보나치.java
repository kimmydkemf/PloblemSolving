package 백준강의자료DP;

import java.util.*;
import java.io.*;

public class BJ9711_피보나치 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken());
			long Q = Long.parseLong(st.nextToken());
			if(Q==1) {
				sb.append("Case #" + tc + ": " + 0+"\n");
				continue;
			}
			if (P <= 2) {
				sb.append("Case #" + tc + ": " + 1);
			} else {
				long first = 1;
				long second = 1;
				long third=0;
				for (int i = 3; i <= P; i++) {
					third=(first%Q+second%Q)%Q;
					first=second;
					second=third;
				}
				sb.append("Case #" + tc + ": " + third);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}

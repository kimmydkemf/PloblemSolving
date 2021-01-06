package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ9663_N_Queen {
		static int cnt;
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			int[] arr = new int[N + 1];
			cnt = 0;
			boolean[] visit = new boolean[N + 1];
			dfs(arr, visit, 1);
			System.out.println(cnt);
		}
		static void dfs(int[] arr, boolean[] visit, int N) {
			if (N == arr.length) { // 각자리에 queen을 모두 놓았을때
				cnt++;
				return;
			}
			for (int i = 1; i < arr.length; i++) {
				boolean check=false;
				for(int j=1;j<N;j++) {
					if(Math.abs(j-N)==Math.abs(arr[j]-i)) // j-N으로 세로길이와 arr[j]-i의 가로길이가 같으면 대각선 위치에 있음. check=true로 dfs진행을 막아야 한다.
						check=true;
				}
				if (!visit[i]&&!check) {	// visit 배열로 같은 열에 있는 i는 선택할 수 없음.
					arr[N]=i;
					visit[i] = true;
					dfs(arr, visit, N + 1);
					visit[i] = false;
				}
			}
		}
}
package 삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ14502_연구소 {

	public static int N,M;
	public static int[][] map;
	public static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};
	public static int max_safe_cnt;
	public static int safe_cnt;
	
	public static ArrayList<ArrayList<Integer>> virus ;
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1. init
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		
		map = new int[N][M];
		max_safe_cnt = 0;
		
		virus = new ArrayList();
		safe_cnt = 0;
		
		// 1-1. 지도 입력 받을 때, virus 는 좌표 저장하고 0 갯수 저장
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; ++j) {
				int tmp = stoi(st.nextToken());
				map[i][j] = tmp;
				if(tmp==2) {
					ArrayList<Integer> v = new ArrayList();
					v.add(i); v.add(j);
					virus.add(v);
				}
				else if(tmp==0) {
					safe_cnt++;
				}
			}
			
		}
		// 1-2. 벽 3개 지을 거니까 0의 갯수 3개 줄이기
		safe_cnt = safe_cnt -3;

		// 2. dfs
		// 지도를 일렬로 나열했을때, 벽지을 공간 3개 탐색
		// 각 위치는 숫자 d 가 있을 때
		// 행 : d/M , 열 : d%M
		for(int f=0; f<N*M-2; ++f) {
			// 2-1. 첫번째 벽지을 공간이 0이 아닌 경우 pass
			if(map[f/M][f%M]!=0) {
				continue;
			}
			for(int s=f+1; s<M*N-1; ++s) {
				// 2-2. 두번째 벽지을 공간이 0이 아닌 경우 pass
				if(map[s/M][s%M]!=0) {
					continue;
				}
				for(int t=s+1; t<M*N; ++t) {
					// 2-3. 세번째 벽지을 공간이 0이 아닌 경우 pass
					if(map[t/M][t%M]!=0) {
						continue;
					}
					// 2-4. 원래의 지도 복사
					int[][] copy = new int[N][M];
					for(int c=0; c<N; ++c) {
						copy[c] = map[c].clone();
					}
						
					// 2-5. 지금 탐색하는 경우에 대해 벽 3개 설치
					copy[f/M][f%M]=1;
					copy[s/M][s%M]=1;
					copy[t/M][t%M]=1;
						
					// 2-6. 바이러스 이동 시작 (bfs)
					int result = safe_cnt;
					for(ArrayList<Integer> vi : virus) {
						result = move(vi.get(0),vi.get(1),copy, result);
					}
					// 2-7. 다 이동하고 나서 안전구역이 최대값인지 확인
					if(result>max_safe_cnt) {
						max_safe_cnt = result;
					}
				}
			}
		}
		// 3. 결과 출력
		System.out.println(max_safe_cnt);
		
	}
	
	// 4. bfs : 바이러스들 퍼지는 함수
	public static int move(int y, int x, int[][] copy, int result) {
		// 4-1. 초기화, 처음값 큐에 넣어주기
		Queue<ArrayList<Integer>> queue = new LinkedList();
		ArrayList<Integer> tmp = new ArrayList();
		tmp.add(y);
		tmp.add(x);
		queue.add(tmp);
		int after = result;
		
		// 4-2. bfs 시작
		while(!queue.isEmpty()) {
			
			ArrayList<Integer> current = queue.remove();
			// 4-2-1. 해당 좌표에서 각 방향 전파 가능한지 탐색
			for(int[] direc : DIRECTIONS) {
				int nexty = current.get(0)+direc[0];
				int nextx = current.get(1)+direc[1];
				// in range
				if(nexty>=0 && nexty<N && nextx<M && nextx>=0) {
					// 4-2-2. 전파 가능하면 큐에 추가, 안전구역 1개 지우기
					if(copy[nexty][nextx]==0) {
						--after;
						copy[nexty][nextx] = 2;
						tmp = new ArrayList();
						tmp.add(nexty); tmp.add(nextx);
						queue.add(tmp);
					}
				}
			}
		}
		
		return after;
	}

}
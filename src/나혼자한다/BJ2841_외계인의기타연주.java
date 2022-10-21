package 나혼자한다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ2841_외계인의기타연주 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq[]=new PriorityQueue[6];
		for(int i=0;i<6;i++) pq[i]=new PriorityQueue(Collections.reverseOrder());
		int cnt=0;
		for(int n=0;n<N;n++) {
			st=new StringTokenizer(br.readLine());
			int line=Integer.parseInt(st.nextToken())-1;
			int flat=Integer.parseInt(st.nextToken());
			if(pq[line].size()==0) {
				cnt++;
				pq[line].add(flat);
			}else {
				while(!pq[line].isEmpty()) {
					int now = pq[line].poll();
					if(now<flat) {
						pq[line].add(now);
						pq[line].add(flat);
						cnt++;
						break;
					}else if(now==flat) {
						pq[line].add(flat);
						break;
					}else {
						cnt++;
					}
				}
				if(pq[line].isEmpty()) {
					pq[line].add(flat);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
}

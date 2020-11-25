package 나혼자한다;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/***
 * 
 * @author selordoun
 * N의 종류 상품은 w의 무게와 h의 가치를 가지고
 * K의 무게까지만 넣을수 있는 배낭
 * 최대 이익?
 */

public class BJ12865_평범한배낭 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int []dp=new int[K+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			int weight=Integer.parseInt(st.nextToken());
			int value=Integer.parseInt(st.nextToken());
			for(int j=K;j>0;j--) {
				if(j>=weight) {
					if(dp[j-weight]+value>dp[j]) {
						dp[j]=dp[j-weight]+value;
					}else {
						dp[j]=dp[j];
					}
				}
			}
//			for(int j=0;j<=K;j++) {
//				System.out.print(dp[j]+" ");
//			}
//			System.out.println();
		}		
//		LinkedList<item> items=new LinkedList<>();
//		for(int i=0;i<N;i++) {
//			st=new StringTokenizer(br.readLine());
//			int w=Integer.parseInt(st.nextToken());
//			int v=Integer.parseInt(st.nextToken());
//			items.add(new item(w,v));
//		}
//		dfs(0,0,0,N,K,items);
		System.out.println(dp[K]);
	}
//	static class item {
//		int weight;
//		int value;
//		item(int w,int v){
//			weight=w;
//			value=v;
//		}
//	}
//	static void dfs(int weight,int cnt,int value,int N,int K, LinkedList<item> list) {
//		if(cnt==N) { // 모든물건확인.
//			if(result<value)
//				result=value;
//			return;
//		}
//		// 1. 현재 물건 안선택
//		dfs(weight,cnt+1,value,N,K,list);
//		// 2. 현재 물건 선택
//		int nweight=weight+list.get(cnt).weight;
//		int nvalue=value+list.get(cnt).value;
//		if(nweight>K) { // 현재거를 넣을 수 없으면
//			return;
//		}
//		dfs(nweight,cnt+1,nvalue,N,K,list); //넣고 다음.
//		if(result<nvalue)
//			result=nvalue;
//	}
}

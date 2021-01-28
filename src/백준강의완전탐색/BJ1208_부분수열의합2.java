package 백준강의완전탐색;
import java.util.*;
import java.io.*;

public class BJ1208_부분수열의합2 {
	static int arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int S=Integer.parseInt(st.nextToken());
		
		arr=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> A=new ArrayList<>();
		ArrayList<Integer> B=new ArrayList<>();
		
		dfs(0,N/2,0,A);
		dfs(N/2,N,0,B);
		
		Collections.sort(A);
		Collections.sort(B);
		
		int left=0;
		int right=B.size()-1;
		long ans=0;
		while(left<A.size()&&right>=0) {
			int Lv=A.get(left);
			int Rv=B.get(right);
			if(Lv+Rv==S) {
				long lc=0;
				long Rc=0;
				while(left<A.size()&&A.get(left)==Lv) {
					lc++;
					left++;
				}
				while(right>=0&&B.get(right)==Rv) {
					Rc++;
					right--;
				}
				ans+=Rc*lc;
			}
			if(Lv+Rv>S) {
				right--;
			}
			if(Lv+Rv<S) {
				left++;
			}
		}
		if(S==0)
			ans-=1;
		System.out.println(ans);
	}
	static void dfs(int idx,int end, int sum,ArrayList<Integer> list) {
		if(idx==end) {
			list.add(sum);
			return;
		}
		dfs(idx+1,end,sum+arr[idx],list);
		dfs(idx+1,end,sum,list);
	}
}

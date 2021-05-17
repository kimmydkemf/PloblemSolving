package 백준강의완전탐색;
import java.util.*;

public class BJ2309_일곱난쟁이 {
	static int [] temp,answer,arr;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		arr=new int[9];
		temp=new int[7];
		answer=new int[7];
		for(int i=0;i<9;i++) arr[i]=sc.nextInt();
		for(int i=0;i<3;i++) {
			temp[0]=arr[i];
			dfs(1,1);
		}
		Arrays.sort(answer);
		for(int i=0;i<7;i++) System.out.println(answer[i]);
	}
	static void dfs(int idx,int cnt) {
		if(idx>=9) return;
		if(cnt>=7) {
			if(answer[0]!=0) return;
			if(cnt==7&&sum()==100) {
				for(int i=0;i<7;i++) answer[i]=temp[i];
			}
			return;
		}
		for(int i=idx;i<9;i++) {
			temp[cnt]=arr[i];
			dfs(idx+1,cnt+1);
		}
		dfs(idx+1,cnt);
	}
	static int sum() {
		int s=0;
		for(int i=0;i<7;i++) s+=temp[i];
		return s;
	}
}

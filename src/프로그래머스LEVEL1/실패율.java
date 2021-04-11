package 프로그래머스LEVEL1;
import java.util.*;

public class 실패율 {
	class Solution {
	    public int[] solution(int N, int[] stages) {
	        int[] answer = new int[N];
	        int[] player=new int[N+1];
	        int[] fail=new int[N+1];
	        for(int i=0;i<stages.length;i++){
	            if(stages[i]<=N)
	                fail[stages[i]]++;
	        }
	        player[1]=stages.length;
	        for(int i=2;i<=N;i++){
	            player[i]=player[i-1]-fail[i-1];
	        }
	         PriorityQueue<Fail> pq=new PriorityQueue<>((Fail a,Fail b)->{
	                if(b.fail_rate==a.fail_rate) return a.number-b.number;
		            return (int)(((Double)b.fail_rate).compareTo(a.fail_rate));
		    });
	        for(int i=1;i<=N;i++){
	            if(fail[i]==0) pq.add(new Fail(i,0.0));
	            else pq.add(new Fail(i,(double)fail[i]/player[i]));
	        }
	        int idx=0;
	        while(!pq.isEmpty()){
	            Fail f=pq.poll();
	            answer[idx++]=f.number;
	        }
	        return answer;
	    }
	    public class Fail{
	        int number;
	        double fail_rate;
	        Fail(int n,double f){
	            number=n;
	            fail_rate=f;
	        }
	    }
	}
}

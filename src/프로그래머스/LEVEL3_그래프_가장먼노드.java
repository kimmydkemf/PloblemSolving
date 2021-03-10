package 프로그래머스;
import java.util.*;

public class LEVEL3_그래프_가장먼노드 {
	class Solution {
	    boolean[] visit;
	    int[] length;
	    int max;
	    public int solution(int n, int[][] edge) {
	        ArrayList<Integer> list[]=new ArrayList[n+1];
	        visit=new boolean[n+1];
	        length=new int[n+1];
	        for(int i=0;i<=n;i++)
	            list[i]=new ArrayList<Integer>();
	        for(int[] e:edge){
	            int s=e[0];
	            int end=e[1];
	            list[s].add(end);
	            list[end].add(s);
	        }
	        int answer = 0;
	        LinkedList<Integer> queue=new LinkedList<>();
	        queue.add(1);
	        visit[0]=true;
	        visit[1]=true;
	        int len=0;
	        while(!queue.isEmpty()){
	            int size=queue.size();
	            len++;
	            for(int i=0;i<size;i++){
	            int now=queue.poll();
	            for(int t:list[now]){
	                if(!visit[t]){
	                    visit[t]=true;
	                    length[t]=len;
	                    queue.add(t);
	                }
	            }
	            }
	        }
	        // for(int i=0;i<=n;i++)
	        //     System.out.print(length[i]);
	        for(int i=0;i<=n;i++){
	            answer+=length[i]==len-1?1:0;
	        }
	        return answer;
	    }
	    public class Line{
	        int start;
	        int end;
	        Line(int s,int e){
	            start=s;
	            end=e;
	        }
	    }
	}
}

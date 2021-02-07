package 프로그래머스;
import java.io.*;
import java.util.*;

public class LEVEL3_DFS_BFS_단어변환 {

	class Solution {
	    int answer = Integer.MAX_VALUE;
	    public int solution(String begin, String target, String[] words) {
	        int size=words.length;
	        boolean visit[]=new boolean[size];
	        dfs(begin,target,0,size,visit,words); 
	        answer = (answer==Integer.MAX_VALUE?0:answer);
	        return answer;
	    }
	    void dfs(String b,String t,int cnt,int size,boolean[] visit,String[] words){
	        if(b.equals(t)){
	            answer=Math.min(cnt,answer);
	            return;
	        }
	        for(int i=0;i<size;i++){
	            if(!visit[i]&&checkchange(b,words[i])){
	                visit[i]=true;
	                dfs(words[i],t,cnt+1,size,visit,words);
	                visit[i]=false;
	            }
	        }
	    }
	    boolean checkchange(String a,String b){
	        int size=a.length();
	        int cnt=0;
	        for(int i=0;i<size;i++){
	            if(a.charAt(i)!=b.charAt(i))
	                cnt++;
	        }
	        if(cnt==1)
	            return true;
	        else
	            return false;
	    }
	}
}

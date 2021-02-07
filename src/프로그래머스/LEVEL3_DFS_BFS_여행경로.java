package 프로그래머스;
import java.util.*;
import java.io.*;

public class LEVEL3_DFS_BFS_여행경로 {

	class Solution {
	    boolean [] visit;
	    ArrayList<String> answers;
	    public String[] solution(String[][] tickets) {
	        int size=tickets.length;
	        visit=new boolean[size];
	        answers = new ArrayList<String>();
	        int count=0;
	        dfs(count,"ICN","ICN",tickets);
	        Collections.sort(answers);
	        String [] answer=answers.get(0).split(" ");
	        return answer;
	    }
	    void dfs(int cnt,String now, String answer,String[][] tickets){
	        if(cnt==tickets.length){
	            answers.add(answer);
	        }
	        for(int i=0;i<tickets.length;i++){
	            if(!visit[i]&&tickets[i][0].equals(now)){
	                visit[i]=true;
	                dfs(cnt+1,tickets[i][1],answer+" "+tickets[i][1],tickets);
	                visit[i]=false;
	            }
	        }
	    }
	}
}

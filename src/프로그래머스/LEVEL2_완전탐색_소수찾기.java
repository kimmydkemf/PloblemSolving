package 프로그래머스;
import java.util.*;

public class LEVEL2_완전탐색_소수찾기 {

	    static boolean[] sosu=new boolean[10000000];
	    static int cnt,length;
	    static boolean[] visit;
	    static String origin;
	    static HashMap<Integer,Integer> map;
	    public int solution(String numbers) {
	        int answer = 0;
	        origin=numbers;
	        sosu[0]=true;
	        sosu[1]=true;
	        for(int i=2;i<10000000;i++){
	            if(!sosu[i]){
	                for(int j=2;j*i<10000000;j++){
	                    sosu[i*j]=true;
	                }
	            }
	        }
	        length=numbers.length();
	        visit=new boolean[length];
	        cnt=0;
	        map=new HashMap();
	        combi(0,"");
	        answer=cnt;
	        return answer;
	    }
	    static void combi(int idx,String temp){
	        int now=0;
	        if(temp!="")
	            now = Integer.parseInt(temp);
	        if(idx==length){
	            if(!sosu[now]&&!map.containsKey(now)){
	                   map.put(now,1);
	                    cnt++;
	            }
	            return;
	        }
	        if(temp!=""&&!sosu[now]&&!map.containsKey(now)){
	            map.put(now,1);
	            cnt++;
	        }
	        for(int i=0;i<length;i++){
	            if(!visit[i]){
	                visit[i]=true;
	                combi(idx+1,temp+origin.charAt(i));
	                visit[i]=false;
	            }
	        }
	    }
	}

package 프로그래머스LEVEL2;
import java.util.*;

public class 카카오블라인드2018_1차_캐시 {
	class Solution {
	    public int solution(int cacheSize, String[] cities) {
	        int answer = 0;
	        PriorityQueue<Cache> pq=new PriorityQueue<>((Cache a,Cache b)->{
	            return a.time-b.time;
	        });
	        int time=0;
	        if(cacheSize==0){
	            return cities.length*5;
	        }
	        for(int i=0;i<cities.length;i++){
	            boolean check=false;
	            String now=cities[i];
	            if(pq.size()<cacheSize){
	                Queue<Cache> q=new LinkedList<>();
	                while(!pq.isEmpty()){
	                    Cache t=pq.poll();
	                    if(t.str.toLowerCase().equals(now.toLowerCase())){
	                        time++;
	                        pq.add(new Cache(time,now));
	                        check=true;
	                        break;
	                    }        
	                    q.add(t);
	                }
	                while(!q.isEmpty()) pq.add(q.poll());
	                if(check) continue;
	                time+=5;
	                pq.add(new Cache(time,now));
	            }else{
	                Queue<Cache> q=new LinkedList<>();
	                while(!pq.isEmpty()){
	                    Cache t=pq.poll();
	                    if(t.str.toLowerCase().equals(now.toLowerCase())){
	                        time++;
	                        pq.add(new Cache(time,now));
	                        check=true;
	                        break;
	                    }        
	                    q.add(t);
	                }
	                while(!q.isEmpty()) pq.add(q.poll());
	                if(check) continue;
	                time+=5;
	                pq.poll();
	                pq.add(new Cache(time,now));
	            }
	        }
	        return time;
	    }
	    public class Cache{
	        int time;
	        String str;
	        Cache(int t,String s){
	            time=t;
	            str=s;
	        }
	    }
	}
}

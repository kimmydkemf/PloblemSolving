package 프로그래머스;
import java.util.*;

public class LEVEL3_해시_베스트앨범 {

	class Solution {
	    public int[] solution(String[] genres, int[] plays) {
	        Map<String,genre> map=new HashMap<>();
	        for(int i=0;i<genres.length;i++){
	            if(!map.containsKey(genres[i])){
	                map.put(genres[i],new genre(plays[i],i));
	            }else{
	                genre t=map.get(genres[i]);
	                t.total+=plays[i];
	                t.queue.add(new music(plays[i],i));
	                map.put(genres[i],t);
	            }
	        }
	        PriorityQueue<genre> pq=new PriorityQueue<>((genre a,genre b)->{
	            return b.total-a.total;
	        });
	        Iterator iter=map.values().iterator();
	        while(iter.hasNext()){
	            genre temp=(genre)iter.next();
	            // if(temp.total==1450){
	            //     PriorityQueue<music> q=temp.queue;
	            //     while(!q.isEmpty()){
	            //         System.out.println(q.poll().play);
	            //     }
	            // }
	            pq.add(temp);
	        }
	        Queue<Integer> q=new LinkedList<>();
	        while(!pq.isEmpty()){
	            int idx=0;
	            genre temp=pq.poll();
	            while(!temp.queue.isEmpty()){
	                music m=temp.queue.poll();
	                idx++;
	                if(idx>2)
	                    break;
	                q.add(m.idx);
	            }
	        }
	        int size=q.size();
	        int [] answer=new int[size];
	        for(int i=0;i<size;i++)
	            answer[i]=q.poll();
	        return answer;
	    }
	    class genre{
	        int total;
	        PriorityQueue<music> queue;
	        genre(int t,int i){
	            total=t;
	            queue=new PriorityQueue<music>((music a,music b)->{
	                return b.play-a.play;
	            });
	            queue.add(new music(t,i));
	        }
	    }
	    class music{
	        int play;
	        int idx;
	        music(int p,int i){
	            play=p;
	            idx=i;
	        }
	    }
	}
}

package 프로그래머스;
import java.util.*;

public class LEVEL2_정렬_H_Index {
	class Solution {
	    public int solution(int[] citations) {
	        int answer = 0;
	        Arrays.sort(citations);
	        int start=0;
	        int end=10000;
	        while(start<=end){
	            int mid=(start+end)/2;
	            if(able(mid,citations)){
	                answer=mid;
	                start=mid+1;
	            }else{
	                end=mid-1;
	            }
	        }
	        return answer;
	    }
	    public boolean able(int mid, int[] array){
	        int cnt=0;
	        for(cnt=0;cnt<array.length;cnt++){
	            if(mid<=array[cnt])
	                break;
	        }
	        if(mid<=array.length-cnt)
	            return true;
	        return false;
	    }
	}
}

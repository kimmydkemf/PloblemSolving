package 프로그래머스;
import java.util.*;

public class LEVEL2_정렬_가장큰수 {

	class Solution {
	    public String solution(int[] numbers) {
	        String[] temp=new String[numbers.length];
	        for(int i=0;i<numbers.length;i++)
	            temp[i]=Integer.toString(numbers[i]); 
	        
	         Arrays.sort(temp, new Comparator<String>() {
	            @Override
	            public int compare(String a, String b) {
	                return (b+a).compareTo(a+b);
	                //오름차순 정렬 (o1+o2).compareTo(o1+o2);
	            }
	        });

	        String answer = "";
	        if(temp[0].equals("0"))
	            return "0";
	        for(int i=0;i<numbers.length;i++)
	            answer+=temp[i];
	        return answer;
	    }
	}
}

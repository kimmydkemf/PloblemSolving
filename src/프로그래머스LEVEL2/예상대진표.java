package 프로그래머스LEVEL2;

public class 예상대진표 {
	class Solution
	{
	    public int solution(int n, int a, int b)
	    {
	        int answer = 0;
	        int[] temp=new int[n];
	        for(int i=0;i<n;i++) temp[i]=i+1;
	        answer = dfs(1,temp,a,b);
	        return answer;
	    }
	    public int dfs(int cnt,int []arr,int a,int b){
	        if(arr.length==1) return cnt;
	        int [] temp=new int[arr.length/2];
	        for(int i=0;i<arr.length;i+=2){
	            if((arr[i]==a&&arr[i+1]==b)||(arr[i]==b&&arr[i+1]==a)){
	                return cnt;
	            }else if(arr[i]==a||arr[i+1]==a){
	                temp[i/2]=a;
	            }else if(arr[i]==b||arr[i+1]==b){
	                temp[i/2]=b;
	            }else{
	                temp[i/2]=arr[i];
	            }
	        }
	        return dfs(cnt+1,temp,a,b);
	    }
	}
}

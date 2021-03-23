package 프로그래머스LEVEL2;

public class 단체사진찍기 {
	class Solution {
	    public int answer;
	    public boolean[] visit;
	    public int[] check;
	    public String[] str;
	    public int solution(int n, String[] data) {
	        answer = 0;
	        str=data;
	        visit=new boolean[8];
	        check=new int[8];
	        permu(0);
	        return answer;
	    }
	    public void permu(int idx){
	        if(idx==8){
	            if(good()){
	                answer++;
	            }
	            return;
	        }
	        for(int i=0;i<8;i++){
	            if(!visit[i]){
	                visit[i]=true;
	                check[i]=idx;
	                permu(idx+1);
	                visit[i]=false;
	            }
	        }
	    }
	    public boolean good(){
	        for(String now:str){
	            int n1=match(now.charAt(0));
	            int n2=match(now.charAt(2));
	            int diff=Math.abs(check[n1]-check[n2])-1;
	            switch(now.charAt(3)){
	                case '>':
	                    if(diff>(now.charAt(4)-'0'));
	                    else return false;
	                    break;
	                case '=':
	                    if(diff==(now.charAt(4)-'0'));
	                    else return false;
	                    break;
	                case '<':
	                    if(diff<(now.charAt(4)-'0'));
	                    else return false;
	            }
	        }
	        return true;
	    }
	    public int match(char a){
	        switch(a){
	            case 'A':
	                return 0;
	            case 'C':
	                return 1;
	                case 'F':
	                return 2;
	                case 'J':
	                return 3;
	                case 'M':
	                return 4;
	                case 'N':
	                return 5;
	                case 'R':
	                return 6;
	                case 'T':
	                return 7;
	        }
	        return 0;
	    }
	}
}

package 프로그래머스;

public class LEVEL1_완전탐색_모의고사 {
	class Solution {
	    public int[] solution(int[] answers) {
	        int[] answer = {};
	        int [] supo={1,2,3,4,5,1,2,3,4,5};
	        int [] supo2={2,1,2,3,2,4,2,5};
	        int [] supo3={3,3,1,1,2,2,4,4,5,5};
	        int cnt[]=new int[3];
	        int size=answers.length;
	        for(int i=0;i<size;i++){
	            if(answers[i]==supo[i%10]){
	                cnt[0]++;
	            }
	            if(answers[i]==supo2[i%8]){
	                cnt[1]++;
	            }if(answers[i]==supo3[i%10]){
	                cnt[2]++;
	            }
	        }
	        int max=Math.max(cnt[0],cnt[1]);
	        max=Math.max(max,cnt[2]);
	        int maxcnt=0;
	        for(int i=0;i<3;i++){
	            if(max==cnt[i])
	                maxcnt++;
	        }
	        answer = new int[maxcnt];
	        int idx=0;
	        for(int i=0;i<3;i++){
	            if(max==cnt[i])
	                answer[idx++]=i+1;
	        }
	        return answer;
	    }
	}
}

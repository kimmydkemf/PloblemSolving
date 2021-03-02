package 프로그래머스;
import java.util.*;
import java.io.*;

public class LEVEL2_해시_전화번호목록 {

	class Solution {
	    public boolean solution(String[] phone_book) {
	        boolean answer = true;
	        int size=phone_book.length;
	        for(int i=0;i<size-1;i++){
	            int hashPhone = phone_book[i].hashCode();
	            int len=phone_book[i].length();
	            for(int j=i+1;j<size;j++){
	                if(phone_book[j].length() >= len
	                  &&hashPhone==phone_book[j].substring(0,len).hashCode()){
	                    return false;
	                }else if(phone_book[j].length() < len
	                       && phone_book[i].substring(0,phone_book[j].length()).hashCode() 
	                        == phone_book[j].hashCode())
	                {  return false;}
	            }
	        }
	        return answer;
	    }
	}
}

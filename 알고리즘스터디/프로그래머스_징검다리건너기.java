import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        
        answer = dfs(p);
        
        return answer;
    }
    
    public static boolean isOk(String str){
        int len = str.length();
        
        if(str.charAt(0)==')')return false;
        else{
            int cnt=0;
            for(int i=0;i<len;i++){
                char c = str.charAt(i);
                
                if(c=='(')cnt++;
                else cnt--;
                
                if(cnt<0)return false;
                
            }            
        }
        return true;
    }
    
    public static String dfs(String str){
        String res="";
        
        //1
        if(str.equals(""))return str;
        
        int cnt=0;
        int idx=0;
        
        while(idx<str.length()){
            char c = str.charAt(idx++);
            if(c=='(')cnt++;
            else cnt--;
            
            if(cnt==0)break;
        }
        
        //2
        String u = str.substring(0,idx);
        String v = str.substring(idx,str.length());
        
        //3
        if(isOk(u)){
            res = u+dfs(v);
        }else{
            //4
            res= "("+dfs(v)+")";
            
            int u_len = u.length();
            for(int i=1;i<u_len-1;i++){
                char c = u.charAt(i);
                
                if(c=='(')res+=')';
                else res+='(';
            }

        }
        return res;
        
        
        
        
    }
}
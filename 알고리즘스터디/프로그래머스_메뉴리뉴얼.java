import java.util.*;
class Solution {
    static boolean [] visited;
    static HashMap<String,Integer>map;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        LinkedHashSet<String> res = new LinkedHashSet<>();
        
        map = new HashMap<>();
        for(int i=0;i<course.length;i++){
            
            for(String s : orders){
                if(course[i]<=s.length()){
                    visited =new boolean[s.length()];
                    combinations(s,0,0,course[i],"");
                }
            }//end of for
            ArrayList<String>list = new ArrayList<>();
            for(String a : map.keySet()){
                list.add(a);
                // System.out.println(a+":"+map.get(a));
                
            }
                   
                    
            Collections.sort(list,(o1,o2)->map.get(o2)-map.get(o1));
            if(list.size()>0){
                int max =map.get(list.get(0));
                // System.out.println("max: "+max);
                for(String a : list){
                    // System.out.println(a+":"+map.get(a));
                    if(map.get(a)>=2 && map.get(a)==max){
                        res.add(a);
                    }else {
                        break;
                    }

                }
            }

            map.clear();
            
        }//end of for
        
        ArrayList<String>list = new ArrayList<>(res);
        Collections.sort(list);
        answer = new String[list.size()];
        int idx=0;
        for(String s : list){
            answer[idx++]=s;
        }
        
        return answer;
    }
    public static void combinations(String s, int start, int depth, int r, String res){
        if(depth==r){
            ArrayList<Character>list = new ArrayList<>();
            // System.out.println(r+"-"+res);
            for(int i=0;i<res.length();i++){
                list.add(res.charAt(i));
            }
            
            Collections.sort(list);
            String str="";
            for(Character a : list){
                str+=a;
            }
            // System.out.println(str);
            
            map.put(str,map.getOrDefault(str,0)+1);
            return;
        }
        for(int i=start;i<s.length();i++){
            if(!visited[i]){
                visited[i]=true;
                combinations(s,i+1,depth+1,r, res+s.charAt(i));
                visited[i]=false;
            }
            
        }
    }
}
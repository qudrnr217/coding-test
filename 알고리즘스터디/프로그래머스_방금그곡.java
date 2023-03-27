class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        int max=0;
        m=change_word(m);
        //같은 조건일 때 재생된 시간이 가장 긴 음악 제목을 반환
        //것도 같으면 먼저나온 음악 제목 반환
        for(String s : musicinfos){
            String [] str = s.split(",");
            
            int start = StringToInt(str[0]);
            int end = StringToInt(str[1]);
            // if(end==0){
            //     end=86400;
            // }
            
            int time = end-start;
            String title = str[2];
            String music = str[3];
            
            music=change_word(music);
            
            
            String ans = "";
            int cnt=0;
            int idx=0;
            while(cnt<time){
                ans+=music.charAt(idx%music.length());
                idx++;
                cnt++;
            }
            // System.out.println(ans);
            
            if(ans.contains(m)){
                if(max<time){
                    max=time;
                    answer=title;
                }
            }
            
        }
        
        return answer==""?"(None)":answer;
    }
    
    public static int StringToInt(String s){
        int res =0;
        String []str = s.split(":");
        
        res+=Integer.parseInt(str[0])*60;
        res+=Integer.parseInt(str[1]);
        
        return res;
        
        
    }
    public static String change_word(String s){
        s = s.replaceAll("C#","c");
        s = s.replaceAll("D#","d");
        s = s.replaceAll("F#","f");
        s = s.replaceAll("G#","g");
        s = s.replaceAll("A#","a");
        return s;
    }
}
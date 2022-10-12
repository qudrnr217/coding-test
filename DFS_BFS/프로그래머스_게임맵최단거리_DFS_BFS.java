import java.util.*;
//DFS로 풀었는데 효율성 0 나머지는 다맞음. 밑에서 BFS로 풀어야함.

// class Solution {
//     static boolean [][]visited;
//     static int [] dx ={-1,1,0,0};
//     static int [] dy ={0,0,-1,1};
//     static int res=10000;
//     public int solution(int[][] maps) {
//         int answer = 0;
//         int a=maps.length;
//         int b=maps[0].length;
//         visited = new boolean[a][b];
//         visited[0][0]=true;
//         dfs(0,0,a,b,maps,1);
        
//         answer=res;
//         // System.out.println(maps.length+":"+maps[0].length);
//         return answer!=10000?answer:-1;
//     }
    
//     public static void dfs(int x,int y,int a, int b, int [][]maps,int cnt){
//         if(x==a-1 && y==b-1){
//             res=Math.min(res,cnt);
//             return;
//         }
//         for(int i=0;i<4;i++){
//             int nx =x+dx[i];
//             int ny =y+dy[i];
            
//             if(nx<0 || ny<0 || nx>=a || ny>=b)continue;
//             if(maps[nx][ny]==1 && !visited[nx][ny]){
//                 visited[nx][ny]=true;
//                 dfs(nx,ny,a,b,maps,cnt+1);
//                 visited[nx][ny]=false;
//             }
//         }
//     }
// }


class Solution {
    static boolean [][]visited;
    static int [] dx ={-1,1,0,0};
    static int [] dy ={0,0,-1,1};
    static int res=10000;
    public int solution(int[][] maps) {
        int answer = 0;
        int a=maps.length;
        int b=maps[0].length;
        visited = new boolean[a][b];
       
        
        
        answer=bfs(0,0,a,b,maps);
        // System.out.println(maps.length+":"+maps[0].length);
        return answer;
    }
    
    public static int bfs(int x,int y,int a, int b, int [][]maps){
        Queue<int[]>q= new LinkedList<>();
        q.add(new int[]{x,y,1});
        visited[x][y]=true;
        
        while(!q.isEmpty()){
            int[] cur=q.poll();
            if(cur[0]==a-1 && cur[1]==b-1){
                // System.out.println("hi");
                return cur[2];
            }   
            
            for(int i=0;i<4;i++){
                int nx =cur[0]+dx[i];
                int ny =cur[1]+dy[i];
                int cnt=cur[2];
                if(nx<0 || ny<0 || nx>=a || ny>=b)continue;
                if(maps[nx][ny]==1 && !visited[nx][ny]){
                    q.add(new int[]{nx,ny,cnt+1});
                    visited[nx][ny]=true;
                    
                }
            }
        }
        
     return -1;  
    }
}
import java.util.*;
class Solution {
    static int [][]arr;
    static boolean [][]visited;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        arr =new int[101][101];
        //사각형 테두리를 채우자 내부는 -1으로 채우자
        for(int i=0;i<rectangle.length;i++){
            fill(rectangle[i][0]*2,rectangle[i][1]*2,rectangle[i][2]*2,rectangle[i][3]*2);
        }
        
        //2차원 배열 제대로 들어갔는지 확인 코드
        // for(int i=0;i<101;i++){
        //     for(int j=0;j<101;j++){
        //         System.out.print(arr[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        //출발점에서 출발하여 bfs로가자
        visited=new boolean[101][101];
        answer=bfs(characterX*2,characterY*2,itemX*2,itemY*2);
        
        
        
        return answer/2;
    }
    static int [] dx ={1,-1,0,0};
    static int [] dy ={0,0,-1,1};
    public static int bfs(int x1,int y1,int x2, int y2){
        Queue<int[]>q =new LinkedList<>();
        q.add(new int[]{x1,y1,0});
        visited[x1][y1]=true;
        
        while(!q.isEmpty()){
            int []cur =q.poll();
            
            if(cur[0]==x2 && cur[1]==y2){
                return cur[2];
            }
            
            for(int i=0;i<4;i++){
                int nx= cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                int cnt = cur[2];
                
                if(nx>=0 && ny>=0 && nx<101 && ny<101){
                    if(arr[nx][ny]==1 && !visited[nx][ny]){
                        q.add(new int[]{nx,ny,cnt+1});
                        visited[nx][ny]=true;
                    }
                }
            }
        }
        return 0;
    }
    
    public static void fill(int a,int b,int c,int d){
        // System.out.print(a+":"+b+":"+c+":"+d);
        for(int i=a;i<=c;i++){
            for(int j=b;j<=d;j++){
                if(arr[i][j]==-1)continue;
                arr[i][j]=-1;
                if(i==a || i==c || j==b || j==d){
                    arr[i][j]=1;
                }
            }
        }
        
    }
}

/**
* 나도 안을 -1로 채우는데 까지 생각을 했지만 2배로 늘려야 답이 나온다는 것을 알게됨.
* 한 블로그에서 여기서는 선으로 연결된 부분을 찾아가야하는데(0,1) (1,1)이 연결되어있는지 확인이 불가함을
* 보여줌. 따라서 2배로 늘리면 연결되어있는지 아닌지 판별이 가능! 이게 제일 중요한듯
* 그리고 바로 bfs로 최단거리를 찾으면된다.
* 참고 https://arinnh.tistory.com/88
*/
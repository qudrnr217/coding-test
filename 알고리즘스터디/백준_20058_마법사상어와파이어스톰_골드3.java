package 알고리즘스터디;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_20058_마법사상어와파이어스톰_골드3 {
	private static int n;
	private static int q;
	private static int[][] arr;
	private static int len;
	private static int size;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static int ice_cnt;
	private static int max_cnt;
	private static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n =sc.nextInt(); 
		q =sc.nextInt(); //마법사가 파이어스톰을 시전한 횟수
		
		len = (int)Math.pow(2, n);
		
		arr =new int [len][len];
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for (int p = 0; p < q; p++) {
			int l = sc.nextInt();
			
			size = (int)Math.pow(2, l);
			
			int [][] c_arr = new int[len][len];
			for (int i = 0; i < len; i+=size) {
				for (int j = 0; j < len; j+=size) {
					//1. 90도 회전한다.
					rotate(i,j,c_arr,size);
					
				}
			}
//			print(c_arr);
			//이 후 얼음이 3개이상 인접해 있지 않다면 얼음의 양이 1만큼 줄어 든다.
			arr = melt(c_arr);

		}
		
		
//		print(arr);
		
		ice_cnt=0;
		max_cnt=0;
		
		visited = new boolean[len][len];
		//남아 있는 얼음의 합
		//남아 있는 얼음중 가장 큰 덩어리가 차지하는 칸의 개수
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if(arr[i][j]>0 && !visited[i][j]) {
					int num = bfs(i,j);
					max_cnt= Math.max(max_cnt, num);
					
				}
			}
		}
		
		System.out.println(ice_cnt);
		System.out.println(max_cnt);
		
				
		
		
	}
	private static int bfs(int x, int y) {
		
		Queue<int[]> q=  new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		ice_cnt+=arr[x][y];
		int cnt=1;
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			
			int a = cur[0];
			int b = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				
				if(nx<0 || nx>len-1 || ny<0 || ny>len-1 || arr[nx][ny]==0
						|| visited[nx][ny])continue;
				
				q.add(new int[] {nx,ny});
				visited[nx][ny]=true;
				cnt++;
				ice_cnt+=arr[nx][ny];
				
			}
		}
		
		return cnt;
	}
	private static int[][] melt(int [][] arr) {
		
		int [][] c_arr = new int[len][len];
		for (int i = 0; i < arr.length; i++) {
			System.arraycopy(arr[i], 0, c_arr[i], 0, arr[i].length);
		}
		
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				if(arr[i][j]!=0) {
					if(isok(i,j,arr)) {
						c_arr[i][j]--;
					}
				}
			}
		}
		
		
		return c_arr;
		
	}
	private static boolean isok(int x, int y, int[][] arr) {
		
		int cnt=0;
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx>len-1 || ny<0 || ny>len-1)continue;
			
			if(arr[nx][ny]>0)cnt++;
		}
		
		if(cnt<3)return true;
		return false;
	}
	
	public static void rotate(int x ,int y, int [][]c_arr, int l){
        for(int i=0;i<l;i++){
            for(int j=0;j<l;j++){
                c_arr[x+i][y+j] = arr[x+l-1-j][y+i];
            }
        }
        
    }
	
	public static void print(int [][] arr) {
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

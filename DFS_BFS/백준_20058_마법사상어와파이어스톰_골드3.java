package DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_20058_마법사상어와파이어스톰_골드3 {
	private static int[][] arr;
	private static int n;
	private static int num;
	private static int q;
	private static int ic_cnt;
	private static int big_cnt;
	private static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		q = sc.nextInt();
		
		num = (int)Math.pow(2, n);
		
		arr =new int[num][num];
		
		for(int i=0;i<num;i++) {
			for (int j = 0; j < num; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		for (int i = 0; i < q; i++) {
			int a= sc.nextInt();
			
			//얼음 나누기
			arr = divide(a);
			//얼음 녹이기
			arr = melt();
		}
		ic_cnt = 0;
		big_cnt = 0;
		visited= new boolean[num][num];
		
		
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if(arr[i][j]!=0 && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		
		System.out.println(ic_cnt);
		System.out.println(big_cnt);
		
		
	}
	
	public static void print() {
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	private static void bfs(int x, int y) {
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		int cnt=0;
		ic_cnt+=arr[x][y];
		
		while(!q.isEmpty()) {
			int [] cur =q.poll();
			int a = cur[0];
			int b = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				
				if(nx<0 || nx>num-1 || ny<0 || ny>num-1)continue;
				if(arr[nx][ny]!=0 && !visited[nx][ny]) {
					visited[nx][ny]=true;
					q.add(new int[] {nx,ny});
					cnt++;
					ic_cnt+=arr[nx][ny];
				}
			}
		}
		

		big_cnt=Math.max(big_cnt, cnt+1);
		
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static int[][] melt() {
		int [][] c_arr= new int[num][num];
		for (int i = 0; i < num; i++) {
			c_arr[i]=Arrays.copyOf(arr[i], num);
		}
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				int cnt=0;
				if(arr[i][j]==0)continue;
				
				for (int k = 0; k < 4; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					if(nx<0 || nx>num-1 || ny<0 || ny>num-1)continue;
					if(arr[nx][ny]>0)cnt++;
				}
				
				if(cnt<3)c_arr[i][j]--;
			}
		}
		
		
		return c_arr;
	}

	private static int[][] divide(int a) {
		
		int [][] c_arr =new int[num][num];
		int idx = (int)Math.pow(2, a);
		for (int i = 0; i < num; i+=idx) {
			for (int j = 0; j < num; j+=idx) {
				rotate(i,j,idx,c_arr);
			}
		}
		
		return c_arr;
	}

	private static void rotate(int x, int y, int idx, int[][] c_arr) {
		for (int i = 0; i < idx; i++) {
			for (int j = 0; j < idx; j++) {
				c_arr[x+i][y+j]=arr[x+idx-1-j][y+i];
			}
		}
	}
}

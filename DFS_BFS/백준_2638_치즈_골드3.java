package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_2638_치즈_골드3 {
	private static int n;
	private static int m;
	private static int[][] arr;
	private static boolean[][] visited;
	static Queue<Integer> xx;
	static Queue<Integer> yy;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr =new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		int answer=0;
		while(true) {
			visited =new boolean[n][m];
			int idx = -1;
			//가장 바깥 부분 -1로 만들기
			bfs(0,0,idx);
			
			
			
//			print();
			xx = new LinkedList<>();
			yy = new LinkedList<>();
			
			visited =new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(arr[i][j]==1) {
						go(i,j);
					}
				}
			}
			
			while(xx.isEmpty()) {
				System.out.println(answer);
				return;
			}
			
			answer++;
			
			while(!xx.isEmpty()) {
				arr[xx.poll()][yy.poll()]=0;
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(arr[i][j]==-1) {
						arr[i][j]=0;
					}
				}
			}
			
			
//			print();
		}
		
		
	}
	private static void go(int x, int y) {
		Queue<int[]> q =new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			int [] cur =q.poll();
			int a = cur[0];
			int b = cur[1];
			int cnt=0;
			for (int i = 0; i < 4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>m-1)continue;
				if(arr[nx][ny]==-1) {
					cnt++;
				}
			}
			if(cnt>=2) {
				visited[a][b]=true;
				xx.add(a);
				yy.add(b);
				return;
			}
			
		}
	}
	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}
	static int [] dx= {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static void bfs(int x, int y, int num) {
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		arr[x][y]=num;
		while(!q.isEmpty()){
			int [] cur =q.poll();
			int a = cur[0];
			int b = cur[1];
			for (int i = 0; i < 4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>m-1)continue;
				if(arr[nx][ny]==0 && !visited[nx][ny]) {
					q.add(new int [] {nx,ny});
					visited[nx][ny]=true;
					arr[nx][ny]=num;
				}
			}
		}
	}
}

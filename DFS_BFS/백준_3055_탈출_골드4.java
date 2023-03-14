package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_3055_탈출_골드4 {
	static Queue<int[]> q; 
	static Queue<int[]> water;
	private static int m;
	private static char[][] arr;
	private static int n;
	private static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr =new char[n][m];
		answer=n*m;
		
		q = new LinkedList<>();
		water = new LinkedList<>();
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				arr[i][j]=s.charAt(j);
				if(arr[i][j]=='S') {
					q.add(new int[] {i,j,0});
				}else if(arr[i][j]=='*') {
					water.add(new int[] {i,j});
				}
			}
		}
		
		
		bfs();
		System.out.println(answer==n*m?"KAKTUS":answer);

		
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static void bfs() {
		while(!q.isEmpty()) {
			int len = water.size();
			
			for (int i = 0; i < len; i++) {
				int [] cur = water.poll();
				for(int k=0;k<4;k++) {
					int nx = cur[0]+dx[k];
					int ny = cur[1]+dy[k];
					
					if(nx<0 || nx>n-1 || ny<0 || ny>m-1)continue;
					if(arr[nx][ny]=='.' || arr[nx][ny]=='S') {
						arr[nx][ny]='*';
						water.add(new int[] {nx,ny});
					}
				}
			}
			
			len = q.size();
			for (int i = 0; i < len; i++) {
				int [] cur = q.poll();
//				System.out.println(cur[0]+":"+cur[1]+":"+cur[2]);
				for(int k=0;k<4;k++) {
					int nx = cur[0]+dx[k];
					int ny = cur[1]+dy[k];
					
					if(nx<0 || nx>n-1 || ny<0 || ny>m-1)continue;
					else if(arr[nx][ny]=='D') {
//						System.out.println("hi");
						answer=Math.min(answer, cur[2]+1);
						return;
					}
					else if(arr[nx][ny]=='.') {
						arr[nx][ny]='S';
						q.add(new int[] {nx,ny,cur[2]+1});
					}
				}
			}
			for(int i=0;i<n;i++) {
				for (int j = 0; j < m; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}

		
	}
}

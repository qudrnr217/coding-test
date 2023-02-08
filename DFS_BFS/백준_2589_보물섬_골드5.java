package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2589_보물섬_골드5 {
	private static int[][] dist;
	private static int n;
	private static int m;
	private static char[][] arr;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr =new char[n][m];
		
		for(int i=0;i<n;i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		
		
		int res=0;
		for(int i=0;i<n;i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j]=='L') {
					visited = new boolean[n][m];
					res=Math.max(res, bfs(i,j));
				}
			}
		}
		System.out.println(res);
		
		
		
		
	}

	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	private static int bfs(int x, int y) {
		dist =new int[n][m];
		
		for(int i=0;i<n;i++) {
			Arrays.fill(dist[i],250);
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y,0});
		dist[x][y]=0;
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			int [] cur =q.poll();
			for(int i=0;i<4;i++) {
				int nx = cur[0]+dx[i];
				int ny = cur[1]+dy[i];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>m-1)continue;
				if(!visited[nx][ny] && arr[nx][ny]=='L') {
					if(dist[nx][ny]>dist[cur[0]][cur[1]]+1) {
						dist[nx][ny]=dist[cur[0]][cur[1]]+1;
						visited[nx][ny]=true;
						q.add(new int[] {nx,ny,dist[nx][ny] });
					}
				}
			}
			
		}
		int max =0;
		for(int i=0;i<n;i++) {
			for (int j = 0; j < m; j++) {
				if(dist[i][j]==250)continue;
				max = Integer.max(max, dist[i][j]);
			}
		}
		return max;
	}
}

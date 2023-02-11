package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_14442_벽부수고이동하기2_골드3 {
	private static char[][] arr;
	private static boolean[][][] visited;
	private static int n;
	private static int m;
	private static int k;
	private static int answer;

	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		arr =new char[n][m];
		
		for (int i = 0; i < n; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		visited =new boolean[n][m][k+1];
		answer =Integer.MAX_VALUE;
		System.out.println(bfs(0,0));
//		System.out.println(answer);
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static int bfs(int x, int y) {
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {x,y,1,0});
		visited[x][y][0]=true;
		
		while(!q.isEmpty()) {
			int [] cur =q.poll();
			int a = cur[0];
			int b = cur[1];
			int c = cur[2];
			int d = cur[3];
			
			if(a==n-1 && b==m-1) {
//				System.out.println("hi");
				answer = Math.min(answer, c);
				return answer;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				if(nx<0 || nx>n-1 || ny<0 || ny>m-1)continue;
//				System.out.println(nx+":"+ny+":"+d);
				if(arr[nx][ny]=='0') {
					if(!visited[nx][ny][d]) {
						visited[nx][ny][d]=true;
						q.add(new int[] {nx,ny,c+1,d});
					}
					
				}else if(arr[nx][ny]=='1') {
					if(d<k && !visited[nx][ny][d+1]) {
						visited[nx][ny][d+1]=true;
						q.add(new int[] {nx,ny,c+1,d+1});
					}
				}
				
			}
		}
		return -1;
		
	}
}

package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1743_음식물피하기_실버1 {
	private static int n;
	private static int m;
	private static int[][] arr;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		int k = sc.nextInt();
		
		arr =new int[n][m];
		
		for (int i = 0; i < k; i++) {
			int a= sc.nextInt();
			int b= sc.nextInt();
			
			arr[a-1][b-1]=1;
		}
		int answer=0;
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					answer = Math.max(answer, bfs(i,j));
				}
			}
		}
		System.out.println(answer);
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static boolean[][] visited;
	private static int bfs(int x, int y) {
		
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		int cnt=1;
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			
			int a = cur[0];
			int b = cur[1];
			
			for(int i=0;i<4;i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>m-1)continue;
				if(arr[nx][ny]==1 && !visited[nx][ny]) {
					q.add(new int[] {nx,ny});
					visited[nx][ny]=true;
					cnt++;
				}
			}
			
		}
		return cnt;
		
		
	}
}

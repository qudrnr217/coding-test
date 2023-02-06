package DFS;

import java.util.Scanner;

public class 백준_1103_게임_골드2 {
	private static char[][] arr;
	private static int n;
	private static int m;
	static boolean cycle=false;
	private static int max;
	private static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr =new char[n][m];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLine().toCharArray();
		}
		max =0;
		visited =new boolean[n][m];
		dp = new int[n][m];
		dfs(0,0,1);
		if(cycle) {
			System.out.println(-1);
		}else {
			System.out.println(max);
		}
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static int[][] dp;
	private static void dfs(int x, int y, int cnt) {
//		System.out.println(x+":"+y);
		dp[x][y]=cnt;
		int num = arr[x][y]-'0';
		
		if(cnt>max) {
			max = cnt;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i]*num;
			int ny = y+dy[i]*num;
			if(nx<0 || ny<0 || nx>n-1 || ny>m-1)continue;
			if(arr[nx][ny]=='H')continue;
			if(cnt<dp[nx][ny])continue;
			if(visited[nx][ny]) {
				cycle =true;
				return;
			}
			
			visited[nx][ny]=true;
			dfs(nx,ny,cnt+1);
			visited[nx][ny]=false;
		}
	}
}

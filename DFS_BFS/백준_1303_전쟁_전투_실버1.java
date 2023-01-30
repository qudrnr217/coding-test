package DFS;

import java.util.Scanner;

public class 백준_1303_전쟁_전투_실버1 {
	private static char[][] arr;
	private static boolean[][] visited;
	private static int n;
	private static int m;
	static int cnt=0;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		m =sc.nextInt();
		n = sc.nextInt();
		
		arr =new char[n][m];
		
		int answer1=0;
		int answer2=0;
		
		sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextLine().toCharArray();
		}
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(arr[i][j]=='W' && !visited[i][j]) {
					cnt=0;
					dfs(i,j,arr[i][j]);
					answer1+=cnt*cnt;
				}else if(arr[i][j]=='B' && !visited[i][j]) {
					cnt =0;
					dfs(i,j,arr[i][j]);
					answer2+=cnt*cnt;
				}
			}
		}
		System.out.println(answer1+" "+answer2);
	}

	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static void dfs(int x, int y, char num) {
		
		visited[x][y]=true;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx>n-1 || ny<0 || ny>m-1 || visited[nx][ny])continue;
			
			if(arr[nx][ny]==num) {
				dfs(nx,ny,num);
			}
		}
		
	}
}

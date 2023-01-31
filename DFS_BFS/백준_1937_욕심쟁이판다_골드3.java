package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1937_욕심쟁이판다_골드3 {
	private static int n;
	private static int[][] arr;
	private static int max;
	static int [][] memo;
	public static void main(String[] args) {
		//먹은 지역보다 더 큰 지역으로만 간다.
		//어떤 곳에 풀어야지 최대한 많은 칸을 방문할 수 있는지 고민
		
		Scanner sc= new Scanner(System.in);
		
		n = sc.nextInt();
		arr= new int[n][n];
		memo = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		max = 0;
		
		for(int i=0;i<n;i++) {
			for (int j = 0; j < n; j++) {
				max=Math.max(max,dfs(i,j));
			}
		}
		
		System.out.println(max);
		
		
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static int dfs(int x, int y) {
		if(memo[x][y]!=0)return memo[x][y];
		
		memo[x][y]=1; //판다가 최소 1년은 살 수 있으므로, 1로 해줘야 가장 끝에서부터 1씩 더해올 수 있다.
		
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0 || nx>n-1 || ny<0 || ny>n-1)continue;
			
			if(arr[x][y]<arr[nx][ny]) {
				//bottom up 방식
				memo[x][y] = Math.max(memo[x][y], dfs(nx,ny)+1);
			}
		}
		return memo[x][y];
		
	}
}

package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_2665_미로만들기_골드4 {
	private static int n;
	private static int[][] arr;
	private static int[][] distance;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr =new int[n][n];
		distance = new int[n][n];
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String s = sc.nextLine();
			for (int j = 0; j < n; j++) {
//				System.out.println(s);
				arr[i][j]=s.charAt(j)-'0';
			}
		}
		
		
		for(int i=0;i<n;i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}
		
		System.out.println(bfs(0,0));
		
	}

	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	private static int bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		distance[x][y]=0;
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int a = cur[0];
			int b = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1)continue;
				if(distance[a][b]<distance[nx][ny]) {
					if(arr[nx][ny]==1) {
						q.add(new int[] {nx,ny});
						distance[nx][ny]=distance[a][b];
					}
					else if(arr[nx][ny]==0) {
						q.add(new int[] {nx,ny});
						distance[nx][ny]=distance[a][b]+1;
					}
				}
				
			}
		}
		return distance[n-1][n-1];
		
	}
}

package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_18405_경쟁적전염_골드5 {
	private static int[][] arr;
	private static int n;
	private static int k;
	private static int s;
	private static int a;
	private static int b;
	private static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		
		arr =new int[n][n];
		
		ArrayList<int[]> list =new ArrayList<int[]>();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]!=0)list.add(new int[] {arr[i][j],i,j});
			}
		}
		
		Collections.sort(list,(o1,o2)->o1[0]-o2[0]);
		
//		for(int [] a : list) {
//			System.out.println(a[0]+":"+a[1]+":"+a[2]);
//		}
		
		s = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		visited = new boolean[n][n];
		bfs(list);
		System.out.println(arr[a-1][b-1]);
	}

	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	private static void bfs(ArrayList<int[]> list) {
		Queue<int[]> q= new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			int [] num =list.get(i);
			q.add(new int[] {num[0],num[1],num[2],0});
			visited[num[1]][num[2]]=true;
		}
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			
			int num = cur[0];
			int x = cur[1];
			int y = cur[2];
			int cnt=cur[3];
			
			if(cnt==s) {
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || nx >n-1 || ny<0 || ny>n-1 || arr[nx][ny]!=0)continue;
				if(arr[nx][ny]==0 && !visited[nx][ny]) {
					q.add(new int[] {num,nx,ny,cnt+1});
					arr[nx][ny]=num;
					visited[nx][ny]=true;
				}
			}
		}
		
		
	}
}

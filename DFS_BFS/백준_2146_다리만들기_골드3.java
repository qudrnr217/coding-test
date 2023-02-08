package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_2146_다리만들기_골드3 {
	private static int n;
	private static int[][] c_arr;
	private static int answer;
	private static boolean[][] land;
	private static int[][] arr;
	public static class Node{
		int x,y,land;
		public Node(int x,int y, int land) {
			this.x=x;
			this.y=y;
			this.land=land;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n= sc.nextInt();
		
		arr =new int[n][n];
		
		for(int i=0;i<n;i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		
		land = new boolean[n][n];
		
		//땅 가르기
		int idx=1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j]==1 && !land[i][j]) {
					divide(i,j,idx);
					idx++;
				}
			}
		}
		
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		
		answer =Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j]!=0) {
					c_arr =new int[n][n];
					for(int k=0;k<n;k++) {
						System.arraycopy(arr[k], 0, c_arr[k], 0, arr[k].length);
					}
					bfs(i,j);//1을 만날때까지 확산
				}
			}
		}
		
		System.out.println(answer==0?0:answer-1);
		
	}
	private static void divide(int x, int y,int idx) {
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {x,y});
		land[x][y]=true;
		arr[x][y]=idx;
		
		while(!q.isEmpty()) {
			int [] cur =q.poll();
			int a = cur[0];
			int b = cur[1];
			
			for(int i=0;i<4;i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1)continue;
				if(arr[nx][ny]==1 && !land[nx][ny]) {
					arr[nx][ny]=idx;
					land[nx][ny]=true;
					q.add(new int[] {nx,ny});
				}
			}
		}
		
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static void bfs(int x, int y) {
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {x,y,0});
		boolean [][] visited =new boolean[n][n];
		visited[x][y]=true;
		
		int start = c_arr[x][y];
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int a = cur[0];
			int b = cur[1];
			int cost = cur[2];
			
			
			if(c_arr[a][b]!=start && c_arr[a][b]!=0) {
//				System.out.println("hi"+cost);
				answer = Math.min(answer, cost);
//				System.out.println(cost);
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1 || c_arr[nx][ny]==start)continue;
				
				if(!visited[nx][ny] && c_arr[nx][ny]!=start) {
					q.add(new int[] {nx,ny,cost+1});
					visited[nx][ny]=true;
				}
				
			}
			
			
		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				System.out.print(c_arr[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
	}
}

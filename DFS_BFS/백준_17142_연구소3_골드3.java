package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_17142_연구소3_골드3 {
	private static int[][] arr;
	private static int n;
	private static int m;
	static ArrayList<int[]> list;
	private static boolean[] visited;
	private static int[][] c_arr;
	private static int empty;
	private static int answer;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);	
		
		n = sc.nextInt();
		
		arr =new int[n][n];
		
		m = sc.nextInt();
		
		list =new ArrayList<>();
		empty = 0;
		for(int i=0;i<n;i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==2) { //2의 위치 저장
					list.add(new int[] {i,j});
				}else if(arr[i][j]==0) {
					empty++;
				}
			}
		}
		answer = Integer.MAX_VALUE;
		
		if(empty==0) {
			System.out.println(0);
			return;
		}
		
		visited =new boolean[list.size()];
		combinations(0,0);
		
		
		if(answer==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(answer);
		}
		
		
		
		
	}

	private static void combinations(int start, int depth) {
		
		if(depth == m) {
			c_arr = new int[n][n];
			copy();
			for (int i = 0; i < list.size(); i++) {
				if(!visited[i]) { //비활성화 바이러스를 -2으로 초기화
					int [] cur = list.get(i);
					c_arr[cur[0]][cur[1]]=-2;
				}
			}
			
			bfs(empty);
		}
		
		for (int i = start; i <list.size(); i++) {
			visited[i]=true;
			combinations(i+1, depth+1);
			visited[i]=false;
		}
	}

	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static void bfs(int cnt) {
		Queue<int[]> q= new LinkedList<>();
		boolean [][] spread =new boolean[n][n];
		for(int i=0;i<list.size();i++) {
			if(visited[i]) {
				int [] cur = list.get(i);
				q.add(new int[] {cur[0],cur[1],0});
				spread[cur[0]][cur[1]]=true;
//				System.out.println(list.get(i)[0]+":"+list.get(i)[1]);
			}
		}
//		print();
		
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int a = cur[0];
			int b = cur[1];
			int c = cur[2];
//			System.out.println(a+":"+b+":"+cnt);
			for(int i=0;i<4;i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1)continue;
				if(c_arr[nx][ny]==1 || spread[nx][ny])continue;
				if(c_arr[nx][ny]==-2) {
					q.add(new int[] {nx,ny,c+1});
					spread[nx][ny]=true;
				}
				if(c_arr[nx][ny]==0) {
					q.add(new int[] {nx,ny,c+1});
					spread[nx][ny]=true;
					cnt--;
				}
				
				if(cnt==0) {
					answer =Math.min(answer, c+1);
					return;
				}
			}
			
		} //end of while
//		System.out.println();
		
		
		
	}


	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(c_arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static void copy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				c_arr[i][j]=arr[i][j];
			}
		}
		
	}
}

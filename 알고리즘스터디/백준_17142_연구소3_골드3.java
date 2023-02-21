package 알고리즘스터디;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class 백준_17142_연구소3_골드3 {
	private static int[][] arr;
	private static ArrayList<int[]> list;
	private static int empty;
	private static int answer;
	private static boolean[] visited;
	private static int m;
	private static int n;
	private static int[][] c_arr;

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr =new int[n][n];
		
		empty = 0;
		
		answer = Integer.MAX_VALUE; 
		
		list =new ArrayList<int[]>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==2) {
					list.add(new int[] {i,j});
				}else if(arr[i][j]==0)empty++;
			}
		}
		
		if(empty==0) {
			System.out.println(0);
			return;
		}
		
		visited = new boolean[list.size()];
		
		combinations(0,0);
		
		System.out.println(answer==Integer.MAX_VALUE?-1:answer);
		
		
	}

	private static void combinations(int depth, int start) {
		
		if(depth==m) {
			c_arr =new int[n][n];
			for (int i = 0; i < n; i++) {
				System.arraycopy(arr[i], 0, c_arr[i], 0, arr[i].length);
			}
			
			for (int i = 0; i < list.size(); i++) {

				if(visited[i]) {
					int [] a = list.get(i);
//					System.out.print(a[0]+":"+a[1]+" ");
					c_arr[a[0]][a[1]]=-2;
				}
			}
//			print();
//			System.out.println();
			bfs(empty);
			return;
		}
		
		for (int i = start; i < list.size(); i++) {
			visited[i]=true;
			combinations(depth+1, i+1);
			visited[i]=false;
		}
		
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static boolean[][] spread;
	private static void bfs(int cnt) {
		spread = new boolean[n][n];
		Queue<int[]>q =new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(c_arr[i][j]==-2) {
					q.add(new int[] {i,j,0});
					spread[i][j]=true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int a = cur[0];
			int b = cur[1];
			int c = cur[2];
			
			for (int i = 0; i < 4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				
				if(nx<0 || nx>n-1 || ny<0 ||ny>n-1 || c_arr[nx][ny]==1)continue;
				
				if(c_arr[nx][ny]==0 && !spread[nx][ny]) {
					spread[nx][ny]=true;
					q.add(new int[] {nx,ny,c+1});
					cnt--;
				
				}else if(c_arr[nx][ny]==2 && !spread[nx][ny]) {
					spread[nx][ny]=true;
					q.add(new int[] {nx,ny,c+1});
				}
			}
			
			
//			print();
			
			
			if(cnt==0) {
				answer = Math.min(answer, c+1);
			}
			
		}
		
		
		
		
	}
	public static void print() {
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(c_arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}
}

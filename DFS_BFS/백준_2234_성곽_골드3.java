package BFS;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_2234_성곽_골드3 {
	static int [] dx = {1,0,-1,0}; //남동북서
	static int [] dy = {0,1,0,-1};
	private static boolean[][] visited;
	private static int[][] arr;
	private static int[][] c_arr;
	private static int m;
	private static int n;
	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		m = sc.nextInt();
		n = sc.nextInt();
		
		arr= new int[n][m];
		c_arr =new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		visited =new boolean[n][m];
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int room=0;
		int max = 0;
		int brick =0;
		int idx=1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visited[i][j]) {
					int num = bfs(i,j,idx);
					max =Math.max(max, num);
					map.put(idx, num);
					idx++;
				}
			}
		} 
		
		room=idx-1;
		
		visited = new boolean[n][m];
//		print();
//		//벽 부수고 가장 큰 방
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int a = c_arr[i][j];
				for (int k = 0; k < 4; k++) {
					int nx = i+dx[k];
					int ny = j+dy[k];
					
					if(nx<0 || nx>n-1 || ny<0 || ny>m-1)continue;
					
					int b = c_arr[nx][ny];
					
					if(a==b)continue;
					
					if(a!=b) {
						brick = Math.max(brick, map.get(a)+map.get(b));
					}
				}
			}
		}
		System.out.println(room);
		System.out.println(max);
		System.out.println(brick);
		
	}
	private static int bfs(int x, int y, int num) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		c_arr[x][y]=num;
		
		int cnt=1;
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int a = cur[0];
			int b = cur[1];
			String dir = Integer.toString(arr[a][b],2);
			String s = "";
			for (int i = 0; i < 4-dir.length(); i++) {
				s+="0";
			}
			dir = s+dir;
//			System.out.println(dir);
//			System.out.println(a+":"+b+":"+arr[a][b]);
//			System.out.println(dir);
			for (int i = 0; i < 4; i++) {
				if(dir.charAt(i)=='0') {
					int nx = a+dx[i];
					int ny = b+dy[i];
					
					if(nx<0 || ny<0 || nx>n-1 || ny>m-1)continue;
					if(!visited[nx][ny]) {
						q.add(new int[] {nx,ny});
						visited[nx][ny]=true;
						c_arr[nx][ny]=num;
						cnt++;
					}
					
				}
			}
		}
		
		return cnt;
		
		
		
		
	}
	
	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(c_arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

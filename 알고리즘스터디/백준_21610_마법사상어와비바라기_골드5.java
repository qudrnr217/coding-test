package 알고리즘스터디;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class 백준_21610_마법사상어와비바라기_골드5 {
	private static int n;
	private static int m;
	private static int[][] arr;
	private static LinkedList<cloud> list;
	private static boolean[][] visited;
//	private static ArrayList<int[]> list2;
	public static class cloud{
		int x,y;
		public cloud(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr =new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		list = new LinkedList<cloud>();
		list.add(new cloud(n-1,0));
		list.add(new cloud(n-1,1));
		list.add(new cloud(n-2,0));
		list.add(new cloud(n-2,1));

		
		
		
		for (int p = 0; p < m; p++) {
			
			visited =new boolean[n][n];
			int d = sc.nextInt()-1;
			int s = sc.nextInt();
			//칸 이동 후 물양 1씩 증가하기 1,2 번을 수행
			move(d,s);
			
			//3,4. 구름제거, 물복사
			copy_water();
			
			//5. 물의 양이2 이상은 구름이 생기고 물의양 2만큼 줄이기
			create_cloud();
		}
		
		System.out.println(sum_water());
		
		
	}
	private static int sum_water() {
		int cnt=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j]>0) {
					cnt+=arr[i][j];
				}
			}
		}
		return cnt;
	}
	private static void create_cloud() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j]>=2 && !visited[i][j]) {
					list.add(new cloud(i,j));
					arr[i][j]-=2;
				}
			}
		}
		visited = new boolean[n][n];
		
	}
	private static void copy_water() {
		while(!list.isEmpty()) {
			cloud cur = list.poll();
			
			int cnt=0;
			visited[cur.x][cur.y]=true;
			for (int i = 1; i <8; i+=2) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				if(nx<0 || ny<0 || nx>n-1 || ny>n-1)continue;
				if(arr[nx][ny]>=1)cnt++;
				
			}
			arr[cur.x][cur.y]+=cnt;
		}
	}
	

	//좌, 좌상, 상, 우상, 우, 우하, 하, 좌하
	static int [] dx = {0,-1,-1,-1,0,1,1,1};
	static int [] dy = {-1,-1,0,1,1,1,0,-1};
	private static void move(int dir, int speed) {
//		System.out.println(dir+":"+speed);
		for(cloud a : list) {
			a.x = (n+a.x+dx[dir]*(speed%n))%n;
			a.y = (n+a.y+dy[dir]*(speed%n))%n;
//			System.out.println(a.x+":"+a.y);
			
			arr[a.x][a.y]++;
		}
		
	}
}

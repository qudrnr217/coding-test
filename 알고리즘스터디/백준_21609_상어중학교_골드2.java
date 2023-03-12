package 알고리즘스터디;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 백준_21609_상어중학교_골드2 {
	private static int n;
	private static int m;
	private static int[][] arr;
	private static int rain_cnt;
	private static boolean[][] visited;
	private static int cnt;
	public static class block{
		int num,x,y,rain,cnt;
		public block(int num, int x, int y, int rain, int cnt) {
			this.num=num;
			this.x=x;
			this.y=y;
			this.rain=rain;
			this.cnt=cnt;
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
		
		PriorityQueue<block>pq = new PriorityQueue<>((o1,o2)->{
			if(o1.cnt==o2.cnt) {
				if(o1.rain==o2.rain) {
					if(o1.x==o2.x) {
						return o2.y-o1.y;
					}
					return o2.x-o1.x;
				}
				
				return o2.rain-o1.rain;
			}
			return o2.cnt-o1.cnt;
		});
		
		int answer=0;
		
		while(true) {
			int circle=0;
			visited=new boolean[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					rain_cnt=0;
					cnt=0;
					if(arr[i][j]>0 && !visited[i][j]) {
						bfs(i,j,arr[i][j]);
						if(cnt>=2) {
							pq.add(new block(arr[i][j],i,j,rain_cnt,cnt));
							circle++;
						}
						
					}
//					System.out.println(cnt);
					
				}
			}
			//순환을 빠져나가는 기능
			if(circle==0)break;
			
			block cur = pq.poll();
			pq.clear();
			answer+=Math.pow(cur.cnt, 2);
			
			//블록제거
			visited =new boolean[n][n];
			delete_block(cur.x, cur.y, cur.num);
//			System.out.println("블록제거");
//			print();
			
			//중력작용
//			System.out.println("중력");
			down();
//			print();
			//반시계 90도 회전
//			System.out.println("90도 반시계회전");
			rotate();
//			print();
			//중력작용
//			System.out.println("중력");
			down();
//			print();
			
//			print();
//			System.out.println();
//			break;
//			System.out.println(answer);
			
		}
		System.out.println(answer);
		
		
		
	}
	private static void rotate() {
		int[][] temp = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				temp[i][j] = arr[j][n-i-1];
			}
		}
		arr = temp;
		
	}
	private static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void down() {
		for (int j = 0; j < n; j++) {
			for (int i = n-1; i >= 1; i--) {
				if(arr[i][j]!=-2)continue;
				int nx = i;
				while(true) {
					nx--;
					if(nx<0)break;
					if(arr[nx][j]==-1)break;
					if(arr[nx][j]!=-2) {
						arr[i][j]=arr[nx][j];
						arr[nx][j]=-2;
						break;
					}
				}
					
				
			}// end of for j
		}// end of for i
		
	}
	private static void delete_block(int x, int y, int num) {
		Queue<int[]> q =new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		arr[x][y]=-2;
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			
			int a = cur[0];
			int b = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				
				if(nx<0 || ny<0 || nx>n-1 || ny>n-1 || visited[nx][ny])continue;
				if(arr[nx][ny]==0 || arr[nx][ny]==num) {
					arr[nx][ny]=-2;
					q.add(new int[] {nx,ny});
					visited[nx][ny]=true;
				}
			}
		}
		
		
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static void bfs(int x, int y, int k) {
		boolean [][] zero_visited =new boolean[n][n];
		Queue<int[]>q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y]=true;
		cnt++;
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int a = cur[0];
			int b = cur[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = a+dx[i];
				int ny = b+dy[i];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1 || visited[nx][ny])continue;
				if(arr[nx][ny]==0 && !zero_visited[nx][ny]) {
					rain_cnt++;
					q.add(new int[] {nx,ny});
					zero_visited[nx][ny]=true;
					cnt++;
				}else if(arr[nx][ny]==k) {
					q.add(new int[] {nx,ny});
					visited[nx][ny]=true;
					cnt++;	
				}
				
			}
			
			
		}
		
	}
}


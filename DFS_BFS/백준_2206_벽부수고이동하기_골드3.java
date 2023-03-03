package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2206_벽부수고이동하기_골드3 {
	private static int n;
	private static int m;
	private static int[][] arr;
	public static class Node{
		int x,y,cnt;
		boolean destroyed;
		
		public Node(int x,int y, int cnt, boolean d) {
			this.x=x;
			this.y=y;
			this.cnt=cnt;
			this.destroyed=d;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr =new int[n][m];
		
		for(int i=0;i<n;i++) {
			char [] c = br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				arr[i][j]=c[j]-'0';
			}
		}
		
		int answer=1000000;
		
		int num=bfs(0,0,n-1,m-1);
		if(num!=-1) {
			answer = Math.min(answer, num);
		}
		
		System.out.println(answer!=1000000? answer:-1);
		
		
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	public static int bfs(int x, int y, int target_x, int target_y) {
		boolean [][][] visited = new boolean[n][m][2];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y,1,false));
		
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.x==target_x && cur.y==target_y) {
				return cur.cnt;
			}
			
			for(int i=0;i<4;i++) {
				int nx = cur.x+dx[i];
				int ny = cur.y+dy[i];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>m-1)continue;
				if(arr[nx][ny]==0) {//벽이 아닐 경우
					if(!cur.destroyed && !visited[nx][ny][0]) {
						q.add(new Node(nx,ny,cur.cnt+1,false));
						visited[nx][ny][0]=true;
					}else if(cur.destroyed && !visited[nx][ny][1]) {
						q.add(new Node(nx,ny,cur.cnt+1,true));
						visited[nx][ny][1]=true;
					}
				}else if(arr[nx][ny]==1) {
					if(!cur.destroyed) {
						q.add(new Node(nx,ny,cur.cnt+1,true));
						visited[nx][ny][1]=true;
					}
				}
			}
		}
		return -1;
	}
}

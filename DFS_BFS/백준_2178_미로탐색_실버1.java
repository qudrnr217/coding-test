package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2178_미로탐색_실버1 {
	private static int N;
	private static int M;
	private static char[][] arr;
	private static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr =new char[N][];
		
		for (int i = 0; i < N; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		visited = new boolean[N][M];
		Node node = new Node(0,0,1);
		bfs(node);
		
	}
	
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	public static void bfs(Node node) {
		Queue<Node>q = new LinkedList<>();
		q.add(node);
		visited[0][0]=true;
		
		while(!q.isEmpty()) {
			
			Node a = q.poll();
//			System.out.println(a.x+":"+a.y);
			if(a.x==N-1 && a.y==M-1) {
				
				System.out.println(a.dist);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = a.x+dx[i];
				int ny = a.y+dy[i];
//				System.out.println(nx+":"+ny);
				if(nx<0 || nx>N-1 || ny<0 || ny>M-1) continue;
				else if(arr[nx][ny]=='1' && !visited[nx][ny]) {
//					System.out.println("hi");
					q.add(new Node(nx,ny,a.dist+1));
					visited[nx][ny]=true;
				}
			}
		}
	}
	static class Node{
		int x,y,dist;

		public Node(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}

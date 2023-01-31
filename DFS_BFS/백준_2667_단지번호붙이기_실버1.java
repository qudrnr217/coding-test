package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 백준_2667_단지번호붙이기_실버1 {
	private static int N;
	private static char[][] arr;
	private static boolean[][] visited;
	private static ArrayList<Integer> result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//좌우, 위아래 - 연결된 집  but 대각선 x
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb =new StringBuffer();
		N = Integer.parseInt(br.readLine());
		
		arr = new char [N][];
		
		for (int i = 0; i < N; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		
		visited = new boolean[N][N];
		result = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j])continue;
				else if(arr[i][j]=='1' && !visited[i][j]) {
					Node node = new Node(i,j,1);
					bfs(node);
				}
			}
		}
		Collections.sort(result);
		sb.append(result.size()).append("\n");
		for(int a : result) {
			sb.append(a).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	public static void bfs(Node node) {
		Queue<Node>q = new LinkedList<>();
		q.add(node);
		visited[node.x][node.y]=true;
		int max= Integer.MIN_VALUE;
		int cnt=1;
		while(!q.isEmpty()) {
			Node a = q.poll();
			
			max=Math.max(max, a.dist);
			
			for (int i = 0; i < 4; i++) {
				int nx = a.x+dx[i];
				int ny = a.y+dy[i];
				
				if(nx<0 || nx>N-1 || ny<0 || ny>N-1)continue;
				else if(arr[nx][ny]=='1' && !visited[nx][ny]) {
					q.add(new Node(nx,ny,a.dist+1));
					visited[nx][ny]=true;
					cnt++;
				}
			}
		}
		
		result.add(cnt);
		
	}
	static class Node{
		int x, y, dist;

		public Node(int x, int y, int dist) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
}

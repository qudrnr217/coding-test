package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1012_유기농배추_실버2 {
	private static boolean[][] visited;
	private static int N;
	private static int M;
	private static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//가로 세로가 반대임.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			arr =new int[M][N];
			for (int i = 0; i < K; i++) {
				st =new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[b][a]=1;
			}
			int cnt=0;
			visited = new boolean[M][N];
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j]==1 && !visited[i][j]) {
						if(bfs(i,j)) {
							cnt++;
						}
					}
				}
			}
			System.out.println(cnt);
			
//			for (int i = 0; i < M; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
		}
	}
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	private static boolean bfs(int i, int j) {
		Queue<int[]> q= new LinkedList<>();
		q.add(new int[] {i,j});
		visited[i][j]=true;
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			for (int k = 0; k < 4; k++) {
				int nx = x+dx[k];
				int ny = y+dy[k];
				
				if(nx<0 || nx>M-1 || ny<0 || ny>N-1) continue;
				
				else if(arr[nx][ny]==1 && !visited[nx][ny]) {
					q.add(new int[] {nx,ny});
					visited[nx][ny]=true;
				}
			
			}
			
			
			
		}
		
		return true;
	}
}

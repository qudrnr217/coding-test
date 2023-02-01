package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_4963_섬의개수_실버2 {
	private static int[][] arr;
	private static boolean[][] visited;
	private static int w;
	private static int h;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		
		while(true) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int cnt =0;
			//탈출 구문
			if(w==0 && h==0)break;
			visited = new boolean[h][w];
			arr = new int[h][w];
			for (int i = 0; i < h; i++) {
				st =new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(arr[i][j]==1 && !visited[i][j]) {
						dfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}
		
		
	}
	static int [] dx = {-1,-1,0,1,1,1,0,-1};
	static int [] dy = {0,1,1,1,0,-1,-1,-1};
	private static void dfs(int x, int y) {
		
		visited[x][y]=true;
		
		for (int i = 0; i < 8; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && nx<h && ny>=0 && ny<w && !visited[nx][ny]) {
				if(arr[nx][ny]==1) {
					dfs(nx,ny);
				}
			}
			
		}
		
		
	}
}

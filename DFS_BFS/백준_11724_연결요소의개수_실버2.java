package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 백준_11724_연결요소의개수_실버2 {
	private static int[] parent;
	private static int[][] graph;
	private static int N;
	private static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //노드의 개수
		int M = Integer.parseInt(st.nextToken()); //간선의 개수
		
		graph = new int[N][N];
		
		
		for (int i = 0; i < M; i++) {
			st =new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			graph[a][b]=1;
			graph[b][a]=1;
			
		}
		visited = new boolean[N];
		int cnt=0;
		for (int i = 0; i < N; i++) {
			if(!visited[i]) {
				dfs(i);
				cnt++;
			}
			
		}
		
		System.out.println(cnt);
	}
	
	
	
	private static void dfs(int idx) {
		if(visited[idx])return;
		for (int j = 0; j < N; j++) {
			visited[idx]=true;
			if(graph[idx][j]==1 && !visited[j]) {
				
				dfs(j);
			}
		}
		
	}



	static class Node {
		int x,y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}

/**
 * MST로했지만 예제 2의 6이 최신화 되지 않고 넘어간다. 따라서 이러한 문제는 MST 또는 DFS로 생각해볼 수 있음.
 */

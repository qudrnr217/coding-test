package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1260_DFS와BFS_실버2 {
	private static int N;
	private static int M;
	private static int V;
	private static int[][] graph;
	private static boolean[] visited;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		//정점 번호가 작은것을 먼저 방문
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //1<=N<=1000 정점 개수
		M = Integer.parseInt(st.nextToken()); //1<=M<10,000 간선 개수
		V = Integer.parseInt(st.nextToken()); //시작하는 노드 번호
		sb = new StringBuilder();
//		ArrayList<ArrayList<Integer>>graph = new ArrayList<>();
//		
//		for (int i = 0; i < N; i++) {
//			graph.add(new ArrayList<>());
//		}
//		
//		for (int i = 0; i < M; i++) {
//			st =new StringTokenizer(br.readLine());
//			int n1 = Integer.parseInt(st.nextToken());
//			int n2 = Integer.parseInt(st.nextToken());
//			
//			graph.get(n1).add(n2);
//			graph.get(n2).add(n1);
//			
//		}
		
		graph = new int[N][N];
		
	
		for (int i = 0; i < M; i++) {
			st =new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			graph[n1-1][n2-1]=1;
			graph[n2-1][n1-1]=1;
			
		}
		
		visited= new boolean[N];
		
		dfs(V-1,1);
		sb.append("\n");
		
		visited = new boolean[N];
		
		bfs(V-1);
		
		System.out.println(sb.toString());
		
		
	}
	public static void dfs(int idx,int cnt) {
		sb.append(idx+1).append(" ");
		visited[idx]=true;
		if(cnt==N) {
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			if(graph[idx][i]==1 && !visited[i]) {
				dfs(i,cnt+1);
			}
		}
	}
	public static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visited[idx]=true;
		sb.append(idx+1).append(" ");
		
		while(!q.isEmpty()) {
			int a =q.poll();
			for (int i = 0; i < N; i++) {
				if(graph[a][i]==1 && !visited[i]) {
					q.add(i);
					visited[i]=true;
					sb.append(i+1).append(" ");
				}
			}
		}
		
		
	}
}
/**
* graph는 인접행렬 인접 리스트를 생각해서 해보자!
*/
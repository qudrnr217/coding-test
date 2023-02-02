package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_24479_알고리즘수업_깊이우선탐색1_실버2 {
	private static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	private static int n;
	private static int[] answer;
	private static int idx;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		
		for (int i = 0; i <=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			st =new StringTokenizer(br.readLin e());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i = 1; i <=n; i++) {
			Collections.sort(graph.get(i));
		}
		
		answer =new int[n+1];
		visited =new boolean[n+1];
		idx=1;
		dfs(r);
		
		for (int i = 1; i <=n; i++) {
			System.out.println(answer[i]);
		}
	}

	private static void dfs(int r) {
		answer[r]=idx++;
		visited[r]=true;
		
		for(int a : graph.get(r)) {
			if(!visited[a]) {
				dfs(a);
			}
		}
		
	}
}

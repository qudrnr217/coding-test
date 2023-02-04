package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_2606_바이러스_실버3 {
	private static int[][] arr;
	private static boolean[] visited;
	private static int N;
	private static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int M = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			arr[a][b]=1;
			arr[b][a]=1;
		}
//		cnt = 0;
		visited = new boolean[N];
		
		System.out.println(bfs(0));
	}

	private static int bfs(int idx) {
		int cnt=0;
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visited[idx]=true;
		
		while(!q.isEmpty()) {
			int cur =q.poll();
			for (int i = 0; i < N; i++) {
				if(arr[cur][i]==1 && !visited[i]) {
					q.add(i);
					cnt++;
					visited[i]=true;
					
				}
			}
		}
		
		
		
		return cnt;
	}
}

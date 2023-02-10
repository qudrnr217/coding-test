package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1939_중량제한_골드3 {
	private static int n;
	private static int m;
	static ArrayList<ArrayList<int[]>> graph;
	private static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}
		
		int left=0;
		int right=0;
		
		
		for (int i = 0; i < m; i++) {
			st =new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new int[] {b,c});
			graph.get(b).add(new int[] {a,c});
			
			right = Math.max(right, c);
		}
		
		st =new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		
		while(left<=right) {
			int mid = (left+right)/2;
			visited =new boolean[n+1];
			if(bfs(a,b,mid)) {
				left=mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(right);
		
	}
	private static boolean bfs(int start, int end, int mid) {
		
		Queue<Integer> q= new LinkedList<>();
		q.add(start);
		visited[start]=true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			if(cur==end) {
				return true;
			}
			
			for(int[] a : graph.get(cur)) {
//				System.out.println(a[0]);
				if(!visited[a[0]] && mid<=a[1]) {
					q.add(a[0]);
					visited[a[0]]=true;
				}
			}
		}
		return false;
		
	}
}

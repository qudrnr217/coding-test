package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_13023_ABCDE_골드5 {
	static ArrayList<ArrayList<Integer>>graph;
	private static int n;
	private static int m;
	private static boolean[] visited;
	private static int answer;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		graph= new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		
		for (int i = 0; i < n; i++) {
			visited =new boolean[n+1];
			
			if(answer==0) {
				dfs(i,0);
			}
		}
		
		
		
		
		System.out.println(0);
		
		
		
		
	}
	private static void dfs(int idx, int depth) {
		visited[idx]=true;
		
		if(depth==4) {
			System.out.println(1);
			System.exit(0);
		}
		
		for(int a : graph.get(idx)) {
			if(!visited[a]) {
				dfs(a,depth+1);
			}
		}
		
		visited[idx]=false;
		
	}
}

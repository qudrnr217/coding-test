package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1697_숨바꼭질_실버1 {
	private static int N;
	private static int K;
	private static int min;
	private static boolean[] visited;

	public static void main(String[] args) {
		//걷는다면 x-1 x+1 , 순간이동 2*x
		Scanner sc =new Scanner(System.in);
		visited = new boolean[100001];
		N = sc.nextInt();
		K = sc.nextInt();
		min = Integer.MAX_VALUE;
		int cnt=0;
		dfs(N,cnt);
		System.out.println(min);
	}

	static int [] dx = {2,1,-1};
	
	private static void dfs(int cur, int cnt) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(cur,cnt));
		visited[cur]=true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
//			System.out.println(now.node);
			if(now.node==K) {
				min= Math.min(min, now.cnt);
				return;
			}
			
			for (int i = 0; i < 3; i++) {
				int a=0;
				if(i==0) {
					a= now.node*2;
				}else if(i==1){
					a=now.node+1;
				}else {
					a = now.node-1;
				}
				
				if(a>=0 && a<visited.length && !visited[a]) {
					q.add(new Node(a,now.cnt+1));
					visited[a]=true;
				}
				
				
				
			}
		}
		
		
		
	}
	static class Node{
		int node, cnt;

		public Node(int node, int cnt) {
			super();
			this.node = node;
			this.cnt = cnt;
		}
		
	}
}

/**
 * visited를 사용했어야함. 다시 방문하지 않도록 다시 방문하게 되면 무한루프가 된다.
 * 
 */

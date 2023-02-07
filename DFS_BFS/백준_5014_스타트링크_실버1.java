package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_5014_스타트링크_실버1 {
	private static int F;
	private static int S;
	private static int G;
	private static int U;
	private static int D;
	private static boolean[] visited;
	static int answer;
	public static class Node{
		int n, cost;
		public Node(int n , int cost) {
			this.n=n;
			this.cost=cost;
		}
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		answer=Integer.MAX_VALUE;
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		visited = new boolean[F+1];
		
		bfs(S,G);
		
		System.out.println(answer==Integer.MAX_VALUE?"use the stairs" : answer);
	}
	private static void bfs(int start, int target) {
		Queue<Node>q =new LinkedList<>();
		q.add(new Node(start,0));
		visited[start]=true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.n==target) {
				answer=cur.cost;
				return;
			}
			
			if(cur.n+U<=F && !visited[cur.n+U]) {
				q.add(new Node(cur.n+U,cur.cost+1));
				visited[cur.n+U]=true;
			}
			if(cur.n-D>0 && !visited[cur.n-D]) {
				q.add(new Node(cur.n-D,cur.cost+1));
				visited[cur.n-D]=true;
			}
		}
		
	}

	
}

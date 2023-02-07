package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_5014_스타트링크_실버1_DFS {
	private static int F;
	private static int S;
	private static int G;
	private static int U;
	private static int D;
	private static boolean[] visited;
	static int answer;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		answer=Integer.MAX_VALUE;
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		visited = new boolean[F+1];
		
		dfs(S,G,0);
		
		System.out.println(answer==Integer.MAX_VALUE?"use the stairs" : answer);
	}

	private static void dfs(int start, int target,int sum) {
		visited[start]=true;
		
		if(start==target) {
			answer = Math.min(answer,sum);
			return;
		}
		
		if(start+U<=F && !visited[start+U]) {
			dfs(start+U,target,sum+1);
		}
		if(start-D>0 && !visited[start-D]) {
			dfs(start-D,target,sum+1);
		}
		
	}
	

	
}

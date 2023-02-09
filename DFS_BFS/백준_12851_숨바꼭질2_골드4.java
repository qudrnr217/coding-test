package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_12851_숨바꼭질2_골드4 {
	private static int answer;
	private static int check;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		answer = Integer.MAX_VALUE;
		check=1;
		
		if(n>m) {
			System.out.println(n-m);
			System.out.println(1);
		}
		else {
			bfs(n,m);
			System.out.println(answer);
			System.out.println(check);
		}
		
	}

	private static void bfs(int n, int m) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n,0});
		boolean []visited = new boolean[100001];
		visited[n]=true;
		
		while(!q.isEmpty()) {
			int []cur = q.poll();
			int node =cur[0];
			int cnt = cur[1];
			visited[node]=true;
			if(node == m) {
				
//				answer=Math.min(answer, cnt);
//				if(cnt == answer) {
//					check++;
//				}
//				visited[m]=false;
				if(answer>cnt)answer=cnt;
				else if(answer==cnt)check++;
//				visited[node]=false;
				continue;
			}
			
			if(node*2<100001 && !visited[node*2]) {
//				visited[node*2]=true;
				q.add(new int[] {node*2,cnt+1});
			}
			if(node-1>0 && !visited[node-1]) {
//				visited[node-1]=true;
				q.add(new int[] {node-1,cnt+1});
			}
			if(node+1<100001 && !visited[node+1]) {
//				visited[node+1]=true;
				q.add(new int[] {node+1,cnt+1});
			}
			
		}
		
	}
}

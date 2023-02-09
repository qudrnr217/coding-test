package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_18352_특정거리의도시찾기_실버2 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int x = sc.nextInt();
		
		ArrayList<ArrayList<Integer>>graph =new ArrayList<>();
		
		for (int i = 0; i < n+1; i++) {
			graph.add(new ArrayList<>());
		}
		
	
		for (int i = 0; i < m; i++) {
			int a= sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
		}
		
		int [] dist = new int[n+1];
		Arrays.fill(dist,Integer.MAX_VALUE);
		
		boolean [] visited = new boolean[n+1];
		
		Queue<Integer>q =new LinkedList<>();
		q.add(x);
		visited[x]=true;
		dist[x]=0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int a : graph.get(cur)) {
//				System.out.println(a);
				if(!visited[a]) {
					if(dist[a]>dist[cur]+1) {
						dist[a] = dist[cur]+1;
						visited[cur]=true;
						q.add(a);
					}
					
				}
			}
		}
		boolean flag=false;
		for (int i = 1; i < n+1; i++) {
			if(dist[i]==k) {
				System.out.println(i);
				flag=true;
			}
		}
		if(!flag)System.out.println(-1);
		
	}
}

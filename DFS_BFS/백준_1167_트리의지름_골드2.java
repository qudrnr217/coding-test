package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1167_트리의지름_골드2 {
	static ArrayList<ArrayList<Node>> graph;
	public static class Node{
		int n,dist;
		public Node(int n ,int dist) {
			this.n=n;
			this.dist=dist;
		}
	}
	private static int v;
	private static int[] dist;
	private static int max;
	private static int result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		v =Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		
		
		for(int i=0;i<=v;i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < v; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			while(true) {
				int a = Integer.parseInt(st.nextToken());
				if(a==-1)break;
				int b = Integer.parseInt(st.nextToken());
				graph.get(num).add(new Node(a,b));
//				graph.get(a).add(new Node(num,b));
				
			}

		}
		
		int max = 0;
		
		dist = new int[v+1];
		bfs(1);
		
		HashMap<Integer,Integer> map =new HashMap<>();
		
		for(int i=1;i<=v;i++) {
			map.put(i, dist[i]);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int a : map.keySet()){
			list.add(a);
		}
		
		Collections.sort(list,(o1,o2)->map.get(o2)-map.get(o1));
		 
		dist = new int[v+1];
		bfs(list.get(0));
		
		Arrays.sort(dist);
		System.out.println(dist[dist.length-1]);
		
		
		
//		System.out.println(max);
	}
	private static void bfs(int idx) {
		boolean [] visited =new boolean[v+1];
		Queue<Node> q =new LinkedList<>();
		q.add(new Node(idx,0));
		visited[idx]=true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(Node a : graph.get(cur.n)) {
				if(!visited[a.n]) {
					if(dist[a.n]<dist[cur.n]+a.dist) {
						dist[a.n]=dist[cur.n]+a.dist;
						q.add(new Node(a.n,a.dist));
						visited[a.n]=true;
					}
					
				}
			}
		}
	}
	
}

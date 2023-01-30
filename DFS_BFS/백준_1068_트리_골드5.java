package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1068_트리_골드5 {
	private static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	private static int answer;
	static ArrayList<Integer> child;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		
		graph = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		
		int root=0;
		for (int i = 0; i < n; i++) {
			int num=sc.nextInt();
			if(num==-1) {
				root=i;
				continue;
			}
			graph.get(i).add(num);
			graph.get(num).add(i);
		}
		
		
		int target = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			for(int a : graph.get(i)) {
				if(a==target){
//					System.out.println(cur+":"+a);
					graph.get(i).remove(Integer.valueOf(a));
					graph.get(a).remove(Integer.valueOf(i));
					break;
				}
			}
		}
		
		
		answer=0;
		visited=new boolean[n];
		
		bfs(root,target);
		System.out.println(target==root?0:answer);
	}

	private static void bfs(int idx, int target) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visited[idx]=true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
//			System.out.println(cur);
//			System.out.println(graph.get(cur));
			
			if(graph.get(cur).size()==0) {
				answer++;
			}

			
			for(int a : graph.get(cur)) {
				if(!visited[a]) {
					visited[a]=true;
					q.add(a);
					graph.get(a).remove(Integer.valueOf(cur));
				}
			}
			
			
		}
		
	}
}

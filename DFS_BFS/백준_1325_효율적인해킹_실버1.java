package BFS;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1325_효율적인해킹_실버1 {
	private static int n;
	private static int m;
	static int [] memo;
	static ArrayList<ArrayList<Integer>> graph;
	private static boolean[] visited;
	private static int count;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st =new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph =new ArrayList<>();
		
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<m;i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph.get(b).add(a);
		}
		
		memo = new int[n+1];
		
		int [] list =new int[n+1];
		int max =0;
		for(int i=1;i<=n;i++) {
			visited =new boolean[n+1];
			count=0;
			bfs(i);
			max = Math.max(max, count);
			list[i]=count;
		}
		
		for (int i = 1; i < n+1; i++) {
			if(list[i]==max) {
				System.out.print(i+" ");
			}
		}
		
		
		
		
		
	}
	private static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visited[idx]=true;
		
		while(!q.isEmpty()) {
			int cur =q.poll();
			for(int a : graph.get(cur)) {
				if(!visited[a]) {
					q.add(a);
					visited[a]=true;
					count++;
				}
			}
		}
		
		
	}

	
}

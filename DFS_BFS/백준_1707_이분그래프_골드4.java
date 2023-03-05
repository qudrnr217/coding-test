package BFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_1707_이분그래프_골드4 {
	private static int v;
	private static int e;
	static ArrayList<ArrayList<Integer>>list;
	private static int[] mark;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int k =Integer.parseInt(br.readLine());
		
		for(int testCase=0;testCase<k;testCase++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			mark = new int[v+1];
			list = new ArrayList<>();
			
			for(int i=0;i<=v;i++) {
				list.add(new ArrayList<>());
			}
			
			
			
			for(int i=0;i<e;i++) {
				st =new StringTokenizer(br.readLine());
				int a =Integer.parseInt(st.nextToken());
				int b =Integer.parseInt(st.nextToken());
				list.get(a).add(b);
				list.get(b).add(a);
			}
			
			boolean flag =true;
			for(int i=1;i<=v;i++) {
				System.out.println(Arrays.toString(mark));
				if(mark[i]==0 && !bfs(i)) {
					flag=false;
					break;
				}
			}
			
			System.out.println(flag ? "YES" : "NO");
		}
		
	}

	private static boolean bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		mark[start]=1;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int a : list.get(node)) {
				if(mark[a]==0) {
					mark[a]=mark[node]==1? 2:1;
					q.add(a);
				}else {
					if(mark[a]==mark[node]) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

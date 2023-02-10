package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_16928_뱀과사다리게임_골드5 {
	private static int n;
	private static int m;
	private static int[][] sa;
	private static int[][] sn;
	private static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		sa = new int[n][2];
		sn = new int[m][2];
		for(int i=0;i<n;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			sa[i][0]=a;
			sa[i][1]=b;
		}
		
		for (int j = 0; j < m; j++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			sn[j][0]=a;
			sn[j][1]=b;
		}
		visited =new boolean[101];
		bfs(1);
		
		
	}

	private static void bfs(int num) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {num,0});
		visited[num]=true;
		while(!q.isEmpty()) {
			int []cur = q.poll();
			
			if(cur[0]==100) {
				System.out.println(cur[1]);
				return;
			}
			
			
			int a = cur[0]+1;
			int b = cur[0]+2;
			int c = cur[0]+3;
			int d = cur[0]+4;
			int e = cur[0]+5;
			int f = cur[0]+6;
			
			
			if(a<=100 && !visited[a]) {
				visited[a]=true;
				a = check(a);
				q.add(new int[] {a,cur[1]+1});
				
			}
			if(b<=100 && !visited[b]) {
				visited[b]=true;
				b = check(b);
				q.add(new int[] {b,cur[1]+1});
				
			}
			if(c<=100 && !visited[c]) {
				visited[c]=true;
				c = check(c);
				q.add(new int[] {c,cur[1]+1});
				
			}
			if(d<=100 && !visited[d]) {
				visited[d]=true;
				d = check(d);
				q.add(new int[] {d,cur[1]+1});
				
			}
			if(e<=100 && !visited[e]) {
				visited[e]=true;
				e = check(e);
				q.add(new int[] {e,cur[1]+1});
				
			}
			if(f<=100 && !visited[f]) {
				visited[f]=true;
				f = check(f);
				q.add(new int[] {f,cur[1]+1});
				
			}
		}
		
	}
	
	public static int check(int num) {
		for (int i = 0; i < n; i++) {
			if(sa[i][0]==num) {
				num=sa[i][1];
				break;
			}
		}
		for (int i = 0; i < sn.length; i++) {
			if(sn[i][0]==num) {
				num=sn[i][1];
				break;
			}
		}
		
		return num;
	}
}

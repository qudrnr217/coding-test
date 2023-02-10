package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1963_소수경로_골드4 {
	private static boolean[] visited;
	private static boolean[] prime;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		prime = new boolean[10000];
		
		prime[0]=true;
		prime[1]=true;
		for (int i = 2; i < 10000; i++) {
			for (int j = i+i; j < 10000; j+=i) {
				prime[j]=true;
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
//			System.out.println(a+":"+b);
			visited =new boolean[10000];
			bfs(a,b);
			
		}
	}

	private static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {a,0});
		visited[a]=true;
		
		while(!q.isEmpty()) {
			int []num = q.poll();
			
			if(num[0]==b) {
				System.out.println(num[1]);
				return;
				
			}
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j <= 9; j++) {
					if(i==0 && j==0)continue;
					int k = change(num[0],i,j);
					if(!prime[k] && !visited[k]) {
						q.add(new int[] {k,num[1]+1});
						visited[k]=true;
					}
				}
			}
		}
		
	}

	private static int change(int num, int i, int j) {
		String s = Integer.toString(num);
		char [] c = s.toCharArray();
		
		c[i]=(char)(j+'0');
		String str ="";
		for (int k = 0; k < c.length; k++) {
			str+=c[k];
		}
		
		return Integer.parseInt(str);
		
		
		
		
		
		
		
	}
}

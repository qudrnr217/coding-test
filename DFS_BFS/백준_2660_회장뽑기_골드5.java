package BFS;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_2660_회장뽑기_골드5 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int INF = 987654321;
		
		int [][] graph = new int[n+1][n+1];
		
		for (int i = 0; i < n+1; i++) {
			Arrays.fill(graph[i], INF);
		}
		
		
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a==-1 && b==-1)break;
			
			graph[a][b]=1;
			graph[b][a]=1;	
		}
		
		for(int k=1;k<=n;k++) {
			for (int i = 1; i <=n; i++) {
				for (int j = 1; j <=n; j++) {
					if(graph[i][j]>graph[i][k]+graph[k][j]) {
						graph[i][j]=graph[i][k]+graph[k][j];
					}
				}
			}
		}
		int [] total = new int[n+1];
		
		
		
		
		int min = INF;
		for (int i = 1; i <=n; i++) {
			int cnt=0;
			for (int j = 1; j <=n; j++) {
				if(i==j)continue;
				else {
					cnt = Math.max(cnt, graph[i][j]);
				}
			}
			
			total[i]=cnt;
			min = Math.min(min, cnt);
		}
		
		StringBuilder sb =new StringBuilder();
		StringBuilder number = new StringBuilder();
		sb.append(min).append(" ");
		
		
		int cnt=0;
		for (int i = 1; i <=n; i++) {
			if(total[i]==0)continue;
			
			if(total[i]==min) {
				cnt++;
				number.append(i).append(" ");
				
			}
			
		}
		sb.append(cnt);
		
		System.out.println(sb.toString());
		System.out.println(number.toString());
		
		
	}
}

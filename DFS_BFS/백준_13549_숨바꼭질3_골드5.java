package BFS;

import java.util.Scanner;

public class 백준_13549_숨바꼭질3_골드5 {
	static int min;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		min = 100000;
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		dfs(a,b,0);
		System.out.println(min);
	}

	private static void dfs(int a,int b, int cnt) {

		
		if(a<=0)return;
		if(a>=b) {
			min = Math.min(min, cnt+a-b);
//			System.out.println(min);
			return;
		}
		if(cnt>min)return;
		
		
		dfs(a*2,b,cnt);
		dfs(a-1,b,cnt+1);
		dfs(a+1,b, cnt+1);
	
		
	}
}

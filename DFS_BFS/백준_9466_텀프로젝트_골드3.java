package DFS;

import java.util.Scanner;

public class 백준_9466_텀프로젝트_골드3 {
	private static int[] arr;
	private static boolean[] visited;
	private static boolean[] isDone;
	private static int answer;
	public static void main(String[] args) {
		//혼자하는 학생은 자기 자신 선택가능
			Scanner sc =new Scanner(System.in);
			
			int t = sc.nextInt();
			for (int testCase = 0; testCase < t; testCase++) {
				int n = sc.nextInt();
				arr =new int[n+1];
				visited =new boolean[n+1];
				isDone =new boolean[n+1];
				answer =0;
				for(int i=1;i<=n;i++) {
					arr[i]=sc.nextInt();
				}
				
				for(int i=1;i<=n;i++) {
					if(!isDone[i])dfs(i);
				}
				System.out.println(n-answer);
			}	
	}
	private static void dfs(int idx) {
		visited[idx]=true;
		int next = arr[idx];
		
		if(!visited[next])dfs(next);
		else {
			
			if(!isDone[next]) {
				answer++;
				isDone[next]=true;
//				System.out.println(next);
				while(next!=idx) {
					answer++;
					next=arr[next];
					isDone[next]=true;
				}
			}
		}
		isDone[idx]=true;
		
	}
}

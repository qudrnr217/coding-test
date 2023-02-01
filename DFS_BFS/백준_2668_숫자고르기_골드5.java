package DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 백준_2668_숫자고르기_골드5 {
	private static int[] arr;
	private static int n;
	private static boolean[] visited;
	private static int max;
	private static ArrayList<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i]=sc.nextInt();
		}
		
		list =new ArrayList<>();
		visited =new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			visited[i]=true;
			dfs(i,i);
			visited[i]=false;
		}
		System.out.println(list.size());
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void dfs(int start, int target) {
		if(!visited[arr[start]]) {
			visited[arr[start]]=true;
			dfs(arr[start],target);
			visited[arr[start]]=false;
		}
		
		if(arr[start]==target) {
			list.add(target);
		}
		
		
		
	}
}

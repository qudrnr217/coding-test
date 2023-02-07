package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_9019_DSLR_골드4 {
	public static class Node{
		int n;
		String sum;
		public Node(int n, String sum) {
			this.n=n;
			this.sum=sum;
		}
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int testCase = 0; testCase < t; testCase++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
//			System.out.println(a+":"+b);
			
			boolean [] visited =new boolean[10001];
			Queue<Node> q =new LinkedList<>();
			q.add(new Node(a,""));
			visited[a]=true;
			
			while(!q.isEmpty()) {
				Node cur = q.poll();		
				if(cur.n==b) {
					System.out.println(cur.sum);
					break;
				}
				
				
				int D = (cur.n*2)%10000;
				int S = (cur.n==0)?9999:cur.n-1;
				int L = (cur.n%1000)*10+cur.n/1000;
				int R = (cur.n%10)*1000+cur.n/10;
//				System.out.println(D+":"+S+":"+L+":"+R);
				if(!visited[D]) {
					q.add(new Node(D,cur.sum+"D"));
					visited[D]=true;
				}
				if(!visited[S]) {
					q.add(new Node(S,cur.sum+"S"));
					visited[S]=true;
				}
				if(!visited[L]) {
					q.add(new Node(L,cur.sum+"L"));
					visited[L]=true;
				}
				if(!visited[R]) {
					q.add(new Node(R,cur.sum+"R"));
					visited[R]=true;
				}
//				break;
			}
			
		}
	}

	
}

package BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_13549_숨바꼭질3_골드6_BFS {
	public static class Node{
		int idx, cnt;
		public Node(int idx, int cnt) {
			this.idx= idx;
			this.cnt=cnt;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int [] visited = new int[100001];
		
		Arrays.fill(visited, 100000);
		
		Queue<Node>q = new LinkedList<>();
		
		q.add(new Node(a,0));
		visited[a]=0;
		
		
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			//앞으로 *2
			if(cur.idx*2>=0 && cur.idx*2<=100000) {
				if(visited[cur.idx*2] > cur.cnt) {
					visited[cur.idx*2]=cur.cnt;
					q.add(new Node(cur.idx*2, cur.cnt));
				}
			}
			//뒤로 -1
			if(cur.idx-1>=0 && cur.idx-1<=100000) {
				if(visited[cur.idx-1]>cur.cnt+1) {
					visited[cur.idx-1]=cur.cnt+1;
					q.add(new Node(cur.idx-1,cur.cnt+1));
				}
			}
			
			//앞으로 +1
			if(cur.idx+1>=0 && cur.idx+1<=100000) {
				if(visited[cur.idx+1]>cur.cnt+1) {
					visited[cur.idx+1]=cur.cnt+1;
					q.add(new Node(cur.idx+1,cur.cnt+1));
				}
			}
		}// end of while
		
		System.out.println(visited[b]);
	}
}

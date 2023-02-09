package BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 백준_13913_숨바꼭질4_골드4 {
	static int answer=0;
	static boolean [] visited =new boolean[100001];
	static int [] parent = new int[100001];
	private static int n;
	private static int k;
	static class Node{
		int n,time;
		public Node(int n, int time) {
			this.n=n;
			this.time=time;
		}
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		StringBuilder sb =new StringBuilder();
		if(n==k) {
			sb.append(0).append("\n");
			sb.append(n).append("\n");
		}else {
			bfs(n);
			sb.append(answer).append("\n");
			Stack<Integer> stack = new Stack<>();
            stack.add(k);
            int index = k;
            while (index != n) {
                stack.push(parent[index]);
                index = parent[index];
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
        }
        System.out.println(sb);
		
		
	}

	private static void bfs(int start) {
//		time = 0;
		Queue<Node> q =new LinkedList<>();
		q.add(new Node(start,0));
		visited[start]=true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int n = cur.n;
			int time =cur.time;
			
			if(n==k) {
				answer=Math.min(answer, time);
//				return;
			}
			
			if(n*2<=100000 && !visited[n*2]) {
				visited[n*2]=true;
				parent[n*2]=n;
				q.add(new Node(n*2,time+1));
			}
			
			if(n-1>=0 && !visited[n-1]) {
				visited[n-1]=true;
				parent[n-1]=n;
				q.add(new Node(n-1,time+1));
			}
			
			if(n+1<=100000 && !visited[n+1]) {
				visited[n+1]=true;
				parent[n+1]=n;
				q.add(new Node(n+1,time+1));
			}
		}
		
	}
}

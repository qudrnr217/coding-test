package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_2250_트리의높이와너비_골드2 {
	public static class Node{
		int num;
		int parent;
		int left;
		int right;
		
		public Node(int num, int left, int right) {
			this.num = num;
			this.left = left;
			this.right=right;
			this.parent=-1;
		}
	}
	private static Node[] tree;
	private static int[] max;
	private static int[] min;
	static int nodeIdx=1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		tree = new Node[n+1];
		
		int root = 0;
		min = new int[n+1];
		max = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			tree[i]=new Node(i,-1,-1);
			min[i]=n;
			max[i]=0;
		}
		
		for (int i = 1; i <=n; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int num= Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());
			
			tree[num].left = left;
			tree[num].right = right;
			
			if(left!=-1)tree[left].parent=num;
			if(right!=-1)tree[right].parent=num;
		}
		
		for (int i = 1; i <=n; i++) {
			if(tree[i].parent==-1) {
				root=i;
				break;
			}
		}
		
		//root부터 중위순회
		inorder(root,1);
		int level=1;
		int width=0;
		
		for (int i = 0; i <=n; i++) {
			int tmp = max[i]-min[i];
//			System.out.println(max[i]+":"+min[i]);
			if(width<tmp) {
				level = i;
				width= tmp;
			}
		}
		System.out.println(level+" "+(width+1));
		
		
	}
	private static void inorder(int root, int level) {
		Node cur = tree[root];
		
		if(cur.left!=-1) {
			inorder(cur.left,level+1);
		}
		
		min[level] = Math.min(min[level], nodeIdx);
		max[level] = Math.max(max[level], nodeIdx);
//		System.out.println(max[level]);
		nodeIdx++;
		
		if(cur.right!=-1) {
			inorder(cur.right,level+1);
		}
	}
}

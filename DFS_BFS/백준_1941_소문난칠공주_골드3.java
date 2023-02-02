package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_1941_소문난칠공주_골드3 {
	private static char[][] arr;
	private static boolean[] visited;
	private static int answer;
	private static int[] out;
	private static ArrayList<int[]> list;

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		
		arr =new char[5][5];
		
		for (int i = 0; i < 5; i++) {
			String s =sc.nextLine();
			for (int j = 0; j < 5; j++) {
				arr[i][j]=s.charAt(j);
			}
		}
		
		list = new ArrayList<int[]>();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				list.add(new int[] {i,j});
			}
		}
		
		answer =0;
		out = new int[7];
		visited =new boolean[25];
		combinations(0,0);
		
		System.out.println(answer);
	}

	private static void combinations(int start, int depth) {
		
		if(depth==7) {
			bfs();
//			System.exit(0);
			return;
		}
		
		for(int i=start;i<25;i++) {
			visited[i]=true;
			out[depth]=i;
			combinations(i+1,depth+1);
			visited[i]=false;
			
		}
	}

	private static void bfs() {
		boolean [][] v= new boolean[5][5];
		boolean [][] r= new boolean[5][5];
		int s_cnt=0;
		
		for(int i:out) {
			int [] a = list.get(i);
			v[a[0]][a[1]]=true;
			if(arr[a[0]][a[1]]=='S')s_cnt++;
		}
//		System.out.println(s_cnt);
		
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 5; j++) {
//				System.out.print(v[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		
		if(s_cnt>=4) {
			int [] abc = list.get(out[0]);
			Queue<int[]> q= new LinkedList<>();
			q.add(new int[] {abc[0],abc[1]});
			int cnt=1;
			r[abc[0]][abc[1]]=true;
			while(!q.isEmpty()) {
				int [] cur = q.poll();
				int a = cur[0];
				int b = cur[1];
				for (int i = 0; i < 4; i++) {
					int nx = a+dx[i];
					int ny = b+dy[i];
					
					if(nx<0||ny<0||nx>4||ny>4)continue;
					if(v[nx][ny] && !r[nx][ny]) {
						q.add(new int[] {nx,ny});
						r[nx][ny]=true;
						cnt++;
					}
				}
				
			}//end of while
//			System.out.println(cnt);
			if(cnt==7) {
				answer++;
			}
		}
		
		
		
	}

	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
}

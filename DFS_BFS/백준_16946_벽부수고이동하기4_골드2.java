package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class 백준_16946_벽부수고이동하기4_골드2 {
	private static char[][] arr;
	private static int m;
	private static int n;
	private static boolean[][] visited;
	private static int[][] memo;
	private static HashMap<Integer, Integer> map;
	private static int[][] group;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); 
			
			
		StringTokenizer st =new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr =new char[n][m];
		
		
		for (int i = 0; i < n; i++) {
			arr[i]=br.readLine().toCharArray();
		}
		group= new int[n][m];
		map = new HashMap<Integer,Integer>();
		int idx=1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(group[i][j]==0 && arr[i][j]=='0') {
					map.put(idx, bfs(i,j,idx));
					idx++;
				}
			}
		}
		StringBuilder sb =new StringBuilder();
		
		for(int i=0;i<n;i++) {
			for (int j = 0; j < m; j++) {
				if(group[i][j]==0) {
					sb.append(count(i,j));
					continue;
				}
				sb.append(0+"");
			}
			sb.append("\n");
			
		}
		System.out.println(sb.toString());
		
		
	}
	
	static int count(int x,int y) {
		int cnt=1;
		if(arr[x][y]=='0') return 0;
		Set<Integer> set = new HashSet<>();
		
		//벽에 맞닿은 4방향만 구하면됨
		//그 방향의 그룹의 0의 갯수 정보는 이미 구했기 때문
		for(int i=0;i<4;i++) {
			int[] dx = {0,1,0,-1};
			int[] dy = {1,0,-1,0};
			
			int sx = x+dx[i];
			int sy = y+dy[i];
			
			if(sx < 0 || sy < 0 || sx>=n || sy >= m || group[sx][sy]==0)
				continue;
			//맞닿은 그룹이 중복일 경우를 위해 set에 저장함
			set.add(group[sx][sy]);
			
		}
		for(int size : set) {
			cnt+=map.get(size);
		}
		
		return cnt%10;
	}

	static int bfs(int x,int y,int groupCnt) {
		int cnt=1;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		group[x][y]=groupCnt;
		while(!q.isEmpty()) {
			int [] cur = q.poll(); 
			int a = cur[0];
			int b = cur[1];
			for(int i=0;i<4;i++) {
				int sx = a+dx[i];
				int sy = b+dy[i];
				
				if(sx < 0 || sy <0 || sx >= n || sy >= m)
					continue;
				//아직 그룹에 속하지 않았고 && 벽이 아니라면 카운트해준다.
				if(group[sx][sy]==0 && arr[sx][sy]=='0') {
					group[sx][sy]=groupCnt;
					cnt++;
					q.add(new int[] {sx,sy});
				}
			}
		}
		return cnt;
	
	}

	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
}

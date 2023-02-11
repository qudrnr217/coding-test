package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_6593_상범빌딩_골드5 {
	private static char[][][] arr;
	private static boolean[][][] visited;
	private static int endZ;
	private static int endX;
	private static int endY;
	private static int l;
	private static int r;
	private static int c;

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		
		
		while(true) {
			
			String abc = br.readLine();
			if(abc.equals(""))abc=br.readLine();
			
			StringTokenizer st =new StringTokenizer(abc);
			
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
//			System.out.println(l+":"+r+":"+c);
			
			if(l==0 || r==0 || c==0)break;
			
			arr =new char[l][r][c];
			visited =new boolean[l][r][c];
			
			int startZ=0;
			int startX=0;
			int startY=0;
			
			
			for(int i=0;i<l;i++) {
				for (int j = 0; j < r; j++) {
					String s = br.readLine();
					if(s.equals(""))s=br.readLine();
//					System.out.println(s);
					for (int k = 0; k < c; k++) {
						arr[i][j][k]=s.charAt(k);
						
						if(arr[i][j][k]=='S') {
							startZ=i;
							startX=j;
							startY=k;
						}else if(arr[i][j][k]=='E') {
							endZ=i;
							endX=j;
							endY=k;
						}
					}
				}
			}
			
			bfs(startZ,startX,startY);
			
			
			
		}
		
		
	}
	
	//북,남,서,동,상,하
	static int [] dx = {-1,1,0,0,0,0};
	static int [] dy = {0,0,-1,1,0,0};
	static int [] dz = {0,0,0,0,-1,1};

	private static void bfs(int startZ, int startX, int startY) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {startZ,startX,startY,0});
		visited[startZ][startX][startY]=true;
		
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int z = cur[0];
			int x = cur[1];
			int y = cur[2];
			int cnt =cur[3];
			
			if(z==endZ && x==endX && y==endY) {
				System.out.println("Escaped in "+cnt+" minute(s).");
				return;
			}
			
			
			for (int i = 0; i < 6; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				int nz = z+dz[i];
				
				if(nx<0 || ny<0 || nz<0 || nz>l-1 || nx>r-1 || ny>c-1)continue;
//				System.out.println(nz+":"+nx+":"+ny);
				if(arr[nz][nx][ny]!='#' && !visited[nz][nx][ny]) {
					visited[nz][nx][ny]=true;
					q.add(new int[] {nz,nx,ny,cnt+1});
				}
				
			}
			
		}
		
		System.out.println("Trapped!");
		
	}
}

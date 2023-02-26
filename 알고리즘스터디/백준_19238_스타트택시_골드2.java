package 알고리즘스터디;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_19238_스타트택시_골드2 {
	private static int n;
	private static int m;
	private static int k;
	private static int[][] arr;
	private static int answer;
	private static boolean[][] visited;
	private static int[][] d_arr;
	static HashMap<Integer, int[]> map;
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
		arr = new int[n][n];
		d_arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==1) {
					arr[i][j]=-1; //벽은 -500
					d_arr[i][j]=-1;
				}
				
			}
		}
		
		int start_x = sc.nextInt()-1;
		int start_y = sc.nextInt()-1;
		
		int [][] dest =new int[m+1][2];
		map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			int a=sc.nextInt()-1;
			int b=sc.nextInt()-1;
			int c=sc.nextInt()-1;
			int d=sc.nextInt()-1;
			
			arr[a][b]=i+1;
			dest[i+1][0]=c;
			dest[i+1][1]=d;
			map.put(i+1,dest[i+1]);
		}
		
	
		
		
		
		answer = 0;
		visited =new boolean[n][n];
		
		//승객의 최단 거리 구하기
		bfs(start_x,start_y);
		
		System.out.println(answer);
		
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static void bfs(int start_x, int start_y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start_x,start_y,0,k});
		visited[start_x][start_y]=true;
		int count=0;
		int num=0;
		boolean []iswall = new boolean[m+1];
		while(true) {
//			print();
			ArrayList<int[]>list = new ArrayList<>();
			
//			iswall =false;
			while(!q.isEmpty()) {
				
				int [] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int cnt = cur[2];
				int eng = cur[3];
			
//				System.out.println(x+":"+y+":"+cnt);
//				System.out.println(arr[x][y]);
				if(arr[x][y]>0 && cnt==0) {
					list.add(new int[] {x,y,cnt,eng});
					iswall[arr[x][y]]=true;
//					break;
				}
				
				for (int i = 0; i < 4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(nx<0 || nx>n-1 || ny<0 || ny>n-1 || arr[nx][ny]==-1 || visited[nx][ny])continue;
					
					if(arr[nx][ny]>=0) {
						q.add(new int[] {nx,ny,cnt+1,eng-1});
						visited[nx][ny]=true;
						if(arr[nx][ny]>0) {
//							System.out.println("number: "+arr[nx][ny]);
							list.add(new int[] {nx,ny,cnt+1,eng-1});
							iswall[arr[nx][ny]]=true;
							
						}
						
					}
				}
				
				
			}// end of q while
//			System.out.println(num);
//			System.out.println(iswall);
			for (int i = 1; i <= m; i++) {
				if(!iswall[i]) {
					answer=-1;
					return;
				}
			}			
			
			
			q.clear();
			
			if(list.size()==0) { //더이상 갈 곳이 없는 경우
				answer=count;
//				if(answer==0)answer=-1;
				return;
			}else { //갈 곳이 있는 경우
				
				int [] now = list.get(0);
				
				for(int i=1;i<list.size();i++) {
					if(now[2]>list.get(i)[2]) { //list가 now보다 작을 경우
						now = list.get(i);
					}else if(now[2]==list.get(i)[2]) { //list와 now의 거리가 같은 경우
						if(now[0]>list.get(i)[0]) { //x가 작은 것을 우선
							now = list.get(i);
						}else if(now[0]==list.get(i)[0]) { //x가 같고 y가 다른경우
							if(now[1]>list.get(i)[1]) {
								now= list.get(i);
							}
						}
					}
				}//end of for
				visited = new boolean[n][n];
				q.add(new int[] {now[0],now[1],0,now[3]});
				num = arr[now[0]][now[1]];
				arr[now[0]][now[1]]=0;
				
				visited[now[0]][now[1]]=true;
			}
			
			
			int a=0;
			int b=0;

			boolean flag=false;
			
			int [] dst = map.get(num);
			d_arr[dst[0]][dst[1]]=num;
//			print();
			
//			System.out.println(num);
			
			while(!q.isEmpty()) {
				int [] cur = q.poll();
				int x = cur[0];
				int y = cur[1];
				int cnt = cur[2];
				int eng = cur[3];
//				System.out.println(x+":"+y+":"+cnt+":"+eng);

				if(d_arr[x][y]==num) {
					
//					System.out.println("hi");
//					System.out.println(num+":"+x+":"+y);
					flag=true;
//					System.out.println(eng+":"+cnt);
					if(eng<0) {
						answer=-1;
						return;
					}
					
					count=(eng)+((cnt)*2);
//					System.out.println(count);
					d_arr[x][y]=0;
//					visited[x][y]=true;
					a=x;
					b=y;
					break;

				}
				
				

				for (int i = 0; i < 4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(nx<0 || nx>n-1 || ny<0 || ny>n-1 || visited[nx][ny] || d_arr[nx][ny]==-1)continue;
					if(d_arr[nx][ny]>=0) {
						q.add(new int[] {nx,ny,cnt+1,eng-1});
						visited[nx][ny]=true;
						
					}

				}// end of for
			} // end of q while
			

			if(!flag) {
//				System.out.println("hi");
				answer=-1;
				return;
			}
			q.clear();
//			System.out.println("count:" +count);
			q.add(new int[] {a,b,0,count});
//			System.out.println(a+":"+b+":"+count);
			
			visited = new boolean[n][n];
			visited[a][b]=true;
		}// end of while
		
		
		
		
		
		
	}
	
	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%3d ",arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("-------------");
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%3d ",d_arr[i][j]);
			}
			System.out.println();
		}
		System.out.println("***************");
	}
}

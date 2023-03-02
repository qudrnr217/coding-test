package 알고리즘스터디;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 백준_21608_상어초등학교_골드5 {
	private static int[][] arr;
	private static int n;

	public static class Node{
		int num,x,y;
		public Node(int num,int x, int y) {
			this.num=num;
			this.x=x;
			this.y=y;
		}
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	private static int[][] zero_arr;
	static HashMap<Integer, int[]> map;
	private static Node[] node;
	private static int answer;
	private static boolean[][] visited;
	public static void main(String[] args) {
		//n+1로 배열을 만들자
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr = new int[n][n];
		int len = n*n;
		node =new Node[n*n+1];
		
		//주변의 빈자리를 세어준다.
		set_zero_cnt();
		map =new HashMap<>();
		
		visited =new boolean[n][n];
		
		for (int p = 0; p < n*n; p++) {
			int num = sc.nextInt();
			int [][] near_cnt = new int[n][n];
			int [] near = new int[4];
			int idx=0;
			boolean flag =false;
			for (int q = 0; q < 4; q++) {
				int a = sc.nextInt();
				
				near[idx++]=a;
				
				//1. 비어있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정해야한다.
				if(node[a]!=null) {
					int x = node[a].x;
					int y = node[a].y;
					
					
					for (int i = 0; i < 4; i++) {
						int nx = x+dx[i];
						int ny = y+dy[i];
						
						if(nx<0 || nx>n-1 || ny<0 || ny>n-1 || arr[nx][ny]!=0)continue;
						near_cnt[nx][ny]++;
						flag=true;
					}
					
					
				}
			}// end of for
			if(!flag) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if(arr[i][j]==0)near_cnt[i][j]++;
					}
				}
			}
			
//			print2(near_cnt);
			
			map.put(num, near);
			
			//플래그를 안쓰고 max_near를 -1로 초기화 시키면된다.
			int max_near=0;
			
			int near_x=0;
			int near_y=0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(near_cnt[i][j]>max_near && arr[i][j]==0) {
						max_near=near_cnt[i][j];
						near_x = i;
						near_y = j;
					}
					//2. 1을 만족하는 칸이 여러개면 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로
					else if(max_near==near_cnt[i][j]) {
						if(zero_arr[i][j]>zero_arr[near_x][near_y]) {
							near_x=i;
							near_y=j;
							
//							System.out.println(zero_arr[i][j]);
						}
						//3. 2를 만족하는 칸도 여러개면 행의 번호가 가장 큰칸, 그러한 칸도 여러개면 열의번호가 가장 작은 자리
						else if(zero_arr[i][j]==zero_arr[near_x][near_y]) {
							if(i<near_x) {
								near_x=i;
							}else if(i==near_x) {
								if(near_y>j) {
									near_y=j;
								}
							}
						}
					}	
				}// end of for
			}//end of for
//			System.out.println(near_x+":"+near_y);
			arr[near_x][near_y]=num;

			
			node[num]= new Node(num,near_x,near_y);
			//남은 공간 줄이기
			for (int i = 0; i < 4; i++) {
				int nx = near_x +dx[i];
				int ny = near_y +dy[i];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1 || zero_arr[nx][ny]==0)continue;
				zero_arr[nx][ny]--;
			}
			
		}// end of for
			
		//만족도 계산
		answer=0;
		calc();
//		print2(zero_arr);
//		print();
		
			
		
		System.out.println(answer);
		
		
		
	}
	
	private static void calc() {
		for (int i = 1; i <=n*n; i++) {
			int [] cur = map.get(i);
			
//			System.out.println(Arrays.toString(cur));

			int x= node[i].x;
			int y = node[i].y;
			int cnt=0;
			for (int j = 0; j < 4; j++) {
				int nx = x+dx[j];
				int ny = y+dy[j];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1) continue;
				int num= arr[nx][ny];
				
				for (int k = 0; k < cur.length; k++) {
					if(num==cur[k]) {
						cnt++;
						break;
					}
				}
			}
//			System.out.println(cnt);
			if(cnt==1)answer+=1;
			else if(cnt==2)answer+=10;
			else if(cnt==3)answer+=100;
			else if(cnt==4)answer+=1000;
				
		}
		
	}

	private static void set_zero_cnt() {
		zero_arr = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cnt=4;
				if(i==0 || i==n-1)cnt--;
				if(j==0 || j==n-1)cnt--;
				
				zero_arr[i][j]=cnt;
			}
		}
		
	}
	
	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void print2(int [][] arr) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(zero_arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
package 알고리즘스터디;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_17144_미세먼지안녕_골드4 {
	private static int[][] arr;
	private static int r;
	private static int c;
	private static int t;
	private static int[][] air;
	private static int[][] n_arr;
	private static int[][] c_arr;
	private static int sum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		t = sc.nextInt();
		
		arr = new int[r][c];
		
		
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		sum =0;
		for (int test = 0; test < t; test++) { //t초만큼 반복
			ArrayList<int[]>list =new ArrayList<>();
			ArrayList<int[]>spread = new ArrayList<>();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if(arr[i][j]==-1)list.add(new int[] {i,j});
					else if(arr[i][j]!=0 && arr[i][j]!=-1) {
						spread.add(new int[] {i,j});

					}
				}
			}
			
			//확산 시키기
			n_arr =new int[r][c];
			bfs(spread);
			
			//원래 배열에 더해주기
			plus();
			
//			print();
//			System.out.println();
			
			//공기청정기
			c_arr =new int[r][c];
			for (int k = 0; k < r; k++) {
				System.arraycopy(arr[k], 0, c_arr[k], 0, arr[k].length);
			}
			
//			for (int i = 0; i < r; i++) {
//				for (int j = 0; j < c; j++) {
//					System.out.print(c_arr[i][j]+" ");
//				}
//				System.out.println();
//			}
			
			go(list);
			
			
		}
		
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(arr[i][j]>0) {
					sum+=arr[i][j];
				}
			}
		}
		System.out.println(sum);
		
		
		
		
		
		
		
	}

	private static void plus() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j]+=n_arr[i][j];
			}
		}
		
	}

	private static void go(ArrayList<int[]> list) {
		int a = list.get(0)[0];
		int b = list.get(0)[1];
		
		int x = a;
		int y = c;
	
		for (int i = 0; i<x; i++) { //하
			if(arr[a][b]==-1) {
				a--;
				continue;
			}
//			System.out.println(i);
			arr[a][b]=c_arr[--a][b];
			
		}
		
		
		
		for (int i = 0; i < y-1; i++) { //좌
			arr[a][b]=c_arr[a][++b];
		}
		
		
		
		for (int i = 0; i < x; i++) { //상
			
			arr[a][b]=c_arr[++a][b];
		}
		
		for (int i = 0; i < y-2; i++) { //우
			arr[a][b] = c_arr[a][--b];
		}
		arr[a][b]=0;
		
		a = list.get(1)[0];
		b = list.get(1)[1];
		
		x = a;
		y = c;
		
		for (int i = x; i < r-1; i++) { //하
			if(arr[a][b]==-1) {
				a++;
				continue;
			}
			
			arr[a][b]=c_arr[++a][b];
			
		}
//		System.out.println(a+":"+b);
		for (int i = 0; i < y-1; i++) {
			arr[a][b] = c_arr[a][++b];
		}
		
//		System.out.println(a+":"+b);
		
		for (int i = x; i < r-1; i++) {
			arr[a][b] = c_arr[--a][b];
		}
		
//		System.out.println(a+":"+b);
		
		for (int i = 0; i < c-2; i++) {
			arr[a][b] = c_arr[a][--b];
		}
		arr[a][b]=0;
//		System.out.println(a+":"+b);
//		

		
		
		
		
		
	}

	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	private static void bfs(ArrayList<int[]> spread) {
//		boolean [][] visited =new boolean[r][c];
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < spread.size(); i++) {
			int a = spread.get(i)[0];
			int b=  spread.get(i)[1];
			q.add(new int[] {a,b});
		}
		while(!q.isEmpty()) {
			int [] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			int num = arr[x][y]/5;
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || ny<0 || nx>r-1 || ny>c-1 || arr[nx][ny]==-1)continue;
				
				if(arr[nx][ny]>=0) {
					n_arr[x][y]-=num;
					n_arr[nx][ny]+=num;
				}
			}// end of for	
		}// end of while
		
		
		
		
		
		
		
	}

	private static void print() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}



package 알고리즘스터디;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_17143_낚시왕_골드1 {
	private static int r;
	private static int c;
	private static Shark[][] arr;
	private static int answer;
	public static class Shark{
		int x,y,s,d,z;
		
		public Shark(int x, int y, int s , int d, int z) {
			this.x=x;
			this.y=y;
			this.s=s;
			this.d=d;
			this.z=z;
		}
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		int m = sc.nextInt();
		
		arr =new Shark[r][c];
		
//		HashMap<Integer,int[]> map = new HashMap<>();
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt()-1; //상어의 위치
			int y = sc.nextInt()-1;
			int s = sc.nextInt(); //상어의 스피드
			int d = sc.nextInt()-1; //상어의 방향
			int z = sc.nextInt(); //상어의 크기
			
			arr[x][y]=new Shark(x,y,s,d,z);
		}
		
		answer = 0;
		
		for (int i = 0; i <c; i++) { //낚시왕 이동
			//상어 잡기
			fishing(i);
			
			//상어 이동
			moving();
			
			for (int a = 0; a < r; a++) {
				System.arraycopy(n_arr[a], 0, arr[a], 0, n_arr[a].length);
			}
//			print();
//			System.out.println();
			
			
		}
		
		System.out.println(answer);
		
		
		
		
		
	}
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,1,-1};
	private static Shark[][] n_arr;
	
	private static void moving() {
		Queue<Shark> q= new LinkedList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(arr[i][j]!=null) {
					q.add(new Shark(i,j,arr[i][j].s,arr[i][j].d,arr[i][j].z));
				}
					
			}
		}
		
		n_arr =new Shark[r][c];
		
		
		while(!q.isEmpty()) {
			Shark sk = q.poll();
			
			int speed = sk.s;
//			System.out.println(sk.x+":"+sk.y+"-"+sk.d);

			if(sk.d==0 || sk.d==1) {
				speed %= r*2-2;
			}else {
				speed %= c*2-2;
			}
			System.out.println(speed);
			for (int i = 0; i <speed ; i++) {
				//배열*2 - 2
				//행의 길이 10 (열10개)
				
				int nx = sk.x+dx[sk.d];
				int ny = sk.y+dy[sk.d];
				
				if(nx<0 || nx>r-1 || ny<0 || ny>c-1) {
					sk.x -= dx[sk.d];
					sk.y -= dy[sk.d];
					if(sk.d==0) {
						sk.d=1;
					}else if(sk.d==1) {
						sk.d=0;
					}else if(sk.d==2) {
						sk.d=3;
					}else if(sk.d==3) {
						sk.d=2;
					}
					continue;
				}
				
				sk.x = nx;
				sk.y = ny;
				System.out.println(sk.x+":"+sk.y+":"+sk.d);
			}
			
			if(n_arr[sk.x][sk.y]!=null) {
				if(n_arr[sk.x][sk.y].z < sk.z) { //기존의 배열보다 크다면 상어를 먹는다.
					n_arr[sk.x][sk.y]=new Shark(sk.x,sk.y,sk.s,sk.d,sk.z);
				}
			}else {
				n_arr[sk.x][sk.y] = new Shark(sk.x, sk.y, sk.s, sk.d, sk.z);
			}
			
			
		}
		
		
		
	}
	private static void fishing(int y) {
		for (int i = 0; i < r; i++) {
			if(arr[i][y]!=null) {
//				System.out.println(arr[i][y].z);
				answer+=arr[i][y].z;
				arr[i][y]=null;
				break;
			}
		}
		
	}
	
	public static void print() {
		int [][] visited = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(arr[i][j]!=null) {
					visited[i][j]=1;
				}
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(visited[i][j]);
			}
			System.out.println();
		}
	}
}
	
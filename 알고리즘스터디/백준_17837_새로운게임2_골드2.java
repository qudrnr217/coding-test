package 알고리즘스터디;

import java.util.ArrayList;
import java.util.Scanner;

public class 백준_17837_새로운게임2_골드2 {
	private static int[][] arr;
	private static Horse[] horse;
	public static ArrayList<Integer>[][]list;
	private static int n;
	private static int k;
	public static class Horse{
		int x,y,dir;
		public Horse(int x,int y, int dir) {
			this.x=x;
			this.y=y;
			this.dir=dir;
		}
	}
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt(); //체스판의 크기
		k = sc.nextInt(); //말의 개수
		
		
		horse = new Horse[k+1];
		
		arr =new int[n][n];
		list= new ArrayList[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j]=sc.nextInt();
				list[i][j]=new ArrayList<>();
			}
		}
		
		for (int i = 0; i < k; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			horse[i+1]=new Horse(a-1,b-1,c-1);
			list[a-1][b-1].add(i+1);
		}
		
		int answer=0;
		
		while(answer<=1000) {
			answer++;
			if(move()) {
				break;
			}
		}
		
		System.out.println(answer==1001?-1:answer);
		
		
		
		
		
		
		
	}
	static int [] dx = {0,0,-1,1};
	static int [] dy = {1,-1,0,0};
	private static boolean move() {
		for(int i=1;i<=k;i++) { //1번 4번 말이 순서대로 움직여야하니까
			int x = horse[i].x;
			int y = horse[i].y;
			int dir = horse[i].dir;
			
			ArrayList<Integer> up_horse = new ArrayList<>();
			int start_idx=0;
			//위에 있는말 가져오기
			for (int p = 0; p < list[x][y].size(); p++) {
				if(list[x][y].get(p)==i) {
					start_idx=p;
					break;
				}
			}
			//위에있는 말 추가해주기
			for (int p = start_idx; p < list[x][y].size(); p++) {
				up_horse.add(list[x][y].get(p));
			}
			
			
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			if(nx<0 || nx>n-1 || ny<0 || ny>n-1 || arr[nx][ny]==2) { //파란색과 같은 역할
				nx-=dx[dir];
				ny-=dy[dir];
//				System.out.println("dir1: " +dir);
				if(dir==0) { //방향 바꿔주기
					dir=1;
				}else if(dir==1) {
					dir=0;
				}else if(dir==2) {
					dir=3;
				}else {
					dir=2;
				}
//				System.out.println("dir2: "+dir);
				nx+=dx[dir];
				ny+=dy[dir];
				
				
				
				horse[i].dir=dir;
//				int xx = x+dx[dir];
//				int yy = y+dy[dir];
				
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1 || arr[nx][ny]==2) { //반대 방향으로 가도 파란색이거나 범위를 초과했을 경우
					continue;
				}else {
					if(arr[nx][ny]==1) { //반대로 쌓아주기
						for (int p = up_horse.size()-1; p >= 0; p--) {
							list[nx][ny].add(up_horse.get(p));	
							horse[up_horse.get(p)]= new Horse(nx,ny,horse[up_horse.get(p)].dir);
							
						}
					}else if(arr[nx][ny]==0) {
						for(Integer h :up_horse) {
							list[nx][ny].add(h);
							horse[h] = new Horse(nx,ny,horse[h].dir);
						}
					}
				}
				
			}else if(arr[nx][ny]==1) { //반대로 쌓아주기
				for (int p = up_horse.size()-1; p >= 0; p--) {
					list[nx][ny].add(up_horse.get(p));
					horse[up_horse.get(p)]= new Horse(nx,ny,horse[up_horse.get(p)].dir);
					
				}
			}else if(arr[nx][ny]==0) {
				for(Integer h :up_horse) {
					list[nx][ny].add(h);
					horse[h] = new Horse(nx,ny,horse[h].dir);
				}
			}
			
			if(list[nx][ny].size()>=4) {
				return true;
			}
			
			for (int p = list[x][y].size()-1; p >= start_idx; p--) {
				list[x][y].remove(p);
			}
			
		}
		return false;
		
	}
}

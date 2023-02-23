package 알고리즘스터디;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class 백준_19236_청소년상어_골드2 {
//	private static Node[][] arr;
	private static int answer;
	public static class Fish{
		int num,dir, x, y;
		boolean alive;
		public Fish(int num,int dir, int x, int y, boolean eat) {
			this.num=num;
			this.dir=dir;
			this.x=x;
			this.y=y;
			this.alive=eat;
			
		}
	}
	
	public static Fish [] fish;
	static int [][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		fish = new Fish[17];
		arr = new int[4][4];
		
		for(int i=0;i<4;i++) {
			for (int j = 0; j < 4; j++) {
				int a = sc.nextInt(); //물고기 번호 
				int b = sc.nextInt()-1; //방향
				
				fish[a]=new Fish(a,b,i,j,true);
				arr[i][j]=a;
			}
		}
		
		int sx = 0, sy=0;
		int sd = fish[arr[0][0]].dir;
		int eat = arr[0][0];
	
		fish[arr[0][0]].alive=false; //물고기 죽음
		arr[0][0]=-1;
		
		dfs(sx,sy,sd,eat);
		
		System.out.println(answer);
		
		
		
				
		
		
	
	}
	
	//상, 좌상, 좌, 좌하, 하, 우하, 우, 우상
	static int [] dx = {-1,-1, 0, 1, 1, 1, 0, -1};
	static int [] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	private static int[][] c_arr;
	private static void dfs(int sx, int sy, int sd, int eat) {
		answer = Math.max(answer, eat);
		
		//기존의 배열 복사
		c_arr =new int[4][4];
		for (int i = 0; i < 4; i++) {
			System.arraycopy(arr[i], 0, c_arr[i], 0, arr[i].length);
		}
		
		//Fish배열 복사
		Fish [] c_fish = new Fish[17];
		for(int i=1;i<=16;i++) {
//			c_fish[i]= new Fish(fish[i].num,fish[i].dir,fish[i].x,fish[i].y,fish[i].alive);
			c_fish[i]=fish[i];
		}
		

		//물고기 이동
		move_fish();
		
		//상어 이동
		for (int i = 1; i < 4; i++) {
			
			int nx = sx+dx[sd]*i;
			int ny = sy+dy[sd]*i;
			
			//경게를 벗어나지 않고 물고기가 없는 빈칸이 아닐 경우
			if(nx>=0 && nx<4 && ny>=0 &&ny<4 && arr[nx][ny]!=0) {
				int eatFish = arr[nx][ny];
//				System.out.println(nx+":"+ny+":"+eatFish);
//				System.out.println("dir: "+sd );
				int dir = fish[eatFish].dir;
				arr[sx][sy]=0; //물고기를 잡아먹었으니 0으로 만들어준다.
				arr[nx][ny]=-1; //상어가 이동한자리
				fish[eatFish].alive=false;
				
				dfs(nx,ny,dir,eat+eatFish);
				
				fish[eatFish].alive=true;
				arr[sx][sy]=-1;
				arr[nx][ny]=eatFish;
			}
			
		}
		
		for (int i = 0; i < 4; i++) {
			System.arraycopy(c_arr[i], 0, arr[i], 0, c_arr[i].length);
		}
		
		for (int i = 1; i <=16; i++) {
			fish[i] = c_fish[i];
		}
		
		
	}
	
	
	private static void move_fish() {
		for (int i = 1; i <= 16; i++) {
//			System.out.println(i+"-"+fish[i].alive);
			if(!fish[i].alive) {
//				System.out.println(i+":"+fish[i].alive);
				continue;
			}
//			System.out.println(fish[6].x+":"+fish[6].y+":"+fish[6].alive+fish[6].dir);
			int x = fish[i].x;
			int y = fish[i].y;
			int dir = fish[i].dir;
			int num = fish[i].num;
			
			int nx = x+dx[dir];
			int ny = y+dy[dir];
			
			while(nx<0 || nx>3 || ny<0 || ny>3 || arr[nx][ny]==-1) {
				dir++;
				if(dir==8)dir=0;
				
				nx= x+dx[dir];
				ny= y+dy[dir];
			}
			
			if(arr[nx][ny]==0) {
				fish[arr[x][y]] = new Fish(arr[x][y],dir,nx,ny,fish[arr[x][y]].alive);
//				fish[arr[nx][ny]] = new Fish(arr[nx][ny], fish[arr[nx][ny]].dir, x,y,fish[arr[nx][ny]].alive);
				arr[x][y]=arr[nx][ny];
				arr[nx][ny]=num;

			}else {
//				System.out.println(fish[6].x+":"+fish[6].y+":"+fish[6].alive+":"+dir);
				//위치 바꿔주기
				fish[arr[x][y]] = new Fish(arr[x][y],dir,nx,ny,fish[arr[x][y]].alive);
				fish[arr[nx][ny]] = new Fish(arr[nx][ny], fish[arr[nx][ny]].dir, x,y,fish[arr[nx][ny]].alive);
				arr[x][y]=arr[nx][ny];
				arr[nx][ny]=num;
//				System.out.println(i);
//				print();
//				System.out.println();
			}
			
			
			
		}
		
		
	}


	public static void print_f() {
		for(int i=1;i<=16;i++) {
			System.out.print(fish[i].alive+" ");
		}
	}

	public static void print() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(c_arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

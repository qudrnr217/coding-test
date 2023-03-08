package 실제코테문제들;

import java.util.Scanner;

public class 현대엔지비_2번 {
	private static boolean[][] visited;

	//상,하,좌,우,좌상,우상,우하,좌하
	static int [] dx = {-1,1,0,0,-1,-1,1,1};
	static int [] dy = {0,0,-1,1,-1,1,1,-1};

	private static int n;

	private static char[][] arr;

	private static int answer;
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr =new char[n][n];
		
		sc.nextLine();
		
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextLine().toCharArray();
		}
		
		visited =new boolean[n][n];
		
		answer=0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j]=='O') {
					for (int k = 0; k < 8; k++) {
						go(i,j,k);
	
						
					}
					visited[i][j]=true;
//					return;
				}
			}
		}
		System.out.println(answer);
		
	}

	private static void go(int x, int y, int dir) {
//		System.out.println(x+":"+y);
		int nx = x+dx[dir];
		int ny = y+dy[dir];
		
		if(nx<0 || nx>n-1 || ny<0 || ny>n-1 || visited[nx][ny])return;
		
		if(arr[nx][ny]=='X') {
			go(nx,ny,dir);
		}else if(arr[nx][ny]=='O') {
			System.out.println(nx+":"+ny);
			answer++;
			return;
//			return true;
		}
		
//		return false;
	}
}

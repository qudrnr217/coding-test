package 알고리즘스터디;

import java.util.Scanner;

public class 백준_20057_마법사상어와토네이도_골드3 {
	private static int n;
	private static int[][] arr;
	//좌하우상
	static int [] dx = {0,1,0,-1};
	static int [] dy = {-1,0,1,0};
	static int [] dc = {1,1,2,2};
	//좌하우상 토네이도 퍼센트
	static int [][] tx = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},    //모래가 퍼지는 x방향
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
	static int [][] ty = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},    //모래가 퍼지는 y방향
            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
	static int [] per = {1,1,2,7,7,2,10,10,5};
	private static int res;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		
		arr =new int[n][n];
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		int center = n/2;
		
		go(center);
		
		System.out.println(res);
		
		
		
		
	}
	private static void go(int center) {
		int x = center;
		int y = center;
		//토네이도 좌표
		int nx = x;
		int ny = y;
		res=0;
		
		while(true) {
			
			
//			print();
//			System.out.println();
			//토네이도 움직여주기
			for (int d = 0; d < 4; d++) { //토네이도의 방향
				for (int i = 0; i < dc[d]; i++) { //규칙대로 몇번 이동하는지 알려주기
					nx +=dx[d];
					ny +=dy[d];
					
					if(nx<0 || nx>n-1 || ny<0 || ny>n-1)return;
					
					int cx=0;
					int cy=0;
//					System.out.println(nx+":"+ny);
					if(arr[nx][ny]>0) { //모래가 있을 경우  
						int sand = arr[nx][ny];
						int s_sum = sand;
						for (int k = 0; k < 9; k++) {
							//흩뿌려주기
							//흩뿌려질 위치 cx, cy 저장
							cx=nx+tx[d][k];
							cy=ny+ty[d][k];
							
//							System.out.println(cx+":"+cy);
							
							int sum = (int)(sand*(per[k]*0.01));
							//모래가 바깥으로 넘어갈 경우
							if(cx<0 || cx>n-1 || cy<0 || cy>n-1) {
								res+=sum;
							}
							else { //안넘어 갈 경우
								arr[cx][cy]+=sum;
							}
							s_sum-=sum;
							
						}
						
						
						//알파 값을 넣어주기
						int alpha_x = nx+dx[d];
						int alpha_y = ny+dy[d];
						
						if(alpha_x<0 || alpha_x>n-1 || alpha_y<0 || alpha_y>n-1)res+=s_sum;
						else arr[alpha_x][alpha_y]+=s_sum;
						
						//이전의 모래 0으로 초기화
						arr[nx][ny]=0;
						
					}
				}// end of for
				
			}// end of for
			
			
			
			//한사이클이 지났으므로 dc를 2씩 더해준다.
			for (int i = 0; i < dc.length; i++) {
				dc[i]+=2;
			}
			
//			break;
		}// end of while 
		
	}
	public static void print() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

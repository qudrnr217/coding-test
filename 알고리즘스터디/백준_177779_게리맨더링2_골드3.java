package 알고리즘스터디;

import java.util.Scanner;

public class 백준_177779_게리맨더링2_골드3 {
	private static int[][] arr;
	private static int answer;
	private static int n;
	private static boolean[][] visited;
	private static int total;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		n = sc.nextInt();
		arr =new int[n+1][n+1];
		total = 0;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=n; j++) {
				arr[i][j]=sc.nextInt();
				total+=arr[i][j];
			}
		}
		
	
		
		answer = Integer.MAX_VALUE;
		int sum =0;
		//완전탐색을 시킨다.
		for (int x = 1; x <= n; x++) {
			for (int y = 1; y <= n; y++) {
				for (int d1 = 1; d1 <=n; d1++) {
					for (int d2 = 1; d2 <= n; d2++) {
						if(x+d1+d2<=n && y-d1>=1 && y+d2<=n) {
							sum =go(x,y,d1,d2);
							answer = Math.min(answer, sum);
//							System.out.println(answer);
//							return;
						}
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}

	private static int go(int x, int y, int d1, int d2) {
//		System.out.println();
		visited =new boolean[n+1][n+1];
		int sum=0;
		int r = x;
		int c = y;
		
		visited[x][y]=true;
		
		//1.1 번 조건문
//		System.out.println(r+":"+c+":"+d1+":"+d2);
		for(int i=1;i<=d1;i++) {
			r+=1;
			c-=1;
			visited[r][c]=true;
		}
		
		//2. 2번 조건문
		for (int i = 1; i <=d2; i++) {
			r+=1;
			c+=1;
			visited[r][c]=true;
		}
		
		//3. 3번 조건문
		for (int i = 1; i <= d1; i++) {
			r-=1;
			c+=1;
			visited[r][c]=true;
		}
		
		//4. 4번 조건문
		for (int i = 1; i <= d2; i++) {
			r-=1;
			c-=1;
//			System.out.println("오류: "+r+":"+c);
			visited[r][c]=true;
		}
		
		
		int[] people =new int[5];
		
		people[4]=total;
//		
		//계산하기 
		//1번 선거구 
		for(int i=1;i<x+d1;i++) {
			for(int j=1;j<=y;j++) {
				if(!visited[i][j]) {
					people[0]+=arr[i][j];
				}else {
					break;
				}
			}
		}
		
//		System.out.println("sum1:" +people[0]);
		//2번 선거구
		for (int i = 1; i <=x+d2 ; i++) {
			for (int j = n; j >=y+1; j--) {
				if(!visited[i][j]) {
					people[1]+=arr[i][j];
				}else {
					break;
				}
			}
		}
//		System.out.println("sum2:" +people[1]);
		
		//3번 선거구
		
//		System.out.println(y-d1+d2);
		for (int i = x+d1; i <=n; i++) {
			for (int j = 1; j < y-d1+d2; j++) {
				if(!visited[i][j])people[2]+=arr[i][j];
				else break;
			}
		}
		
//		System.out.println("sum3:" +people[2]);
		//4번 선거구
		
//		System.out.println(y-d1+d2);
		for (int i = x+d2+1; i <= n; i++) {
			for (int j = n; j >= y-d1+d2; j--) {
				if(!visited[i][j])people[3]+=arr[i][j];
				else break;
			}
		}
//		System.out.println("sum4:" +sum);
//		System.out.println("sum4:" +people[3]);
//		print();
		
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		//5번 선거구
		for (int i = 0; i < 4; i++) {
//			System.out.println(people[i]);
			people[4]-=people[i];
		}
		
//		System.out.println("total: "+total);
//		people[4]=total;
		for(int i=0;i<5;i++) {
			max = Math.max(max, people[i]);
			min = Math.min(min,people[i]);
		}
		
		sum = max-min;
//		System.out.println(sum);
		
		return sum;
		
	}
	
//	public static void print() {
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= n; j++) {
//				System.out.print(visited[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
//	}

	
}

//d1 + d2 <= N 

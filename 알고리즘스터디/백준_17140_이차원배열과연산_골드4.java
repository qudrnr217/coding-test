package 알고리즘스터디;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준_17140_이차원배열과연산_골드4 {
	private static int[][] n_arr;
	private static int[][] arr;
	private static int r_len;
	private static int c_len;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();
		
		arr= new int[100][100];
		
		r_len = 3;
		c_len = 3;
		
		for (int i = 0; i < r_len; i++) {
			for (int j = 0; j < c_len; j++) {
				arr[i][j]=sc.nextInt();
			}
		}
		
		int answer=0;
		int cnt=0;
		
		while(cnt<=100) {
			
//			System.out.println(r_len+":"+c_len);
			
			//arr[r][c] =k 인지 검사
			if(arr[r-1][c-1]==k) {
				System.out.println(answer);
				return;
			}
			
			
			int max_r = 0;
			int max_c = 0;
			
			//r_len >=c_len 일경우
			if(r_len>=c_len) {
				n_arr =new int[100][100];
				for (int i = 0; i < r_len; i++) {
					HashMap<Integer,Integer> map = new HashMap<>();
					for (int j = 0; j < c_len; j++) {
						if(arr[i][j]==0)continue;
						map.put(arr[i][j], map.getOrDefault(arr[i][j],0)+1);
					}
					//Hash map을 이용하여 숫자들을 arr에 넣기
					
//					for(int a : map.keySet()) {
//						System.out.print(a+":"+map.get(a)+" ");
//						System.out.println();
//					}
				
					
					
					//pq를 활용하여 저장
					PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
						if(o1[1]==o2[1]) {
							return o1[0]-o2[0];
						}
						return o1[1]-o2[1];
					});
					
					//map을 pq에 저장.
					for(int a : map.keySet()) {
						int [] res = new int[2];
						res[0]=a;
						res[1]=map.get(a);
						
						pq.add(res);
					}
					
					
					
					
					
					int idx=0;
					int c_cnt=0;
					while(!pq.isEmpty()) {
						int [] a = pq.poll();
//						System.out.print(a[0]+":"+a[1]+" ");
						n_arr[i][idx++]=a[0];
						n_arr[i][idx++]=a[1];
						c_cnt+=2;
					}
//					System.out.println();
					
					
					max_c = Math.max(max_c, c_cnt);
//					System.out.println("r_len: "+r_len);
					
					
				}//end of for 
				
				answer++;
				cnt++;
				
				
				c_len =max_c;
				for (int i = 0; i < 100; i++) {
					System.arraycopy(n_arr[i],0,arr[i],0,100);
				}
				
//				print();
//				System.out.println();
				
				
			
			}else { //c_len > r_len
				n_arr =new int[100][100];
//				System.out.println("r: "+r_len);
//				System.out.println("c "+c_len);
				for (int i = 0; i < c_len; i++) {
					HashMap<Integer,Integer> map = new HashMap<>();
					for (int j = 0; j < r_len; j++) {
						if(arr[j][i]==0)continue;
						map.put(arr[j][i], map.getOrDefault(arr[j][i],0)+1);
					}
					//Hash map을 이용하여 숫자들을 arr에 넣기
					
//					for(int a : map.keySet()) {
//						System.out.print(a+":"+map.get(a)+" ");
//						System.out.println();
//					}
				
					
					
					//pq를 활용하여 저장
					PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
						if(o1[1]==o2[1]) {
							return o1[0]-o2[0];
						}
						return o1[1]-o2[1];
					});
					
					//map을 pq에 저장.
					for(int a : map.keySet()) {
						int [] res = new int[2];
						res[0]=a;
						res[1]=map.get(a);
						
						pq.add(res);
					}
					
					
					
					
					
					int idx=0;
					int r_cnt=0;
					while(!pq.isEmpty()) {
						int [] a = pq.poll();
//						System.out.print(a[0]+":"+a[1]+" ");
						n_arr[idx++][i]=a[0];
						n_arr[idx++][i]=a[1];
						r_cnt+=2;
					}
//					System.out.println();
					
					
					max_r = Math.max(max_r, r_cnt);
//					System.out.println("r_len: "+r_len);
					
					
				}//end of for 
				
				answer++;
				cnt++;
				
				
				r_len =max_r;
				for (int i = 0; i < 100; i++) {
					System.arraycopy(n_arr[i],0,arr[i],0,100);
				}
				
//				print();
//				System.out.println();
//		
				
					

				
				
				
			}// end of else 
			
			
			
		}// end of while
		
		System.out.println(answer==101?-1:answer);
		
		
	}// end of main
	public static void print() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

/*
 * 
 * R 연산: 배열 A의 모든 행에 대해서 정렬을 수행한다. 행의 개수 ≥ 열의 개수인 경우에 적용된다.
 *C 연산: 배열 A의 모든 열에 대해서 정렬을 수행한다. 행의 개수 < 열의 개수인 경우에 적용된다.
 */

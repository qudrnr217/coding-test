package 그리디;

import java.util.PriorityQueue;
import java.util.Scanner;

public class 백준_15903_카드합체놀이_실버1 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		PriorityQueue<Long>pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			long num = sc.nextLong();
			pq.add(num);
		}
		
		for(int i=0;i<m;i++) {
			long a = pq.poll();
			long b = pq.poll();
			
			long sum= a+b;
			
			pq.add(sum);
			pq.add(sum);
		}
		
		long answer= 0;
		
		for(long a : pq) {
			answer+=a;
		}

		System.out.println(answer);
		
		
	}
}

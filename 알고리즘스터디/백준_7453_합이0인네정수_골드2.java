package 슬라이딩윈도우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 백준_7453_합이0인네정수_골드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		long [] arr =new long[n];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i]=Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		int a =0;
		int b =0;
		int c =0;
		
		for(int i=0;i<n-2;i++) {
			
			int start = i+1;
			int end = arr.length-1;
			
			while(start<end) {
				long mid = arr[start]+arr[end]+arr[i];
				
				long sum = Math.abs(mid);
//				System.out.println(min+"::"+mid);
				if(min>sum) {
					min = sum;
					a=start;
					b=end;
					c=i;
//					System.out.println(a+":"+b+":"+c);
				}
				
				if(mid>0)end--;
				else start++;
			}
			
		}
		
		long [] res = new long[3];
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(a);
		list.add(b);
		list.add(c);
		
//		System.out.println(a+":"+b+":"+c);
		
		Collections.sort(list);
		
		res[0]=arr[list.get(0)];
		res[1]=arr[list.get(1)];
		res[2]=arr[list.get(2)];

		for (int i = 0; i < 3; i++) {
			System.out.print(res[i]+" ");
		}
		
		
	
	
	}
}

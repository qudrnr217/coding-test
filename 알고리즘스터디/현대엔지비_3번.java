package 실제코테문제들;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 현대엔지비_3번 {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int [] arr =new int[n];
		
		HashMap<Integer,Integer>map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			int num =sc.nextInt();
			arr[i]=num;
		}
		
		 
		
		int [] c_arr = new int[n];
		c_arr[0]=arr[0];
		for (int i = 1; i < c_arr.length; i++) {
			c_arr[i]=c_arr[i-1]+arr[i];
		}

		System.out.println(Arrays.toString(c_arr));
		
		
		
		
		int [] zero_arr =new int[n];
		for (int i = 0; i < n; i++) {
			if(c_arr[i]==0) {
				zero_arr[i]=1;
			}
		}

		for (int i = 1; i < zero_arr.length; i++) {
			zero_arr[i]+=zero_arr[i-1];
		}
		System.out.println(Arrays.toString(zero_arr));
		
		
		
		
		
		
		int max=0;
		
		
		for (int i = c_arr.length-1; i >-1; i--) {
			if(i-1==-1) {
				max = Math.max(max, 0+map.getOrDefault(arr[i],0));
				break;
			}
			map.put(c_arr[i], map.getOrDefault(c_arr[i], 0)+1);
			
			max = Math.max(max, zero_arr[i-1]+map.getOrDefault(arr[i],0));
		}
		

		System.out.println(max);
		
		
		
	}
}

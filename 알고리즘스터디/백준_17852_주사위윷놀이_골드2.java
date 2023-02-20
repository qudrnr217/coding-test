package 알고리즘스터디;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_17852_주사위윷놀이_골드2 {
	private static int[] out;
	static int [] map = {
			0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0, //0 ~ 21
            10, 13, 16, 19, 25, 30, 35, 40, 0,  //22 ~ 30
            20, 22, 24, 25, 30, 35, 40, 0,      //31 ~ 38
            30, 28, 27, 26, 25, 30, 35, 40, 0 //39 ~ 47
	};
	private static int[] arr;
	private static int answer=0;;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		arr =new int[10];
		
		for (int i = 0; i < 10; i++) {
			arr[i]=sc.nextInt();
		}
		
		out = new int[10];
		permutations(0);
		System.out.println(answer);
	}

	private static void permutations(int depth) {
		
		if(depth==10) {
			go();
			return;
		}
		
		for(int i=0;i<4;i++) {
			out[depth]=i;
			permutations(depth+1);
		}
		
	}

	private static void go() {
		boolean [] visited = new boolean[map.length];
		int score = 0;
		int [] p = new int[4];
		
		for (int i = 0; i < 10; i++) {
			int now_dice = arr[i];
			int now_order = out[i];
			if(isFinish(p[now_order]))return; //만약 도착했다면 끝내기
			
			int next = next_point(p[now_order],now_dice);
			if(isFinish(next)) {
				setVisited(visited,p[now_order],false);
				p[now_order]=next;
				continue;
			}
			if(visited[next])return;
			setVisited(visited,p[now_order],false);
			setVisited(visited,next,true);
			
			p[now_order]=next;
			score += map[p[now_order]];
			
		}
		answer  =Math.max(answer, score);
		
	}

	private static void setVisited(boolean[] visited, int idx, boolean check) {
		if(idx==20 || idx ==29 || idx == 37 || idx ==46) {
			visited[20]=check;
			visited[29]=check;
			visited[37]=check;
			visited[46]=check;
		}else if(idx ==26 || idx == 34 || idx ==43) {
			visited[26]=check;
			visited[34]=check;
			visited[43]=check;
		}else if(idx ==28 || idx==36||idx==45) {
			visited[28]=check;
			visited[36]=check;
			visited[45]=check;
		}else {
			visited[idx]=check;
		}
		
	}

	private static int next_point(int nowIdx, int dice) {
		int nextIdx = nowIdx + dice;
		
		if(nowIdx<21) {
			if(nextIdx>=21) nextIdx=21;
		}else if(nowIdx<30) {
			if(nextIdx>=30) nextIdx=30;
		}else if(nowIdx<38) {
			if(nextIdx>=38) nextIdx=38;
		}else if(nowIdx<47) {
			if(nextIdx>=47) nextIdx=47;
		}
		
		if(nextIdx ==5) return 22;
		if(nextIdx ==10)return 31;
		if(nextIdx == 15) return 39;
		return nextIdx;
	}

	private static boolean isFinish(int idx) {
		if(idx ==21 || idx == 30 || idx ==38 || idx==47)return true;
		return false;
	}
}

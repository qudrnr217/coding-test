import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        //큐에 모두 넣기
        for(int a : queue1){
            q1.add(a);
        }
        
        for(int a : queue2){
            q2.add(a);
        }
        
        
        //전체합 계산
        long sum_a = Arrays.stream(queue1).sum();
        long sum_b = Arrays.stream(queue2).sum();
        
        int q1_size = queue1.length;
        int q2_size = queue2.length;
        
        
        long half = (long)(sum_a+sum_b)/2;
        int cnt=0;
        while(true){
            // System.out.println(sum_a+":"+sum_b);
            if((q1_size + q2_size)*2 == cnt){ //q1= 1 4 q2 = 3 4일 경우 무한 루프이므로 배열의 총 길이의 2배를 했을 때에도 안나온다면 cnt=-1이다
                cnt=-1;
                break;
            }
            
            if(q1.isEmpty() || q2.isEmpty()){ //q1이나 q2가 비었을 경우 더이 상 못나누므로 -1을 answer 로 넣어준다.
                cnt=-1;
                break;
            }
            if(sum_a<sum_b){ //q1 이 q2보다 작을 경우
                int num = q2.poll();
                q1.add(num);
                sum_b-=num;
                sum_a+=num;
            }else if(sum_a>sum_b){ //q2가 q1보다 작을 경우
                int num = q1.poll();
                q2.add(num);
                sum_a-=num;
                sum_b+=num;
            }else if(sum_a==sum_b){
                break;
            }
            cnt++;
// 실행 결과
        
            // System.out.println(q1);
            // System.out.println(q2);
            // break;
        }
        answer =cnt;
        return answer;
    }
}

/**
* 고려했어야 하는 부분 
*/
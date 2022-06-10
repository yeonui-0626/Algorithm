package Baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;
/*

bfs로 푸는걸 생각하기까지 오래 걸렸다.ㅜㅜ
숫자는 9~0로 한정 되어있기 때문에 최대 감소수가 9876543210으로 고정되어있어
값을 정할 수 없는(정답이 -1) 인 경우를 자릿수가 11 이상인 경우는 구할 수 없는 경우로 제외해야했다.
9876543210이 최대값임은 생각했지만 자릿수로 판별하는 것은 생각하지 못했다.

그리고 bfs 함수로 들어갈 때 불필요한 조건(cnt==N)을 주어서 계속 오답이 나왔었다.

 */
public class BJ_1038_감소하는수 {
    static int N,cnt=0;

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        N = sc.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
       for(long i = 0 ;i<=9;i++){
           pq.offer(i);
       }
        bfs(pq,1);
    }

    static void bfs(PriorityQueue<Long> pq, int level){
        if(level>=11){
            System.out.println(-1);
            return;
        }
        PriorityQueue<Long> nextPQ = new PriorityQueue<>();
        while(!pq.isEmpty()){
            long current = pq.poll();
            if(cnt==N){
                System.out.println(current);
                return;
            }
            cnt++;
            for(long i = (current/(int)Math.pow(10,level-1))+1; i <= 9; i++){
                if(i == current) continue;
                long num = i*(long) Math.pow(10,level)+current;
                nextPQ.offer(num);
            }
        }
        bfs(nextPQ,level+1);
    }
}

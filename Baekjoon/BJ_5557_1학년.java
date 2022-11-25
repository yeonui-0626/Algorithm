package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*

1. +, - 둘중 하나
2. 중간 정답이 0이상 20이하
3. 마지막 수가 정답
4. 수 -> 배열에 저장 N-1개 ?
5. 탐색 종료 조건
    1. 중간 정답 0 이상, 20이하 걍 return
    2. 끝까지 갔을 때, -> 정답 0인지 확인하기
 */
public class BJ_5557_1학년 {
    static int N ,ANS, CNT;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(bf.readLine());
        nums = new int[N-1];
        st = new StringTokenizer(bf.readLine());

        for(int i = 0; i < N-1;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ANS = Integer.parseInt(st.nextToken());
        dfs(0,0, new boolean[N-1]);
        System.out.println(CNT);
    }

    static void dfs(int idx, int result, boolean[] visit){
        if( idx == N-1){
            if( result == ANS) CNT++;
            return;
        }

        if(result < 0 || result > 20) return;

        for(int i = idx; i<N-1; i++){
            if(visit[i]) continue;
            visit[i] = true;
            dfs(idx+1,result + nums[i],visit);
            dfs(idx+1,result - nums[i],visit);
            visit[i] = false;
        }
    }
}

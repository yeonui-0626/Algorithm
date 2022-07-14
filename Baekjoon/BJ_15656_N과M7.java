package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
wow... StringBuilder를 쓰지 않으면 시간초과가 난다고 한다................
StringBuilder를 쓰는 습관을 가지자 !!
 */
public class BJ_15656_N과M7 {
    static int N,M,nums[] , selected[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        selected = new int[M];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        bfs(0);
        System.out.println(sb.toString());

    }
    static void bfs(int cnt ){
        if(cnt == M){
            for(int i = 0 ; i < M;i++){
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i<N;i++){
            selected[cnt] = nums[i];
            bfs(cnt+1);
        }

    }
}

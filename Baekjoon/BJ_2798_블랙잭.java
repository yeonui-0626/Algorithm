package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2798_블랙잭 {
    static int N,M;
    static int[] nums;
    static int ans=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        select(0,0,new boolean[N], 0);

        System.out.println(ans);



    static void select(int cnt, int idx, boolean[] visited, int sum){
        if(cnt == 3){
            if(sum <= M) ans = Math.max(ans, sum);
            return;
        }

        for(int i =  idx; i<N;i++){
            if(visited[i]) continue;
            visited[i] = true;
            select(cnt+1, i+1,visited,sum+nums[i]);
            visited[i] = false;
        }
    }

}

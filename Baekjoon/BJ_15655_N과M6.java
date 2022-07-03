package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15655_N과M6{

    static int N, M;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];


        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0,0,0);

    }
    static void dfs(int flag, int cnt, int idx){
        if( cnt == M ){
            for(int i = 0 ; i < N;i++){
                if((flag & 1 << i) > 0){
                    System.out.print(nums[i]+" ");
                }
            }
            System.out.println();
            return;
        }
        for(int i = idx; i < N; i++){
            if((flag & 1 << i) != 0) continue;
            dfs(flag | 1 << i, cnt + 1 , i+1);
        }

    }
}

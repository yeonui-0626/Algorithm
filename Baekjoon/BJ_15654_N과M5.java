package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15654_N과M5 {

    static int N,M;
    static int[] nums;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        nums = new int[N];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums); // 정렬
        dfs(0,0);
    }
    static void dfs(int cnt, int idx ){

        if( cnt == M ){
            for(int a : selected)
                System.out.print(a+" ");
            System.out.println();
            return;
        }

        for(int i = idx; i<N; i++){
            selected[cnt] = nums[i];
            dfs(cnt+1,i);
        }

    }
}

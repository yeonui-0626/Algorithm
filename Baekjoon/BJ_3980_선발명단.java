package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_3980_선발명단 {
    static int ans, arr[][] = new int[11][11];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for(int t = 0; t<T;t++){
            ans = 0;
            for(int i = 0 ;i<11;i++){
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for(int j = 0; j< 11;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dfs(0,0,new boolean[11]);
            System.out.println(ans);
        }
    }

    static void dfs(int i, int sum, boolean[] visit){
        if( i == 11){
            ans = Math.max(ans,sum);
            return;
        }
        for(int j = 0; j<11;j++){
            if(visit[j] || arr[i][j] == 0) continue;
            visit[j] = true;
            dfs(i+1, sum + arr[i][j], visit);
            visit[j] = false;
        }
    }
}

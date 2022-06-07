package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

소수점 곱이라서 곱할수록 값은 작아진다.
그래서 경로 중, 곱이 max 보다 이미 작다면 더 이상 탐색할 필요가 없다.

 */

public class SWEA_1865_동철이의일분배 {

    static int N;
    static double max;
    static int[][] percents;
    static boolean visit[];

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(bf.readLine());

        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(bf.readLine());
            percents = new int[N][N];
            visit = new boolean[N];
            max = 0;

            for(int i = 0; i<N; i++) {
                st = new StringTokenizer(bf.readLine());
                for(int j = 0; j<N;j++){
                    percents[i][j] = Integer.parseInt(st.nextToken());
                }
            }// input


            dfs(0, 1);
            max = Math.round(max*100000000)/1000000.0;
            System.out.printf("#%d %.6f\n",t,max);

        }
    }

    static void dfs(int cnt,  double total){

        if(max > total) return;

        if(cnt == N){
            if( max < total) max = total;
            return;
        }

        for(int i = 0 ; i <N;i++){
            if(visit[i] || percents[cnt][i] == 0) continue;
            visit[i] = true;
            dfs(cnt+1, total * (percents[cnt][i]*0.01));
            visit[i] = false;
        }

    }
}

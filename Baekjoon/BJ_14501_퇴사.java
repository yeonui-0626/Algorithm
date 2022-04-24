package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501_퇴사 {
    static int N;
    static int[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(bf.readLine());

        input = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }



        Combi(1,0);
        System.out.println(maxCost);
    }

    static int maxCost=0;

    static void Combi(int n,int cost) {
        if (n > N) {
            maxCost = maxCost > cost?maxCost:cost;

            return;
        }
        if(input[n][0]+n <=N+1){
            Combi(n + input[n][0], cost+input[n][1]);
        }
        Combi(n + 1,cost);
    }
}

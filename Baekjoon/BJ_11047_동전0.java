package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for(int i = 0 ; i<N;i++){
            coins[i] = Integer.parseInt(bf.readLine());
        }

        int sum = 0;
        for(int i = N-1; i>=0;i--){
            if(coins[i] <= K){
                sum += K/coins[i];
                K %=coins[i];
            }
            if(K <=0 ) break;
        }
        System.out.println(sum);
    }
}

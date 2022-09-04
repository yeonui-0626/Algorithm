package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_7453_합이0인네정수 {

    static int N;
    static long nums[][];
    static long sum1[];
    static long sum2[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(bf.readLine());
        nums = new long[N][4];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < 4 ;j ++){
                nums[i][j] = Long.parseLong(st.nextToken());
            }
        }

        sum1 = new long[N*N];
        sum2 = new long[N*N];
        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N/2; j++){
                sum1[i*N + j] = nums[0][j] + nums[1][j];
                sum1[i*N + j] = nums[2][j] + nums[3][j];
            }
        }



    }
}

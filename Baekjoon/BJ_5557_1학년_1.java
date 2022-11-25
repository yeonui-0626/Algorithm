package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*

dp[i][j] i번째 등식까지의 합이 j 인 경우



* */
public class BJ_5557_1학년_1 {
    static int N;
    static int[] nums;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        nums = new int[N];
        dp = new int[N][21]; // 0 : 숫자
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i = 0 ; i < N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
            dp[i][0] = nums[i];
        }



    }
}

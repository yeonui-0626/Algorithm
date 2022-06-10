package Baekjoon;

import java.io.*;
import java.util.Scanner;

public class BJ_10819_차이를최대로 {
    static int N, max=Integer.MIN_VALUE;
    static int[] arr = new int[10];
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0; i < N; i++) arr[i] = sc.nextInt();
        for(int i = 0; i < N; i++) calc(0,arr[i],0,0 | 1<<i);
        System.out.println(max);
    }
    static void calc(int cnt, int prev, int sum,int flag){
        if(cnt == N-1){
            max = Math.max(max,sum);
            return;
        }
        for(int i = 0; i < N;i++){
            if((flag & 1<<i) > 0) continue;
            calc(cnt+1, arr[i], sum + Math.abs(prev-arr[i]),flag | 1<<i);
        }
    }
}


package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
가장 긴 증가하는 부분 수열
 */
public class BJ_11053_LIS {
    public static void main(String[] args) throws IOException {            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = null;

            int N = Integer.parseInt(br.readLine());
            int[] arr= new int[N];

            st = new StringTokenizer(br.readLine()," ");
            for(int i = 0; i< N ;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] lis = new int[N];
            Arrays.fill(lis,1);
            int max=0;
            for(int i = 0; i< N ;i++){
                for(int j = i-1;j>=0;j--){
                    if(arr[i] > arr[j]) {
                        lis[i] = Math.max(lis[i], lis[j] + 1);
                    }
                }
                max = Math.max(max, lis[i]);
            }
            System.out.println(max);
    }
}
